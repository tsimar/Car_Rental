package carService.converter.mapper;

import carService.dto.entity.carHairService.ReservationDTO;
import carService.entity.CarHairService.Reservation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-17T19:13:28+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public List<ReservationDTO> toDto(List<Reservation> entity) {
        if ( entity == null ) {
            return null;
        }

        List<ReservationDTO> list = new ArrayList<ReservationDTO>( entity.size() );
        for ( Reservation reservation : entity ) {
            list.add( reservationToReservationDTO( reservation ) );
        }

        return list;
    }

    @Override
    public List<Reservation> toEntity(List<ReservationDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Reservation> list = new ArrayList<Reservation>( dto.size() );
        for ( ReservationDTO reservationDTO : dto ) {
            list.add( reservationDTOToReservation( reservationDTO ) );
        }

        return list;
    }

    protected ReservationDTO reservationToReservationDTO(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setId( reservation.getId() );
        reservationDTO.setReservationDate( reservation.getReservationDate() );
        reservationDTO.setFromDateReservation( reservation.getFromDateReservation() );
        reservationDTO.setOfDateReservation( reservation.getOfDateReservation() );

        return reservationDTO;
    }

    protected Reservation reservationDTOToReservation(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setId( reservationDTO.getId() );
        reservation.setReservationDate( reservationDTO.getReservationDate() );
        reservation.setFromDateReservation( reservationDTO.getFromDateReservation() );
        reservation.setOfDateReservation( reservationDTO.getOfDateReservation() );

        return reservation;
    }
}
