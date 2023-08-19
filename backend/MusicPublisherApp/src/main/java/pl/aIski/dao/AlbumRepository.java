package pl.aIski.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.aIski.entity.Album;

@RepositoryRestResource
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
