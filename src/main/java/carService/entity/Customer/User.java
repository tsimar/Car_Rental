package carService.entity.Customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String userPassword;

@OneToOne (fetch = FetchType.LAZY,mappedBy = "user")
    private Customer customer;
}
