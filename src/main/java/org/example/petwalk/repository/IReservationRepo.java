package org.example.petwalk.repository;

import org.example.petwalk.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IReservationRepo extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findTopByOrderByIdDesc();

}
