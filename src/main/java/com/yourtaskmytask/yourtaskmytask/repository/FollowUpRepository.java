package com.yourtaskmytask.yourtaskmytask.repository;

import com.yourtaskmytask.yourtaskmytask.entity.FollowUp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowUpRepository extends JpaRepository<FollowUp, Long> {

    List<FollowUp> findByCustomerId(Long customerId);
    List<FollowUp> findByEmployeeId(Long employeeId);
}