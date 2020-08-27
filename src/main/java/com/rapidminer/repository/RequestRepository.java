package com.rapidminer.repository;

import com.rapidminer.entity.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RequestRepository extends MongoRepository<Request, String> {

    Page<Request> findByDateTimeGreaterThanEqual(LocalDateTime startDateTime, Pageable pageable);

    Page<Request> findByDateTimeLessThanEqual(LocalDateTime endDateTime, Pageable pageable);

    Page<Request> findByDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime, Pageable pageable);
}
