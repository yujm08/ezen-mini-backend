package com.springboot.board.application.mapper;

import java.util.List;
import com.springboot.board.api.v1.dto.request.QuestionCreateRequest;
import com.springboot.board.api.v1.dto.response.QuestionResponse;
import com.springboot.board.api.v1.dto.response.AnswerResponse;
import com.springboot.board.domain.entity.Question;
import com.springboot.board.domain.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question toEntity(QuestionCreateRequest request);

    @Mapping(target = "answers", source = "answers")
    QuestionResponse toResponse(Question question);

    List<AnswerResponse> toAnswerResponses(List<Answer> answers);

    AnswerResponse toAnswerResponse(Answer answer);
}