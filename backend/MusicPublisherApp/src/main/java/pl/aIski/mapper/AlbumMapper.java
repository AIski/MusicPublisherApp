package pl.aIski.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.aIski.dto.AlbumCreationRequest;
import pl.aIski.dto.AlbumDTO;
import pl.aIski.dto.ArtistCreationRequest;
import pl.aIski.dto.ArtistDTO;
import pl.aIski.entity.Album;
import pl.aIski.entity.Artist;

import java.util.List;

@Mapper(componentModel = "spring", uses= SongMapper.class)
public interface AlbumMapper {

    @Mapping(target = "songs", source = "songs")
    Album albumCreationRequestToAlbum(AlbumCreationRequest request);

    AlbumDTO albumToAlbumDto(Album album);
    List<AlbumDTO> albumsToAlbumDtos(List<Album> albums);

}
