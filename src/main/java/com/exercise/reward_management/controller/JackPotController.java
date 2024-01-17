package com.exercise.reward_management.controller;

import com.exercise.reward_management.constant.UrlConstant;
import com.exercise.reward_management.dto.DataResponse;
import com.exercise.reward_management.service.JackPotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JackPotController {
    @Autowired
    private JackPotService jackPotService;

    @PostMapping(UrlConstant.JACK_POT)
    public ResponseEntity<DataResponse> handleJackPot(@RequestParam("phoneNumber") String phoneNumber) {
        return jackPotService.checkJackPot(phoneNumber);
    }
}
