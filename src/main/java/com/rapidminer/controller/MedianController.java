package com.rapidminer.controller;

import com.rapidminer.entity.Request;
import com.rapidminer.service.MedianService;
import com.rapidminer.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class MedianController {

    private MedianService medianService;
    private RequestService requestService;

    public MedianController(MedianService medianService, RequestService requestService) {
        this.medianService = medianService;
        this.requestService = requestService;
    }

    @PostMapping("median")
    public ResponseEntity<List<Map<String,Object>>> median(@RequestBody List<Map<String, Object>> content) {
        final List<Map<String, Object>> result = medianService.calculateMedian(content);
        Request req=new Request(content,result,LocalDateTime.now());
        requestService.saveRequest(req);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
