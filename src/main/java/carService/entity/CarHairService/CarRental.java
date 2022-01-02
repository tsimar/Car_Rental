package carService.entity.CarHairService;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class CarRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private Date rentalDate;
    private String commentsRental;
    private String commentsCustomer;


    //@JsonIgnore
    @OneToMany(mappedBy = "carRental")
    private List<Reservation> reservations;


    public CarRental(Long employeeId, Date rentalDate, String commentsRental, String commentsCustomer, List<Reservation> reservations) {
        this.employeeId = employeeId;
        this.rentalDate = rentalDate;
        this.commentsRental = commentsRental;
        this.commentsCustomer = commentsCustomer;
        this.reservations = reservations;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getCommentsRental() {
        return commentsRental;
    }

    public void setCommentsRental(String commentsRental) {
        this.commentsRental = commentsRental;
    }

    public String getCommentsCustomer() {
        return commentsCustomer;
    }

    public void setCommentsCustomer(String commentsCustomer) {
        this.commentsCustomer = commentsCustomer;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
