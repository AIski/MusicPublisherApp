package pl.aIski.service;

import org.springframework.stereotype.Service;
import pl.aIski.dto.ArtistCreationRequest;
import pl.aIski.dto.ArtistDTO;

import java.util.List;

@Service
public interface ArtistServiceFacade {
    List<ArtistDTO> getAll();

    ArtistDTO createArtist(ArtistCreationRequest artistCreationRequest);
}
