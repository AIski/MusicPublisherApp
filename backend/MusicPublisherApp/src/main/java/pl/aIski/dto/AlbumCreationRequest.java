package pl.aIski.dto;

import lombok.Data;

import java.util.List;

@Data
public class AlbumCreationRequest {
    private String name;
    private List<SongCreationRequest> songs;
    private double suggestedPrice;
}
