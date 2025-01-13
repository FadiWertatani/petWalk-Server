package org.example.petwalk.restController;

import org.example.petwalk.entity.Reservation;
import org.example.petwalk.entity.Tarif;
import org.example.petwalk.services.interfaces.IResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/res")
public class ResController {

    @Autowired
    private IResService resService;

    @PostMapping("/reservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return resService.addReservation(reservation);
    }

    @PutMapping("/reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return resService.updateReservation(reservation);
    }

    @DeleteMapping("/reservation")
    public void deleteLastReservation() {
        resService.deleteLastReservation();
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return resService.getAllReservations();
    }

    @PostMapping("/tarif/{reservationId}")
    public Tarif calculateTarif(@PathVariable Long reservationId) {
        return resService.calculateTarif(reservationId);
    }

    @GetMapping("/qrcode/{code}")
    public String generateQrCode(@PathVariable String code) {
        return resService.generateQrCode(code);
    }
}
