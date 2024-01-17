package com.exercise.reward_management.service;

import com.exercise.reward_management.dto.DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    ResponseEntity<DataResponse> uploadFile(MultipartFile file);
}
