package com.yourtaskmytask.yourtaskmytask.repository;

import com.yourtaskmytask.yourtaskmytask.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer save(Customer customer);


    List<Customer> findAll();

    void delete(Customer existingCustomer);


}
