package org.example.petwalk.services.implementations;

import org.example.petwalk.entity.Reservation;
import org.example.petwalk.entity.Tarif;
import org.example.petwalk.repository.IReservationRepo;
import org.example.petwalk.repository.ITarifRepo;
import org.example.petwalk.services.interfaces.IResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class ResServiceImpl implements IResService {

    @Autowired
    private IReservationRepo reservationRepository;

    @Autowired
    private ITarifRepo tarifRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        if (reservation.getHeurDebut() == null || reservation.getHeurFin() == null) {
            throw new IllegalArgumentException("Les heures de début et de fin sont obligatoires.");
        }
        if (reservation.getHeurDebut().isAfter(reservation.getHeurFin())) {
            throw new IllegalArgumentException("L'heure de début doit être avant l'heure de fin.");
        }
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Reservation existing = reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        existing.setHeurDebut(reservation.getHeurDebut());
        existing.setHeurFin(reservation.getHeurFin());
        existing.setPromeneurs(reservation.getPromeneurs());
        return reservationRepository.save(existing);
    }

    @Override
    public void deleteLastReservation() {
        Reservation lastReservation = reservationRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new RuntimeException("Aucune réservation disponible à supprimer"));
        reservationRepository.delete(lastReservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Tarif calculateTarif(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
        double hours = Duration.between(reservation.getHeurDebut(), reservation.getHeurFin()).toHours();
        double montant = hours * 25; // Tarif fixe de 25 unités par heure

        Tarif tarif = new Tarif();
        tarif.setReservation(reservation);
        tarif.setMontant(montant);
        return tarifRepository.save(tarif);
    }

    @Override
    public String generateQrCode(String code) {
        return "https://api.qrserver.com/v1/create-qr-code/?data=" + code;
    }
}
