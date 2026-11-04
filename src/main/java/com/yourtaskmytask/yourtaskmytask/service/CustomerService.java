package com.yourtaskmytask.yourtaskmytask.service;

import com.yourtaskmytask.yourtaskmytask.entity.Customer;
import com.yourtaskmytask.yourtaskmytask.exception.ResourceNotFoundException;
import com.yourtaskmytask.yourtaskmytask.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Create Customer
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Find Customer by ID
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found with id: " + id
                        )
                );
    }

    // Find All Customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Update Customer
    public Customer updateCustomer(Long id, Customer customer) {

        Customer existingCustomer = getCustomerById(id);

        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setCompany(customer.getCompany());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setStatus(customer.getStatus());

        return customerRepository.save(existingCustomer);
    }

    // Delete Customer
    public void deleteCustomer(Long id) {

        Customer existingCustomer = getCustomerById(id);

        customerRepository.delete(existingCustomer);
    }
}