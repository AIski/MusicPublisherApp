package pl.aIski.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "ALBUM")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name="NAME")
    private String name;

    @OneToMany
    @JoinTable(name = "ALBUM_SONG",
            joinColumns = @JoinColumn(name = "ALBUM_ID"),
            inverseJoinColumns = @JoinColumn(name = "SONG_ID"))
    private List<Song> songs;

    @Column(name="SUGGESTED_PRICE")
    private double suggestedPrice;

}
