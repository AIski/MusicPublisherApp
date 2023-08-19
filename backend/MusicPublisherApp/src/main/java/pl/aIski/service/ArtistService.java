package pl.aIski.service;

import org.springframework.stereotype.Service;
import pl.aIski.dto.ArtistCreationRequest;
import pl.aIski.entity.Artist;

import java.util.List;

@Service
public interface ArtistService {
    List<Artist> getAll();

    Artist createArtist(ArtistCreationRequest artistCreationRequest);
}
