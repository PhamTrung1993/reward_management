package com.exercise.reward_management.service.impl;

import com.exercise.reward_management.repository.PrizeManagermentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RewardManagementServiceImpl {
    @Autowired
    private PrizeManagermentRepository prizeManagermentRepository;
}
