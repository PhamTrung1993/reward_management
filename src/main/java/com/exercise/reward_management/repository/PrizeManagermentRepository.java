package com.exercise.reward_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeManagermentRepository extends JpaRepository<PrizeManagermentRepository, Long> {
}
