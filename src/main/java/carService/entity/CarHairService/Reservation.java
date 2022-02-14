package carService.entity.CarHairService;

import carService.entity.Car.CarRentalDepartment;
import carService.entity.Car.DescriptionCar;
import carService.entity.Customer.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import carService.entity.Car.RentalsAmountCar;

import javax.persistence.*;
import java.util.Date;
import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date reservationDate;
    private Date fromDateReservation;
    private Date ofDateReservation;


    @OneToMany( mappedBy = "reservation")
    private List<DescriptionCar> descriptionCars;
//
   private int userId;
//
    @OneToMany( mappedBy = "reservationRental")
    private List<CarRentalDepartment> carRentalDepartmentsRental;

    @OneToMany( mappedBy = "reservationReturn")
    private List<CarRentalDepartment> carRentalDepartmentsReturn;



//    @OneToMany(fetch = FetchType.LAZY)
//    private List<RentalsAmountCar> rentalsAmountCars;


    @ManyToOne
    @JoinColumn(name = "car_rental_id")
    private CarRental carRental;

    @ManyToOne
    @JoinColumn(name = "car_return_id")
    private CarReturn carReturn;

    public Reservation(Date reservationDate, Date fromDateReservation, Date ofDateReservation, List<DescriptionCar> descriptionCars, List<Customer> customers, List<CarRentalDepartment> carRentalDepartmentsRental, List<RentalsAmountCar> rentalsAmountCars, CarRental carRental, CarReturn carReturn) {
        this.reservationDate = reservationDate;
        this.fromDateReservation = fromDateReservation;
        this.ofDateReservation = ofDateReservation;
        this.carRental = carRental;
        this.carReturn = carReturn;
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

//    public List<DescriptionCar> getDescriptionCars() {
//        return descriptionCars;
//    }
//
//    public void setDescriptionCars(List<DescriptionCar> descriptionCars) {
//        this.descriptionCars = descriptionCars;
//    }
//
//    public List<Customer> getCustomers() {
//        return customers;
//    }

//    public void setCustomers(List<Customer> customers) {
//        this.customers = customers;
//    }

//    public List<CarRentalDepartment> getCarRentalDepartmentsRental() {
//        return carRentalDepartmentsRental;
//    }
//
//    public void setCarRentalDepartmentsRental(List<CarRentalDepartment> carRentalDepartmentsRental) {
//        this.carRentalDepartmentsRental = carRentalDepartmentsRental;
//    }
//
//    public List<RentalsAmountCar> getRentalsAmountCars() {
//        return rentalsAmountCars;
//    }
//
//    public void setRentalsAmountCars(List<RentalsAmountCar> rentalsAmountCars) {
//        this.rentalsAmountCars = rentalsAmountCars;
//    }

    public CarRental getCarRental() {
        return carRental;
    }

    public void setCarRental(CarRental carRental) {
        this.carRental = carRental;
    }

    public CarReturn getCarReturn() {
        return carReturn;
    }

    public void setCarReturn(CarReturn carReturn) {
        this.carReturn = carReturn;
    }
}
