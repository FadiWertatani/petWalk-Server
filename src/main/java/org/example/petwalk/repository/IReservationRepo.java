package org.example.petwalk.repository;

import org.example.petwalk.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservationRepo extends JpaRepository<Reservation, Long> {

    // Trouver toutes les réservations par l'ID de l'utilisateur
    List<Reservation> findByUser_Id(Long userId);

    // Trouver une réservation par son ID
    Reservation findReservationById(Long id);

    // Trouver les réservations par leur statut
    List<Reservation> findReservationsByStatus(String status);
}
