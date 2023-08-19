package pl.aIski.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

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


    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private List<Song> songs;

    @Column(name="SUGGESTED_PRICE")
    private double suggestedPrice;


}
