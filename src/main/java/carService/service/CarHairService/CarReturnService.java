package carService.service.CarHairService;

import carService.dto.entity.carHairService.car.DescriptionCarDTO;
import carService.dto.entity.carHairService.carHairService.CarReturnByCompanyDTO;
import carService.entity.CarHairService.CarReturn;
import carService.repository.CarHairService.CarReturnRepository;
import carService.service.car.DescriptionCarService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class CarReturnService {
    private final CarReturnRepository carReturnRepository;
    private final DescriptionCarService descriptionCarService;


    public CarReturnService(CarReturnRepository carReturnRepository, DescriptionCarService descriptionCarService) {
        this.carReturnRepository = carReturnRepository;
        this.descriptionCarService = descriptionCarService;
    }


    public List<CarReturnByCompanyDTO> getAllByCompanyIdAndUserId(Long companyId, Long userId) {
        List<CarReturnByCompanyDTO> carReturnByCompanyDTOS = new LinkedList<>();
        List<DescriptionCarDTO> descriptionCarDTOS = descriptionCarService.getAllByCompanyId(companyId);
        List<CarReturn> carReturns = carReturnRepository.findAllByCompanyIdAndUserId(companyId, userId);
        for (CarReturn modReturn : carReturns) {
            CarReturnByCompanyDTO newCarReturnByCompanyDTO=new CarReturnByCompanyDTO();
            for (DescriptionCarDTO mod : descriptionCarDTOS) {
                if (modReturn.getDescriptionCarId().equals(mod.getId()) ) {
                    newCarReturnByCompanyDTO.setId(modReturn.getId());
                    newCarReturnByCompanyDTO.setCommentsReturn(modReturn.getCommentsReturn());
                    newCarReturnByCompanyDTO.setCommentsCustomer(modReturn.getCommentsCustomer());
                    newCarReturnByCompanyDTO.setReturnDate(modReturn.getReturnDate());
                    newCarReturnByCompanyDTO.setUserId(modReturn.getUserId());
                    newCarReturnByCompanyDTO.setDescriptionCarId(mod.getId());
                    newCarReturnByCompanyDTO.setCarBrand(mod.getCarBrand());
                    newCarReturnByCompanyDTO.setCarType(mod.getCarType());
                    newCarReturnByCompanyDTO.setModel(mod.getModel());
                    carReturnByCompanyDTOS.add(newCarReturnByCompanyDTO);
                    break;

                }
            }
        }

        return carReturnByCompanyDTOS;
    }

    public List<CarReturn> getAllByCompId(Long companyId) {

        return carReturnRepository.findAllByCompanyId(companyId);
    }

    @Transactional
    public List<CarReturn> getAll() {
        return carReturnRepository.findAll();
    }

    public void  updateReturn(CarReturn toUpdate, Long id){
        carReturnRepository.findById(id).ifPresent(updateReturn -> {
          updateReturn.updateFrom(toUpdate);
          carReturnRepository.save(updateReturn);
      });

    }
}
