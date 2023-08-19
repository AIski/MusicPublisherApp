package pl.aIski.mapper;

import org.mapstruct.Mapper;
import pl.aIski.dto.ArtistCreationRequest;
import pl.aIski.dto.ArtistDTO;
import pl.aIski.entity.Artist;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

    Artist artistCreationRequestToArtist(ArtistCreationRequest artistCreationRequest);

    List<ArtistDTO> artistsToArtistsDtos(List<Artist> artist);
   ArtistDTO artistToArtistDto(Artist artist);
}
