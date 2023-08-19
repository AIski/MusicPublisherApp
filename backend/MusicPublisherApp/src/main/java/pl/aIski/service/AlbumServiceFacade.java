package pl.aIski.service;

import pl.aIski.dto.AlbumCreationRequest;
import pl.aIski.dto.AlbumDTO;

import java.util.List;

public interface AlbumServiceFacade {
    List<AlbumDTO> getAll();

    AlbumDTO createAlbum(AlbumCreationRequest albumCreationRequest);
}
