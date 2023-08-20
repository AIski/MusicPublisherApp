package pl.aIski.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.aIski.dto.ArtistCreationRequest;
import pl.aIski.dto.ArtistDTO;
import pl.aIski.entity.Artist;
import pl.aIski.mapper.ArtistMapper;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ArtistServiceFacadeImpl implements ArtistServiceFacade{
    private final ArtistService artistService;
    private final ArtistMapper mapper;

    @Override
    public List<ArtistDTO> getAll() {
        List<Artist> artists = artistService.getAll();
        return mapper.artistsToArtistsDtos(artists);
    }

    @Override
    public ArtistDTO createArtist(ArtistCreationRequest artistCreationRequest) {
        Artist artist = artistService.createArtist(artistCreationRequest);
        return mapper.artistToArtistDto(artist);
    }
}
