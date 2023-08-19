package pl.aIski.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.aIski.dto.ArtistDTO;
import pl.aIski.entity.Artist;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    List<ArtistDTO> artistsToArtistsDtos(List<Artist> artist);

    @Mapping(target = "countryName", source = "country.name")
    ArtistDTO artistToArtistDto(Artist artist);
}
