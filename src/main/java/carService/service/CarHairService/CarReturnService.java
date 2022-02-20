package carService.service.CarHairService;

import carService.entity.CarHairService.CarRental;
import carService.entity.CarHairService.CarReturn;
import carService.repository.CarHairService.CarReturnRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarReturnService {
    private final CarReturnRepository carReturnRepository;

    public CarReturnService (CarReturnRepository carReturnRepository){
        this.carReturnRepository=carReturnRepository;
    }
    public List<CarReturn> getAllByCompanyIdAndUserId(Long companyId, Long userId) {
        return carReturnRepository.findAllByCompanyIdAndUserId(companyId,userId);
    }
    public List<CarReturn> getAllByCompId(Long companyId) {

        return carReturnRepository.findAllByCompanyId(companyId);
    }
    @Transactional
    public List<CarReturn> getAll() {
        return carReturnRepository.findAll();
    }
}
