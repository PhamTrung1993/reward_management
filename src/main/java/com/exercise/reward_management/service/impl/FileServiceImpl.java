package com.exercise.reward_management.service.impl;

import com.exercise.reward_management.constant.ErrorConstant;
import com.exercise.reward_management.constant.MessageConstants;
import com.exercise.reward_management.dto.DataResponse;
import com.exercise.reward_management.model.Gift;
import com.exercise.reward_management.repository.GiftRepository;
import com.exercise.reward_management.service.FileService;
import com.exercise.reward_management.utils.Translator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.exercise.reward_management.constant.CommonConstant.ZERO;

@Service
@Log4j2
public class FileServiceImpl implements FileService {
    @Autowired
    private GiftRepository giftRepository;

    public ResponseEntity<DataResponse> uploadFile(MultipartFile file){
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            if (!bufferedReader.ready()) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        DataResponse
                                .builder()
                                .errorCode(ErrorConstant.VALIDATE_ERROR_CODE)
                                .message(Translator.toLocale(MessageConstants.FILE_BLANK))
                                .data(null).build()
                );

            } else {
                List<Gift> lstGift = new ArrayList<>();
                while ((line = bufferedReader.readLine()) != null) {

                    Gift gift = getGiftObject(line);
                    lstGift.add(gift);
//                    giftRepository.save(gift);
                }
                log.info(lstGift);
                giftRepository.saveAllAndFlush(lstGift);
                return ResponseEntity.status(HttpStatus.OK).body(
                        DataResponse
                                .builder()
                                .errorCode(ErrorConstant.SUCCESS_ERROR_CODE)
                                .message(Translator.toLocale(MessageConstants.SAVE_SUCCESS))
                                .data(null).build()
                );
            }
        } catch (Exception e) {
            log.error("read file csv exception: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    DataResponse
                            .builder()
                            .errorCode(ErrorConstant.SYSTEM_BUSY_ERROR_CODE)
                            .message(Translator.toLocale(MessageConstants.SYSTEM_BUSY))
                            .data(null).build()
            );
        }
    }

    private Gift getGiftObject(String csvData){
        List<String> data = Arrays.asList(csvData.split(","));
        Gift gift = new Gift();
        gift.setCardCode(data.get(ZERO).trim());
        gift.setStatus(ZERO);
        gift.setCreateTime(new Date());
        return gift;
    }

}
