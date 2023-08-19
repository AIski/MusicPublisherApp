package pl.aIski.service;

import org.springframework.stereotype.Service;
import pl.aIski.entity.Country;

import java.util.List;

@Service
public interface CountryService {
    List<Country> getAll();
}
