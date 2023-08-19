package pl.aIski.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "COUNTRY")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name="NAME")
    private String name;
}
