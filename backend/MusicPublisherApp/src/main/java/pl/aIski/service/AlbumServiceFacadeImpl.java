package pl.aIski.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import pl.aIski.dto.AlbumCreationRequest;
import pl.aIski.dto.AlbumDTO;
import pl.aIski.entity.Album;
import pl.aIski.mapper.AlbumMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class AlbumServiceFacadeImpl implements AlbumServiceFacade{
    private final AlbumService albumService;
    private final AlbumMapper mapper;


    @Override
    public List<AlbumDTO> getAll() {
        List<Album> albums = albumService.getAll();
        return mapper.albumsToAlbumDtos(albums);
    }

    @Override
    public AlbumDTO createAlbum(AlbumCreationRequest albumCreationRequest) {
        Album album = albumService.createAlbum(albumCreationRequest);
        return mapper.albumToAlbumDto(album);
    }
}
