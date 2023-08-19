package pl.aIski.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.aIski.dto.ArtistCreationRequest;
import pl.aIski.dto.ArtistDTO;
import pl.aIski.service.ArtistServiceFacade;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/artist")
@AllArgsConstructor
public class ArtistController {
    private final ArtistServiceFacade artistService;

    @GetMapping()
    public ResponseEntity<List<ArtistDTO>> getArtists() {
        List<ArtistDTO> artists = artistService.getAll();
        return artists != null ? ResponseEntity.ok(artists) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createArtist(@RequestBody ArtistCreationRequest artistCreationRequest) {
        ArtistDTO artist = artistService.createArtist(artistCreationRequest);
        return artist != null ? ResponseEntity.ok().build() : ResponseEntity.internalServerError().build();
    }


}
