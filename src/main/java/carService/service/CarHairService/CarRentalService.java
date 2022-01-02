package carService.service.CarHairService;

import carService.converter.CarRentalAndReservationConverter;
import carService.dto.entity.carHairService.CarRentalDTO;
import carService.dto.entity.carHairService.UpdateCarRentalDTO;
import carService.entity.CarHairService.CarRental;
import carService.entity.CarHairService.Reservation;
import carService.converter.mapper.UpdateCarRentalMapper;
import carService.repository.CarHairService.CarRentalRepository;
import carService.repository.CarHairService.ReservationRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Getter
public class CarRentalService {

    private final CarRentalRepository carRentalRepository;
    private final ReservationRepository reservationRepository;

    private final UpdateCarRentalMapper updateCarRentalMapper = UpdateCarRentalMapper.INSTANCE;
    CarRentalAndReservationConverter converter = new CarRentalAndReservationConverter();

    public CarRentalService(CarRentalRepository carRentalRepository, ReservationRepository reservationRepository) {
        this.carRentalRepository = carRentalRepository;
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public CarRental save(CarRental newCarRental) {
        carRentalRepository.save(newCarRental);
        for (Reservation mod : newCarRental.getReservations()) {
            mod.setCarRental(newCarRental);
            reservationRepository.save(mod);
        }
        return carRentalRepository.save(newCarRental);
    }

    @Transactional
    public List<CarRentalDTO> getAll() {
        return converter.carRentalDTO(carRentalRepository.findAll());
    }


    public CarRental editCarRental( CarRental carRentalDetails) {

        UpdateCarRentalDTO updateCarRentalDTO = updateCarRentalMapper.toDto(carRentalDetails);
        CarRental carRental = updateCarRentalMapper.toEntity(updateCarRentalDTO);

        return carRentalRepository.save(carRental);
    }


    public List<CarRental> deleteCarRental(Long id) {

        carRentalRepository.deleteById(id);

        return carRentalRepository.findAll();
    }
}
