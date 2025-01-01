package com.springboot.board.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.springboot.board.domain.entity.Answer;
import com.springboot.board.domain.entity.Question;
import com.springboot.board.api.v1.dto.request.AnswerCreateRequest;
import com.springboot.board.api.v1.dto.response.AnswerResponse;
import com.springboot.board.application.service.QuestionService;

@Mapper(componentModel = "spring", uses = {QuestionService.class})
public interface AnswerMapper {
    @Mapping(target = "question", expression = "java(mapQuestion(request.getQuestionId()))")
    Answer toEntity(AnswerCreateRequest request);
    
    AnswerResponse toResponse(Answer answer);
    
    default Question mapQuestion(Long questionId) {
        return Question.builder()
                .subject("")
                .content("")
                .build();
    }
} 