package org.example.petwalk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tarif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarif;

    @Column(nullable = false)
    private Long idPromeneur;

    @Column(nullable = false)
    private Double baseTarif;

    @Column(nullable = false)
    private Double tarifDynamique;

    @Column(nullable = false)
    private String criteres;

    @ManyToOne
    @JoinColumn(name = "idReservation")
    private Reservation reservation;
}
