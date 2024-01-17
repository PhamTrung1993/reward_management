package com.exercise.reward_management.service.impl;

import com.exercise.reward_management.constant.CommonConstant;
import com.exercise.reward_management.constant.ErrorConstant;
import com.exercise.reward_management.constant.MessageConstants;
import com.exercise.reward_management.dto.DataResponse;
import com.exercise.reward_management.service.JackPotService;
import com.exercise.reward_management.utils.Translator;
import com.exercise.reward_management.utils.Validate;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.math3.distribution.BinomialDistribution;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class JackPotServiceImpl implements JackPotService {
    @Override
    public ResponseEntity<DataResponse> checkJackPot(String phoneNumber) {
        try {
            if (Validate.isValidPhoneNumber(phoneNumber)) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        DataResponse
                                .builder()
                                .errorCode(ErrorConstant.VALIDATE_ERROR_CODE)
                                .message(Translator.toLocale(MessageConstants.FORMAT_PHONE_NUMBER))
                                .data(null).build()
                );
            }
            boolean isWinner = spinWheel();
            String result = CommonConstant.LOSE;
            if (isWinner) {
                saveRecord(phoneNumber);
                result = CommonConstant.WIN;
            }

            return ResponseEntity.status(HttpStatus.OK).body(
                    DataResponse
                            .builder()
                            .errorCode(ErrorConstant.SUCCESS_ERROR_CODE)
                            .data(result)
                            .message(Translator.toLocale(MessageConstants.SAVE_SUCCESS))
                            .data(null).build()
            );

        } catch (Exception e) {
            log.error("JACKPOT EXCEPTION: " + e.getMessage(), phoneNumber);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    DataResponse
                            .builder()
                            .errorCode(ErrorConstant.SYSTEM_BUSY_ERROR_CODE)
                            .message(Translator.toLocale(MessageConstants.SYSTEM_BUSY))
                            .data(null).build()
            );
        }
    }

    private boolean spinWheel() {
        //0.2 là tỷ lệ trúng 20%
        BinomialDistribution distribution = new BinomialDistribution(1, 0.2);
        int numberOfSuccesses = distribution.sample(); // Số lần thành công (1: trúng, 0: không trúng)

        return numberOfSuccesses == 1;
    }
    private void saveRecord(String phoneNumber){

    }
}