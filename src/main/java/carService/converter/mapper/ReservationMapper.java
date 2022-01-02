package carService.converter.mapper;


import carService.dto.entity.carHairService.ReservationDTO;
import carService.entity.CarHairService.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservationMapper {
    ReservationMapper INSTANCE= Mappers.getMapper(ReservationMapper.class);

   List<ReservationDTO> toDto(List<Reservation> entity);

    List<Reservation> toEntity (List<ReservationDTO> dto);

}
