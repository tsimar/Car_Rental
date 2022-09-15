package carService.converter.mapper.car;

import carService.dto.entity.carHairService.car.CarDepartMainDTO;
import carService.entity.Car.CarRentalDepartment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-15T21:55:48+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class CarDepartMainMapperImpl implements CarDepartMainMapper {

    @Override
    public List<CarDepartMainDTO> toDto(List<CarRentalDepartment> entity) {
        if ( entity == null ) {
            return null;
        }

        List<CarDepartMainDTO> list = new ArrayList<CarDepartMainDTO>( entity.size() );
        for ( CarRentalDepartment carRentalDepartment : entity ) {
            list.add( carRentalDepartmentToCarDepartMainDTO( carRentalDepartment ) );
        }

        return list;
    }

    @Override
    public List<CarRentalDepartment> toEntity(List<CarDepartMainDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<CarRentalDepartment> list = new ArrayList<CarRentalDepartment>( dto.size() );
        for ( CarDepartMainDTO carDepartMainDTO : dto ) {
            list.add( carDepartMainDTOToCarRentalDepartment( carDepartMainDTO ) );
        }

        return list;
    }

    protected CarDepartMainDTO carRentalDepartmentToCarDepartMainDTO(CarRentalDepartment carRentalDepartment) {
        if ( carRentalDepartment == null ) {
            return null;
        }

        CarDepartMainDTO carDepartMainDTO = new CarDepartMainDTO();

        carDepartMainDTO.setId( carRentalDepartment.getId() );
        carDepartMainDTO.setLogo( carRentalDepartment.getLogo() );
        carDepartMainDTO.setNameRental( carRentalDepartment.getNameRental() );
        carDepartMainDTO.setCity( carRentalDepartment.getCity() );
        carDepartMainDTO.setAddress( carRentalDepartment.getAddress() );

        return carDepartMainDTO;
    }

    protected CarRentalDepartment carDepartMainDTOToCarRentalDepartment(CarDepartMainDTO carDepartMainDTO) {
        if ( carDepartMainDTO == null ) {
            return null;
        }

        CarRentalDepartment carRentalDepartment = new CarRentalDepartment();

        carRentalDepartment.setId( carDepartMainDTO.getId() );
        carRentalDepartment.setLogo( carDepartMainDTO.getLogo() );
        carRentalDepartment.setNameRental( carDepartMainDTO.getNameRental() );
        carRentalDepartment.setCity( carDepartMainDTO.getCity() );
        carRentalDepartment.setAddress( carDepartMainDTO.getAddress() );

        return carRentalDepartment;
    }
}
