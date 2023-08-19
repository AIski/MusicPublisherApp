package pl.aIski.dto;

import lombok.Data;

@Data
public class ArtistCreationRequest {
        private String firstName;
        private String lastName;
        private String musicType;
        private int Age;
        private CountryDTO country;
    }

