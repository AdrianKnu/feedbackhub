package com.knuppelholz.feedbackhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knuppelholz.feedbackhub.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {}
