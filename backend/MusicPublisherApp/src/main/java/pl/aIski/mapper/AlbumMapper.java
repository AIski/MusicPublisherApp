package pl.aIski.mapper;

import org.mapstruct.Mapper;
import pl.aIski.dto.AlbumDTO;
import pl.aIski.entity.Album;

import java.util.List;

@Mapper(componentModel = "spring", uses = SongMapper.class)
public interface AlbumMapper {
    AlbumDTO albumToAlbumDto(Album album);

    List<AlbumDTO> albumsToAlbumDtos(List<Album> albums);

}
