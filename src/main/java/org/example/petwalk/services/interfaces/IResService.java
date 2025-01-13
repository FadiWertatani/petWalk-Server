package org.example.petwalk.services.interfaces;

import org.example.petwalk.entity.Reservation;
import org.example.petwalk.entity.Tarif;

import java.util.List;

public interface IResService {
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteLastReservation();
    List<Reservation> getAllReservations();
    Tarif calculateTarif(Long reservationId);
    String generateQrCode(String code);
}
