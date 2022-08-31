package carService.repository.Customer;


import carService.entity.Customer.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE User u SET u.userName=:userName, u.userPassword=:userPassword WHERE u.id=:id")
    int update(@Param("userName") String userName, @Param("userPassword") String userPassword, @Param("id") Long id);


    @Query(value = "SELECT u FROM User u WHERE u.userName = :user")
    List<User> findUser(@Param("user") String user);

    @Query(value = "SELECT u FROM User u WHERE u.userName = :user and u.userPassword=:password")
   User loginUser(@Param("user") String user, @Param("password") String password);
}



