package pl.aIski.dto;

import java.util.List;

public class AlbumCreationRequest {
    private String name;
    private List<SongCreationRequest> songs;
    private double suggestedPrice;
}
