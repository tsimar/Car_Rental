package carService.entity;

import carService.entity.CarHairService.CarReturn;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class IncomeMoney {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double incomeMoney;
    private Date incomeDate;

    @OneToMany(mappedBy = "incomeMoney")
    private List<CarReturn> carReturns;
}
