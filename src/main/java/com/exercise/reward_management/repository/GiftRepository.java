package com.exercise.reward_management.repository;

import com.exercise.reward_management.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<Gift,Long> {
}
