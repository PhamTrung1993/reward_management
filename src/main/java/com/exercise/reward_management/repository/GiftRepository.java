package com.exercise.reward_management.repository;

import com.exercise.reward_management.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GiftRepository extends JpaRepository<Gift,Long> {

    @Query(value = "SELECT * FROM GIFT WHERE STATUS = :status ORDER BY CREATE_TIME FETCH FIRST 1 ROW ONLY", nativeQuery = true)
    Optional<Gift> getGift(int status);
}
