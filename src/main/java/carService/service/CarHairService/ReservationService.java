package carService.service.CarHairService;

import carService.dto.entity.carHairService.ReservationDTO;
import carService.entity.CarHairService.Reservation;
import carService.converter.mapper.ReservationMapper;
import carService.repository.CarHairService.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper = ReservationMapper.INSTANCE;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Transactional
    public List<ReservationDTO> getAll() {
//        List<Reservation> reservations = reservationRepository.findAll();
//        List<ReservationDTO> reservationDTOS = reservationMapper.toDto(reservations);
        return reservationMapper.toDto(reservationRepository.findAll());

    }
}
