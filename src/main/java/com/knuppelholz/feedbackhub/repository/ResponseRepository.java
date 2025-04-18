package com.knuppelholz.feedbackhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knuppelholz.feedbackhub.entity.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {}
