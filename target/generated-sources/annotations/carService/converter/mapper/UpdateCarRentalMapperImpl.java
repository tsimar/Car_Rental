package carService.converter.mapper;

import carService.dto.entity.carHairService.UpdateCarRentalDTO;
import carService.entity.CarHairService.CarRental;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-06T00:39:51+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class UpdateCarRentalMapperImpl implements UpdateCarRentalMapper {

    @Override
    public UpdateCarRentalDTO toDto(CarRental entity) {
        if ( entity == null ) {
            return null;
        }

        UpdateCarRentalDTO updateCarRentalDTO = new UpdateCarRentalDTO();

        updateCarRentalDTO.setId( entity.getId() );
        updateCarRentalDTO.setRentalDate( entity.getRentalDate() );
        updateCarRentalDTO.setCommentsRental( entity.getCommentsRental() );
        updateCarRentalDTO.setCommentsCustomer( entity.getCommentsCustomer() );
        updateCarRentalDTO.setEmployeeId( entity.getEmployeeId() );

        return updateCarRentalDTO;
    }

    @Override
    public CarRental toEntity(UpdateCarRentalDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CarRental carRental = new CarRental();

        carRental.setEmployeeId( dto.getEmployeeId() );
        carRental.setRentalDate( dto.getRentalDate() );
        carRental.setCommentsRental( dto.getCommentsRental() );
        carRental.setCommentsCustomer( dto.getCommentsCustomer() );
        carRental.setId( dto.getId() );

        return carRental;
    }
}
