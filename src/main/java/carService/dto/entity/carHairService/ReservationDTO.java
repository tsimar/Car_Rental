package carService.dto.entity.carHairService;

import lombok.Data;

import java.util.Date;


public class ReservationDTO {
    private Long id;
    private Date reservationDate;
    private Date fromDateReservation;
    private Date ofDateReservation;

    public ReservationDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getFromDateReservation() {
        return fromDateReservation;
    }

    public void setFromDateReservation(Date fromDateReservation) {
        this.fromDateReservation = fromDateReservation;
    }

    public Date getOfDateReservation() {
        return ofDateReservation;
    }

    public void setOfDateReservation(Date ofDateReservation) {
        this.ofDateReservation = ofDateReservation;
    }
}
