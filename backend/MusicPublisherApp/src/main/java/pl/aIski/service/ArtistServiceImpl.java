package pl.aIski.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.aIski.dao.ArtistRepository;
import pl.aIski.dto.ArtistCreationRequest;
import pl.aIski.entity.Artist;
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
        Artist artist = mapper.artistCreationRequestToArtist(artistCreationRequest);
        log.info("Creating artist: "+ artist.toString());
        artistRepository.save(artist);
        log.info("Saved artist to the DB.");
        return artist;
    }
}
