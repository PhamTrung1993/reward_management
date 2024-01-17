package com.exercise.reward_management.service.impl;

import com.exercise.reward_management.constant.ErrorConstant;
import com.exercise.reward_management.constant.MessageConstants;
import com.exercise.reward_management.dto.DataResponse;
import com.exercise.reward_management.service.FileService;
import com.exercise.reward_management.utils.Translator;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@Log4j2
public class FileServiceImpl implements FileService {

    public ResponseEntity<DataResponse> uploadFile(MultipartFile file){
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

            }
            return null;
        } catch (IOException e) {
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

}
