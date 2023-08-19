package pl.aIski.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.aIski.dto.CountryDTO;
import pl.aIski.mapper.CountryMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceFacadeImpl implements CountryServiceFacade{
    private final CountryService countryService;
    private final CountryMapper mapper;
    @Override
    public List<CountryDTO> getAll() {
        return mapper.toCountriesDTOs(countryService.getAll());
    }
}
