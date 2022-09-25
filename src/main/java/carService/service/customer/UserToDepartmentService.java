package carService.service.customer;

import carService.entity.Customer.UserToDepartment;
import carService.repository.Customer.UserToDepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class UserToDepartmentService {
    private final UserToDepartmentRepository userToDepartmentRepository;


    public UserToDepartmentService(UserToDepartmentRepository userToDepartmentRepository) {
        this.userToDepartmentRepository = userToDepartmentRepository;
    }

    public void saveUserIdDepartmentId (long departmentID,long userID){
        UserToDepartment userIDAndDepartmentID=new UserToDepartment();
        userIDAndDepartmentID.setUserId(userID);
        userIDAndDepartmentID.setDepartmentId(departmentID);
        userToDepartmentRepository.save (userIDAndDepartmentID);
    }
}
