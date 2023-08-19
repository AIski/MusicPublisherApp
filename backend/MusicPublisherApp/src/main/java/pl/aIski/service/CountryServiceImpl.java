package pl.aIski.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.aIski.dao.CountryRepository;
import pl.aIski.entity.Country;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CountryServiceImpl implements CountryService{
    private final CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        log.info("Getting all the Countries from the DB.");
        return countryRepository.findAll();
    }
}
