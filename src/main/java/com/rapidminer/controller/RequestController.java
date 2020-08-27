package com.rapidminer.controller;

import com.rapidminer.entity.Request;
import com.rapidminer.service.RequestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.format.annotation.DateTimeFormat.*;

@RestController
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("requests")
    public Page<Request> getRequests(@DateTimeFormat(iso = ISO.DATE) Optional<LocalDate> startDate,
                                     @DateTimeFormat(iso = ISO.DATE) Optional<LocalDate> endDate,
                                     Pageable pageable) {
        return requestService.findByStartDateAndEndDate(startDate, endDate, pageable);
    }
}
