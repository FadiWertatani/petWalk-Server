package org.example.petwalk.services.interfaces;

import org.example.petwalk.entity.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> getAllReservations();

    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(Reservation reservation);
}
