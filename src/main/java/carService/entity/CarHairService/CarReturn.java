package carService.entity.CarHairService;

import carService.entity.IncomeMoney;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long employeeId;
    private Long userId;
    private Long companyId;
    private Date returnDate;
    private String commentsRental;
    private String commentsCustomer;
    private double supplement;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carReturn", orphanRemoval = true)
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "income_money_id")
    private IncomeMoney incomeMoney;


}
