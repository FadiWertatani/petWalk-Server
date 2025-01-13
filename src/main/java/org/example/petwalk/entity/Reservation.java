package org.example.petwalk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numSerie = UUID.randomUUID().toString();

    @ManyToOne(optional = true) // Le propriétaire peut être facultatif
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "reservation_promeneurs",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "promeneur_id")
    )
    private List<User> promeneurs = new ArrayList<>();

    @Column(nullable = false) // Rend obligatoire l'heure de début
    private LocalTime heurDebut;

    @Column(nullable = false) // Rend obligatoire l'heure de fin
    private LocalTime heurFin;
}
