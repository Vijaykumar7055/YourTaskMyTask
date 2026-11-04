package com.yourtaskmytask.yourtaskmytask.controller;

import com.yourtaskmytask.yourtaskmytask.entity.User;
import com.yourtaskmytask.yourtaskmytask.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Create Employee
    @PostMapping("/employees")
    public User createEmployee(@Valid @RequestBody User user) {
        return adminService.createEmployee(user);
    }

    // Find Employee by ID
    @GetMapping("/employees/{id}")
    public User getEmployeeById(@PathVariable Long id) {
        return adminService.getEmployeeById(id);
    }

    // Find All Employees
    @GetMapping("/employees")
    public List<User> getAllEmployees() {
        return adminService.getAllEmployees();
    }

    // Update Employee
    @PutMapping("/employees/{id}")
    public User updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody User user) {

        return adminService.updateEmployee(id, user);
    }

    // Delete Employee
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        adminService.deleteEmployee(id);

        return "Employee deleted successfully";
    }
}