package com.exercise.reward_management.controller;

import com.exercise.reward_management.service.RewardManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardManagementController {

    @Autowired
    private RewardManagementService rewardManagementService;
}
