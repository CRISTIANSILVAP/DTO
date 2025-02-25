package edu.eci.cvds.project.controller;

import edu.eci.cvds.project.model.Reservation;
import edu.eci.cvds.project.model.DTO.ReservationDTO;
import edu.eci.cvds.project.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
//    @PostMapping
//    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDTO resDTO) {
//        Reservation reservation = convertToEntity(resDTO); // Convertir DTO a entidad
//        Reservation createdReservation = reservationService.createReservation(reservation);
//        return ResponseEntity.ok(createdReservation);
//    }
//
//    private Reservation convertToEntity(ReservationDTO resDTO) {
//        Reservation reservation = new Reservation();
//        reservation.setId(resDTO.getId());
//        reservation.setUser(resDTO.getUser());
//        reservation.setLaboratory(resDTO.getLaboratory());
//        reservation.setStartDateTime(resDTO.getStartTime());
//        reservation.setEndDateTime(resDTO.getEndTime());
//
//        return reservation;
//    }
@PostMapping
    public Reservation createReservation(@RequestBody ReservationDTO resDTO) {
        return reservationService.createReservation(resDTO.getReservation());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable String id) {
        boolean cancelled = reservationService.cancelReservation(id);
        if (cancelled) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }
}