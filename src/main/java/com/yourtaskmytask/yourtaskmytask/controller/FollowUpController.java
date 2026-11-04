package com.yourtaskmytask.yourtaskmytask.controller;

import com.yourtaskmytask.yourtaskmytask.entity.FollowUp;
import com.yourtaskmytask.yourtaskmytask.service.FollowUpService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/followups")
public class FollowUpController {

    private final FollowUpService followUpService;

    public FollowUpController(FollowUpService followUpService) {
        this.followUpService = followUpService;
    }


    @GetMapping("/customer/{customerId}")
    public List<FollowUp> getFollowUpsByCustomerId(
            @PathVariable Long customerId) {

        return followUpService.getFollowUpsByCustomerId(customerId);
    }


    @GetMapping("/employee/{employeeId}")
    public List<FollowUp> getFollowUpsByEmployeeId(
            @PathVariable Long employeeId) {

        return followUpService.getFollowUpsByEmployeeId(employeeId);
    }
    // Create FollowUp
    @PostMapping
    public FollowUp createFollowUp(
            @Valid @RequestBody FollowUp followUp) {

        return followUpService.createFollowUp(followUp);
    }

    // Get FollowUp by ID
    @GetMapping("/{id}")
    public FollowUp getFollowUpById(
            @PathVariable Long id) {

        return followUpService.getFollowUpById(id);
    }

    // Get All FollowUps
    @GetMapping
    public List<FollowUp> getAllFollowUps() {

        return followUpService.getAllFollowUps();
    }

    // Update FollowUp
    @PutMapping("/{id}")
    public FollowUp updateFollowUp(
            @PathVariable Long id,
            @Valid @RequestBody FollowUp followUp) {

        return followUpService.updateFollowUp(id, followUp);
    }

    // Delete FollowUp
    @DeleteMapping("/{id}")
    public String deleteFollowUp(
            @PathVariable Long id) {

        followUpService.deleteFollowUp(id);

        return "FollowUp deleted successfully";
    }
}