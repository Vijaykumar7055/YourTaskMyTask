package com.yourtaskmytask.yourtaskmytask.controller;

import com.yourtaskmytask.yourtaskmytask.entity.Customer;
import com.yourtaskmytask.yourtaskmytask.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Create Customer
    @PostMapping
    public Customer createCustomer(
            @Valid @RequestBody Customer customer) {

        return customerService.createCustomer(customer);
    }

    // Get Customer by ID
    @GetMapping("/{id}")
    public Customer getCustomerById(
            @PathVariable Long id) {

        return customerService.getCustomerById(id);
    }

    // Get All Customers
    @GetMapping
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    // Update Customer
    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody Customer customer) {

        return customerService.updateCustomer(id, customer);
    }

    // Delete Customer
    @DeleteMapping("/{id}")
    public String deleteCustomer(
            @PathVariable Long id) {

        customerService.deleteCustomer(id);

        return "Customer deleted successfully";
    }
}