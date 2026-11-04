package com.yourtaskmytask.yourtaskmytask.service;

import com.yourtaskmytask.yourtaskmytask.entity.FollowUp;
import com.yourtaskmytask.yourtaskmytask.exception.ResourceNotFoundException;
import com.yourtaskmytask.yourtaskmytask.repository.FollowUpRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowUpService {

    private final FollowUpRepository followUpRepository;

    public FollowUpService(FollowUpRepository followUpRepository) {
        this.followUpRepository = followUpRepository;
    }
// Customer followUp ke liye
    public List<FollowUp> getFollowUpsByCustomerId(Long customerId) {

        return followUpRepository.findByCustomerId(customerId);
    }

//    Employee followup ke liye
    public List<FollowUp> getFollowUpsByEmployeeId(Long employeeId) {

        return followUpRepository.findByEmployeeId(employeeId);
    }

    // Create FollowUp
    public FollowUp createFollowUp(FollowUp followUp) {
        return followUpRepository.save(followUp);
    }

    // Find FollowUp by ID
    public FollowUp getFollowUpById(Long id) {

        return followUpRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "FollowUp not found with id: " + id
                        )
                );
    }

    // Find All FollowUps
    public List<FollowUp> getAllFollowUps() {
        return followUpRepository.findAll();
    }

    // Update FollowUp
    public FollowUp updateFollowUp(Long id, FollowUp followUp) {

        FollowUp existingFollowUp = getFollowUpById(id);

        existingFollowUp.setFollowUpDate(followUp.getFollowUpDate());
        existingFollowUp.setNote(followUp.getNote());
        existingFollowUp.setStatus(followUp.getStatus());

        return followUpRepository.save(existingFollowUp);
    }

    // Delete FollowUp
    public void deleteFollowUp(Long id) {

        FollowUp existingFollowUp = getFollowUpById(id);

        followUpRepository.delete(existingFollowUp);
    }
}