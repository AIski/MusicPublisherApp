package pl.aIski.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "COUNTRY")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
}
