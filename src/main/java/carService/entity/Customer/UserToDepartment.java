package carService.entity.Customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class UserToDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int departmentId;
    private int userId;
}
