package com.exercise.reward_management.service.impl;

import com.exercise.reward_management.constant.ErrorConstant;
import com.exercise.reward_management.constant.MessageConstants;
import com.exercise.reward_management.dto.DataResponse;
import com.exercise.reward_management.model.Gift;
import com.exercise.reward_management.model.PrizeManagement;
import com.exercise.reward_management.repository.GiftRepository;
import com.exercise.reward_management.repository.PrizeManagermentRepository;
import com.exercise.reward_management.service.RewardManagementService;
import com.exercise.reward_management.utils.Translator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import static com.exercise.reward_management.constant.CommonConstant.ONE;
import static com.exercise.reward_management.constant.CommonConstant.ZERO;

@Service
@Log4j2
public class RewardManagementServiceImpl implements RewardManagementService {
    @Autowired
    private PrizeManagermentRepository prizeManagermentRepository;
    @Autowired
    private GiftRepository giftRepository;
    @Override
    public ResponseEntity<DataResponse> receiveReward(String phoneNumber){
        try {

            Optional<PrizeManagement> prizeManagermentOpt = prizeManagermentRepository.findByPhoneNumber(phoneNumber);
            if (!prizeManagermentOpt.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        DataResponse
                                .builder()
                                .errorCode(ErrorConstant.VALIDATE_ERROR_CODE)
                                .message(Translator.toLocale(MessageConstants.DONT_RECEIVE_REWARDS))
                                .data(null).build()
                );
            }
            Optional<Gift> giftOpt = giftRepository.getGift(ZERO);
            if (!giftOpt.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        DataResponse
                                .builder()
                                .errorCode(ErrorConstant.VALIDATE_ERROR_CODE)
                                .message(Translator.toLocale(MessageConstants.OUT_OF_GIFT))
                                .data(null).build()
                );
            }
            updateGift(giftOpt.get(), phoneNumber);
            updateRewardManagement(prizeManagermentOpt.get());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    DataResponse
                            .builder()
                            .errorCode(ErrorConstant.SUCCESS_ERROR_CODE)
                            .message(Translator.toLocale(MessageConstants.SAVE_SUCCESS))
                            .data(giftOpt.get().getCardCode()).build()
            );
        } catch (Exception e) {
            log.error("receive reward EXCEPTION: " + e.getMessage(), phoneNumber);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    DataResponse
                            .builder()
                            .errorCode(ErrorConstant.SYSTEM_BUSY_ERROR_CODE)
                            .message(Translator.toLocale(MessageConstants.SYSTEM_BUSY))
                            .data(null).build()
            );
        }
    }

    private void updateRewardManagement(PrizeManagement prizeManagement){
        int newCount = prizeManagement.getCount() - ONE;
        if (newCount < ONE) {
            prizeManagermentRepository.delete(prizeManagement);
        } else {
            prizeManagement.setCount(newCount);
            prizeManagermentRepository.saveAndFlush(prizeManagement);
        }

    }
    private void updateGift(Gift gift, String phoneNumber){
        gift.setStatus(ONE);
        gift.setUserReceives(phoneNumber);
        gift.setUserTime(new Date());
        giftRepository.saveAndFlush(gift);
    }
}
