package carService.service.customer;


import carService.entity.Customer.Customer;
import carService.repository.Customer.CustomerInfoRepository;
import carService.repository.Customer.CustomerRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerInfoService {

    private final CustomerInfoRepository customerInfoRepository;
    private final CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerInfoRepository.findAll();
    }

    public List<Customer> getAllByUserId(Long userId) {

        try {
            List<Customer> my=customerInfoRepository.findAllByUserId(userId);
            return my;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Customer  saveCustomer(Customer customer){
         return customerRepository.save(customer);
    }


}
