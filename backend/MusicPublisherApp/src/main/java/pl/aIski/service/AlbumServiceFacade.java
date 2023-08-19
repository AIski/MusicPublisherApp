package pl.aIski.service;

import org.springframework.stereotype.Service;
import pl.aIski.dto.AlbumCreationRequest;
import pl.aIski.dto.AlbumDTO;

import java.util.List;

@Service
public interface AlbumServiceFacade {
    List<AlbumDTO> getAll();

    AlbumDTO createAlbum(AlbumCreationRequest albumCreationRequest);
}
