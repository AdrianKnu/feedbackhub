package com.knuppelholz.feedbackhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knuppelholz.feedbackhub.entity.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long>{
    
}
