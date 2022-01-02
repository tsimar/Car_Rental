package carService.controller.carHairService;


import carService.dto.entity.carHairService.ReservationDTO;
import carService.entity.CarHairService.Reservation;
import carService.service.CarHairService.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
@CrossOrigin("*")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping()
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.save(reservation));
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<ReservationDTO>> getReservation() {

        return ResponseEntity.ok(reservationService.getAll());
    }

}
