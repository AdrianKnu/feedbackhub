package com.knuppelholz.feedbackhub.service;


import com.knuppelholz.feedbackhub.dto.CreateSurveyRequest;
import com.knuppelholz.feedbackhub.dto.SurveyResponse;
import com.knuppelholz.feedbackhub.entity.Question;
import com.knuppelholz.feedbackhub.entity.Survey;
import com.knuppelholz.feedbackhub.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public SurveyResponse createSurvey(CreateSurveyRequest request) {
        Survey survey = Survey.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .createdAt(LocalDateTime.now())
                .build();

        List<Question> questions = request.getQuestions().stream()
                .map(text -> Question.builder().text(text).survey(survey).build())
                .toList();

        survey.setQuestions(questions);
        Survey saved = surveyRepository.save(survey);

        SurveyResponse response = new SurveyResponse();
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setQuestions(
                saved.getQuestions().stream().map(Question::getText).toList()
        );

        return response;
    }

    public List<SurveyResponse> getAllSurveys() {
        return surveyRepository.findAll().stream().map(survey -> {
            SurveyResponse response = new SurveyResponse();
            response.setId(survey.getId());
            response.setTitle(survey.getTitle());
            response.setDescription(survey.getDescription());
            response.setQuestions(
                    survey.getQuestions().stream().map(Question::getText).toList()
            );
            return response;
        }).toList();
    }
    
}
