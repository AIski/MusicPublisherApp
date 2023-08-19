package pl.aIski.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.aIski.entity.Country;

@RepositoryRestResource
public interface CountryRepository extends JpaRepository<Country, Long> {
}
