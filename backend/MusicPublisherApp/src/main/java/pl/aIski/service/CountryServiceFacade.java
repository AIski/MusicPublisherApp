package pl.aIski.service;

import org.springframework.stereotype.Service;
import pl.aIski.dto.CountryDTO;

import java.util.List;

@Service
public interface CountryServiceFacade {
    List<CountryDTO> getAll();
}
