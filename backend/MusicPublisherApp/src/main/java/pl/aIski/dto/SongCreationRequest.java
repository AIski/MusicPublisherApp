package pl.aIski.dto;

import lombok.Data;

import java.util.List;
@Data
public class SongCreationRequest {
    private String name;
    private List<Integer> artistsIds;
}
