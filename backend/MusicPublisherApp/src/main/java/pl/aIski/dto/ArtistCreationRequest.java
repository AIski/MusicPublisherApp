package pl.aIski.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtistCreationRequest {
        private String firstName;
        private String lastName;
        private String musicType;
        private int age;
        private CountryDTO country;
    }

