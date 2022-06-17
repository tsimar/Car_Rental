package carService.converter.mapper.car;

import carService.dto.entity.carHairService.car.DescriptionCarDTO;
import carService.entity.Car.DescriptionCar;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-17T19:13:29+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class DescriptionCarMapperImpl implements DescriptionCarMapper {

    @Override
    public List<DescriptionCarDTO> toDto(List<DescriptionCar> entity) {
        if ( entity == null ) {
            return null;
        }

        List<DescriptionCarDTO> list = new ArrayList<DescriptionCarDTO>( entity.size() );
        for ( DescriptionCar descriptionCar : entity ) {
            list.add( descriptionCarToDescriptionCarDTO( descriptionCar ) );
        }

        return list;
    }

    @Override
    public List<DescriptionCar> toEntity(List<DescriptionCarDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<DescriptionCar> list = new ArrayList<DescriptionCar>( dto.size() );
        for ( DescriptionCarDTO descriptionCarDTO : dto ) {
            list.add( descriptionCarDTOToDescriptionCar( descriptionCarDTO ) );
        }

        return list;
    }

    protected DescriptionCarDTO descriptionCarToDescriptionCarDTO(DescriptionCar descriptionCar) {
        if ( descriptionCar == null ) {
            return null;
        }

        DescriptionCarDTO descriptionCarDTO = new DescriptionCarDTO();

        descriptionCarDTO.setId( descriptionCar.getId() );
        descriptionCarDTO.setCarBrand( descriptionCar.getCarBrand() );
        descriptionCarDTO.setModel( descriptionCar.getModel() );
        descriptionCarDTO.setCarType( descriptionCar.getCarType() );
        descriptionCarDTO.setProductionDate( descriptionCar.getProductionDate() );
        descriptionCarDTO.setColor( descriptionCar.getColor() );
        descriptionCarDTO.setCarMileage( descriptionCar.getCarMileage() );
        descriptionCarDTO.setStatusRental( descriptionCar.getStatusRental() );
        descriptionCarDTO.setCarStatus( descriptionCar.getCarStatus() );
        descriptionCarDTO.setCarRentalDepartID( descriptionCar.getCarRentalDepartID() );

        return descriptionCarDTO;
    }

    protected DescriptionCar descriptionCarDTOToDescriptionCar(DescriptionCarDTO descriptionCarDTO) {
        if ( descriptionCarDTO == null ) {
            return null;
        }

        DescriptionCar descriptionCar = new DescriptionCar();

        descriptionCar.setId( descriptionCarDTO.getId() );
        descriptionCar.setCarBrand( descriptionCarDTO.getCarBrand() );
        descriptionCar.setModel( descriptionCarDTO.getModel() );
        descriptionCar.setCarType( descriptionCarDTO.getCarType() );
        descriptionCar.setProductionDate( descriptionCarDTO.getProductionDate() );
        descriptionCar.setColor( descriptionCarDTO.getColor() );
        descriptionCar.setCarMileage( (int) descriptionCarDTO.getCarMileage() );
        descriptionCar.setStatusRental( descriptionCarDTO.getStatusRental() );
        descriptionCar.setCarStatus( descriptionCarDTO.getCarStatus() );
        descriptionCar.setCarRentalDepartID( descriptionCarDTO.getCarRentalDepartID() );

        return descriptionCar;
    }
}
