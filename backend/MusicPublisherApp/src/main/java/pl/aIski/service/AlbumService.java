package pl.aIski.service;

import org.springframework.stereotype.Service;
import pl.aIski.dto.AlbumCreationRequest;
import pl.aIski.entity.Album;

import java.util.List;

@Service
public interface AlbumService {
    List<Album> getAll();

    Album createAlbum(AlbumCreationRequest albumCreationRequest);
}
