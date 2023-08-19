package pl.aIski.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.aIski.dao.AlbumRepository;
import pl.aIski.dto.AlbumCreationRequest;
import pl.aIski.dto.SongCreationRequest;
import pl.aIski.entity.Album;
import pl.aIski.entity.Artist;
import pl.aIski.entity.Song;
import pl.aIski.mapper.AlbumMapper;
import pl.aIski.mapper.SongMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final AlbumMapper mapper;
    private final SongMapper songMapper;

    @Override
    public List<Album> getAll() {
        log.info("Getting all the Albums from the DB.");
        return albumRepository.findAll();
    }

    @Override
    public Album createAlbum(AlbumCreationRequest request) {
        Album album = new Album();
        new ArrayList<>();

        album.setName(request.getName());
        album.setSuggestedPrice(request.getSuggestedPrice());

        List<Song> songs = processSongCreationRequests(request.getSongs());

        setAlbumSongsRelations(album, songs);
        log.info(songs.toString());
//        saveSongs(songs);
        log.info("Creating album: " + album.toString());

        albumRepository.save(album);
        log.info("Saved album to the DB.");
        return album;
    }

    private void saveSongs(List<Song> songs) {
    }

    private List<Song> processSongCreationRequests(List<SongCreationRequest> songCreationRequests) {
        List<Song> createdSongs = songCreationRequests.stream()
                .map(this::createSongFromRequest)
                .collect(Collectors.toList());
       return createdSongs;
    }

    private Song createSongFromRequest(SongCreationRequest songCreationRequest) {
        Song song = new Song();
        song.setName(songCreationRequest.getName());
        List<Artist> artists = songCreationRequest.getArtistsIds()
                .stream()
                .map(this::createArtistFromId)
                .collect(Collectors.toList());
        song.setArtists(artists);
        return song;
    }

    private Artist createArtistFromId(Long artistId) {
        Artist artist = new Artist();
        artist.setId(artistId);
        return artist;
    }

    private void setAlbumSongsRelations(Album album, List<Song> songs) {
        album.setSongs(songs);
        for(Song song: songs){
            song.setAlbum(album);
        }
    }
}
