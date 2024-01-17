package com.exercise.reward_management.controller;

import com.exercise.reward_management.constant.UrlConstant;
import com.exercise.reward_management.dto.DataResponse;
import com.exercise.reward_management.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;


    @PostMapping(UrlConstant.UPLOAD_FILE)
    public ResponseEntity<DataResponse> handleFileUpload(@RequestParam("file") MultipartFile file) {
        return fileService.uploadFile(file);
    }
}
