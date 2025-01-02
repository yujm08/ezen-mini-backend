package com.springboot.board.application.mapper;

import com.springboot.board.api.v1.dto.request.QuestionCreateRequest;
import com.springboot.board.api.v1.dto.response.QuestionResponse;
import com.springboot.board.api.v1.dto.response.AnswerResponse;
import com.springboot.board.domain.entity.Question;
import com.springboot.board.domain.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question toEntity(QuestionCreateRequest request);
    QuestionResponse toResponse(Question question);
    AnswerResponse toResponse(Answer answer);
} 