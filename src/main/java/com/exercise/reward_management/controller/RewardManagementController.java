package com.exercise.reward_management.controller;

import com.exercise.reward_management.constant.UrlConstant;
import com.exercise.reward_management.dto.DataResponse;
import com.exercise.reward_management.service.RewardManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardManagementController {

    @Autowired
    private RewardManagementService rewardManagementService;

    @PostMapping(UrlConstant.RECEIVE_REWARD)
    public ResponseEntity<DataResponse> receiveReward(@RequestParam("phoneNumber") String phoneNumber){
        return rewardManagementService.receiveReward(phoneNumber);
    }
}
