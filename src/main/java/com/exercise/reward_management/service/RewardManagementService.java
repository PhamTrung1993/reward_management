package com.exercise.reward_management.service;

import com.exercise.reward_management.dto.DataResponse;
import org.springframework.http.ResponseEntity;

public interface RewardManagementService {
    ResponseEntity<DataResponse> receiveReward(String phoneNumber);
}
