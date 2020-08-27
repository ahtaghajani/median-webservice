package com.rapidminer.service.Impl;

import com.rapidminer.entity.Request;
import com.rapidminer.repository.RequestRepository;
import com.rapidminer.service.RequestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request saveRequest(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public Page<Request> findByStartDateAndEndDate(Optional<LocalDate> startDate, Optional<LocalDate> endDate, Pageable pageable) {
        Assert.notNull(startDate, "startDate must not be null");
        Assert.notNull(endDate, "endDate must not be null");
        Assert.notNull(pageable, "pageable must not be null");

        if (startDate.isPresent() && endDate.isPresent()) {
            return requestRepository.findByDateTimeBetween(startDate.get().atStartOfDay(),
                    endDate.get().atTime(LocalTime.MAX), pageable);
        } else if (startDate.isPresent()) {
            return requestRepository.findByDateTimeGreaterThanEqual(startDate.get().atStartOfDay(), pageable);
        } else if (endDate.isPresent()) {
            return requestRepository.findByDateTimeLessThanEqual(endDate.get().atTime(LocalTime.MAX), pageable);
        } else {
            return requestRepository.findAll(pageable);
        }
    }
}
