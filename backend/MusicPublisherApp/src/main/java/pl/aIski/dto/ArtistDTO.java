package pl.aIski.dto;

import lombok.Data;

@Data
public class ArtistDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String musicType;
    private int age;
    private String countryName;
}

