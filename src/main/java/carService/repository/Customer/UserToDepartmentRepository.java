package carService.repository.Customer;

import carService.entity.Customer.UserToDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserToDepartmentRepository extends JpaRepository<UserToDepartment, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT u FROM UserToDepartment u WHERE u.departmentId=:departmentId")
    List<UserToDepartment> findUsersIdByDepartmentId(@Param("departmentId") Long departmentId);
}
