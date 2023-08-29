package pl.alski.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.aIski.dao.ArtistRepository;
import pl.aIski.dto.ArtistCreationRequest;
import pl.aIski.dto.CountryDTO;
import pl.aIski.entity.Artist;
import pl.aIski.entity.Country;
import pl.aIski.service.ArtistServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArtistServiceImplTest {

    @Mock
    private ArtistRepository artistRepository;

    @InjectMocks
    private ArtistServiceImpl artistServiceImpl;


    @Test
    public void testCreateArtist() {
        //given
        ArtistCreationRequest request = ArtistCreationRequest.builder()
                .firstName("George")
                .lastName("Ortington")
                .musicType("Rock")
                .age(30)
                .build();

        CountryDTO countryDTO = new CountryDTO(1L, "USA");
        request.setCountry(countryDTO);

        Artist expectedArtist = Artist.builder()
                .firstName("George")
                .lastName("Ortington")
                .musicType("Rock")
                .age(30)
                .build();

        Country country = new Country(1L, "USA");
        expectedArtist.setCountry(country);

        when(artistRepository.save(any(Artist.class))).thenReturn(expectedArtist);

        //when
        Artist createdArtist = artistServiceImpl.createArtist(request);

        //then
        assertEquals("George", createdArtist.getFirstName());
        assertEquals("Ortington", createdArtist.getLastName());
        assertEquals("Rock", createdArtist.getMusicType());
        assertEquals(30, createdArtist.getAge());
        assertEquals(1L, createdArtist.getCountry().getId());
        assertEquals("USA", createdArtist.getCountry().getName());

        verify(artistRepository, times(1)).save(any(Artist.class));
    }

    @Test
    public void testGetAllArtists() {
        //given
        Artist artist1 = new Artist();
        artist1.setFirstName("John");

        Artist artist2 = new Artist();
        artist2.setFirstName("Alice");

        Artist artist3 = new Artist();
        artist3.setFirstName("Charlie");

        Artist artist4 = new Artist();
        artist4.setFirstName("Bob");

        List<Artist> artists = Arrays.asList(artist1, artist2, artist3, artist4);

        when(artistRepository.findAll()).thenReturn(artists);

        //when
        List<Artist> retrievedArtists = artistServiceImpl.getAll();

        //then
        assertEquals(4, retrievedArtists.size());
        assertEquals("Alice", retrievedArtists.get(0).getFirstName());
        assertEquals("Bob", retrievedArtists.get(1).getFirstName());
        assertEquals("Charlie", retrievedArtists.get(2).getFirstName());
        assertEquals("John", retrievedArtists.get(3).getFirstName());
    }


}














