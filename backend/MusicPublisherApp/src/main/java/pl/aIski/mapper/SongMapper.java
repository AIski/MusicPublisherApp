package pl.aIski.mapper;

import org.mapstruct.Mapper;
import pl.aIski.dto.SongDTO;
import pl.aIski.entity.Song;

import java.util.List;

@Mapper(componentModel = "spring", uses = ArtistMapper.class)
public interface SongMapper {
    List<SongDTO> toSongsDTOs(List<Song> songs);
}
