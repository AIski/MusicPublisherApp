package pl.aIski.mapper;

import org.mapstruct.Mapper;
import pl.aIski.dto.CountryDTO;
import pl.aIski.entity.Country;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    List<CountryDTO> toCountriesDTOs(List<Country> countries);
}
