package com.springboot.board.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Context;
import com.springboot.board.api.v1.dto.request.AnswerCreateRequest;
import com.springboot.board.api.v1.dto.response.AnswerResponse;
import com.springboot.board.application.service.QuestionService;
import com.springboot.board.domain.entity.Answer;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    // AnswerCreateRequest -> Answer 변환
    @Mapping(target = "question", expression = "java(getQuestion(request, questionService))")
    Answer toEntity(AnswerCreateRequest request, @Context QuestionService questionService);

    // Answer -> AnswerResponse 변환
    @Mapping(target = "questionId", source = "question.id")
    @Mapping(target = "createDate", source = "createDate")
    AnswerResponse toResponse(Answer answer);

    // Question 매핑 도우미 메서드
    default com.springboot.board.domain.entity.Question getQuestion(
            AnswerCreateRequest request, QuestionService questionService) {
        return questionService.getQuestionById(request.getQuestionId());
    }
}
