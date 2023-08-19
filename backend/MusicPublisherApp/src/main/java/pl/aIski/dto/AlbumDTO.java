package pl.aIski.dto;

import lombok.Data;

import java.util.List;

@Data
public class AlbumDTO {
    private Long id;
    private String name;
    private List<SongDTO> songs;
    private double suggestedPrice;
}
