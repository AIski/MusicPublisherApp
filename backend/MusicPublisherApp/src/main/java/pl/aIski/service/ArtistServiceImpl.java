package pl.aIski.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.aIski.dao.ArtistRepository;
import pl.aIski.dto.ArtistCreationRequest;
import pl.aIski.entity.Artist;
import pl.aIski.entity.Country;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    @Override
    public List<Artist> getAll() {
        log.info("Getting All Artists from the DB.");
        var artists = artistRepository.findAll();
        List<Artist> sortedArtists = artists.stream()
                .sorted(Comparator.comparing(Artist::getFirstName))
                .collect(Collectors.toList());
        return sortedArtists;
    }

    @Override
    public Artist createArtist(ArtistCreationRequest artistCreationRequest) {
        log.info("Creating new artist from artistCreationRequest: " + artistCreationRequest.toString());
        Artist artist = new Artist();
        fetchArtistDetailsFromRequest(artistCreationRequest, artist);
        log.info("Creating artist: " + artist.toString());
        artistRepository.save(artist);
        log.info("Saved artist to the DB.");
        return artist;
    }

    private void fetchArtistDetailsFromRequest(ArtistCreationRequest artistCreationRequest, Artist artist) {
        artist.setAge(artistCreationRequest.getAge());
        artist.setFirstName(artistCreationRequest.getFirstName());
        artist.setLastName(artistCreationRequest.getLastName());
        artist.setMusicType(artistCreationRequest.getMusicType());
        fetchCountryIdFromRequest(artistCreationRequest, artist);
    }

    private void fetchCountryIdFromRequest(ArtistCreationRequest artistCreationRequest, Artist artist) {
        Country country = new Country();
        country.setId(artistCreationRequest.getCountry().getId());
        country.setName(artistCreationRequest.getCountry().getName());
        artist.setCountry(country);
    }
}
