package com.yourtaskmytask.yourtaskmytask.service;

import com.yourtaskmytask.yourtaskmytask.entity.Role;
import com.yourtaskmytask.yourtaskmytask.entity.User;
import com.yourtaskmytask.yourtaskmytask.exception.ResourceNotFoundException;
import com.yourtaskmytask.yourtaskmytask.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create Employee
    public User createEmployee(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        user.setRole(Role.EMP);

        return userRepository.save(user);
    }

    // Find Employee by ID
    public User getEmployeeById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id: " + id
                        )
                );

        if (user.getRole() != Role.EMP) {
            throw new ResourceNotFoundException(
                    "Employee not found with id: " + id
            );
        }

        return user;
    }

    // Find All Employees
    public List<User> getAllEmployees() {

        return userRepository.findAll()
                .stream()
                .filter(user -> user.getRole() == Role.EMP)
                .toList();
    }

    // Update Employee
    public User updateEmployee(Long id, User user) {

        User existingEmployee = getEmployeeById(id);

        existingEmployee.setName(user.getName());
        existingEmployee.setEmail(user.getEmail());
        existingEmployee.setPhone(user.getPhone());

        return userRepository.save(existingEmployee);
    }

    // Delete Employee
    public void deleteEmployee(Long id) {

        User existingEmployee = getEmployeeById(id);

        userRepository.delete(existingEmployee);
    }
}