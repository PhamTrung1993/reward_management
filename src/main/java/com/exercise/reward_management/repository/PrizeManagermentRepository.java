package com.exercise.reward_management.repository;

import com.exercise.reward_management.model.PrizeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrizeManagermentRepository extends JpaRepository<PrizeManagement, Long> {

    Optional<PrizeManagement> findByPhoneNumber(String phoneNumber);
}
