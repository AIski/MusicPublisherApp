package pl.aIski.dto;

import lombok.Data;

import java.util.List;

@Data
public class SongDTO {
    private Long id;
    private String name;
    private List<ArtistDTO> artists;
}
