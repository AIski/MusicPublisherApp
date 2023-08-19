package pl.aIski.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.aIski.dto.SongCreationRequest;
import pl.aIski.dto.SongDTO;
import pl.aIski.entity.Artist;
import pl.aIski.entity.Song;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongMapper {

    List<SongDTO> toSongsDTOs(List<Song> songs);

    @Mapping(target = "artists", source = "artistsIds")
    Song songCreationRequestToSong(SongCreationRequest request);

    List<Artist> artistIdsToArtists(List<Integer> artistIds);

    List<Song> songCreationRequestsToSongs(List<SongCreationRequest> requests);
}
