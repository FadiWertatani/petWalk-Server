package org.example.petwalk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class QRConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQR;

    @OneToOne
    @JoinColumn(name = "idReservation", nullable = false)
    private Reservation reservation;

    @Column(nullable = false)
    private Boolean confirmation;
}