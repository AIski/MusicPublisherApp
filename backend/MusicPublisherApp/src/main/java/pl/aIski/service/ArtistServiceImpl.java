package pl.aIski.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.aIski.dao.ArtistRepository;
import pl.aIski.dto.ArtistCreationRequest;
import pl.aIski.entity.Artist;
import pl.aIski.entity.Country;
import pl.aIski.mapper.ArtistMapper;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ArtistServiceImpl implements  ArtistService{
    private final ArtistRepository artistRepository;
    private final ArtistMapper mapper;

    @Override
    public List<Artist> getAll() {
        log.info("Getting All Artists from the DB.");
        return artistRepository.findAll();
    }

    @Override
    public Artist createArtist(ArtistCreationRequest artistCreationRequest) {
        Artist artist = new Artist();
        fetchArtistDetailsFromRequest(artistCreationRequest, artist);
        log.info("Creating artist: "+ artist.toString());
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
        artist.setCountry(country);
    }
}
