package pl.aIski.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.aIski.dto.AlbumCreationRequest;
import pl.aIski.dto.AlbumDTO;
import pl.aIski.service.AlbumServiceFacade;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/album")
@AllArgsConstructor
public class AlbumController {

    private final AlbumServiceFacade albumService;

    @GetMapping()
    public ResponseEntity<List<AlbumDTO>> getAlbums() {
        List<AlbumDTO> albums = albumService.getAll();
        return albums != null ? ResponseEntity.ok(albums) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createAlbum(@RequestBody AlbumCreationRequest albumCreationRequest) {
        AlbumDTO album = albumService.createAlbum(albumCreationRequest);
        return album != null ? ResponseEntity.ok().build() : ResponseEntity.internalServerError().build();
    }
}
