package carService.dto.entity.carHairService.user;

import lombok.Data;

@Data
public class User_CustomerDTO {
    private String userName;
    private String userPassword;
    private String nameCustomer;
    private String lastNameCustomer;
    private String email;
    private String address;
    private long departmentId;
}
