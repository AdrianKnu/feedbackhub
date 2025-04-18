package com.knuppelholz.feedbackhub.dto;

import lombok.Data;

import java.util.List;

@Data
public class SurveyResponse {
    private Long id;
    private String title;
    private String description;
    private List<String> questions;
}
