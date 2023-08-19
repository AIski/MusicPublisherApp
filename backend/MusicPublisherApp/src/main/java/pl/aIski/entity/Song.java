package pl.aIski.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "SONG")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(name = "SONG_ARTIST",
            joinColumns = @JoinColumn(name = "SONG_ID"),
            inverseJoinColumns = @JoinColumn(name = "ARTIST_ID"))
    private List<Artist> artists;
}
