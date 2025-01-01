package org.example.petwalk.services.implementations;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.Reservation;
import org.example.petwalk.repository.IReservationRepo;
import org.example.petwalk.services.interfaces.IReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationImpl implements IReservationService {

    private final IReservationRepo reservationRepo;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Reservation existingReservation = reservationRepo.findById(reservation.getId())
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        existingReservation.setStartTime(reservation.getStartTime());
        existingReservation.setEndTime(reservation.getEndTime());
        existingReservation.setStatus(reservation.getStatus());
        return reservationRepo.save(existingReservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        Reservation existingReservation = reservationRepo.findById(reservation.getId())
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservationRepo.delete(existingReservation);
    }
}
