package com.rapidminer.service;

import com.rapidminer.entity.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;

public interface RequestService {
    Request saveRequest(Request request);

    /**
     * @param startDate inclusive
     * @param endDate inclusive
     * @param pageable Not Null
     */
    Page<Request> findByStartDateAndEndDate(Optional<LocalDate> startDate, Optional<LocalDate> endDate, Pageable pageable);
}
