package pl.aIski.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.aIski.dto.CountryDTO;
import pl.aIski.service.CountryServiceFacade;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/country")
@AllArgsConstructor
public class CountryController {
    private final CountryServiceFacade countryFacade;

    @GetMapping()
    public ResponseEntity<List<CountryDTO>> getCountries() {
        List<CountryDTO> countries = countryFacade.getAll();
        return countries != null ? ResponseEntity.ok(countries) : ResponseEntity.notFound().build();
    }

}
