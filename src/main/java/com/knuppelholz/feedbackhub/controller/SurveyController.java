package com.knuppelholz.feedbackhub.controller;

import com.knuppelholz.feedbackhub.dto.CreateSurveyRequest;
import com.knuppelholz.feedbackhub.dto.SurveyResponse;
import com.knuppelholz.feedbackhub.service.SurveyService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/surveys")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping
    public ResponseEntity<SurveyResponse> createSurvey(@RequestBody CreateSurveyRequest request) {
        SurveyResponse response = surveyService.createSurvey(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<SurveyResponse>> getAllSurveys() {
        return ResponseEntity.ok(surveyService.getAllSurveys());
    }

}
