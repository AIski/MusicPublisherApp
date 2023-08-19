package pl.aIski.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ARTIST")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="MUSIC_TYPE")
    private String musicType;

    @Column(name="AGE")
    private int Age;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
}
