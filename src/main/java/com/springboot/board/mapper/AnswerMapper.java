package com.springboot.board.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.springboot.board.domain.entity.Answer;
import com.springboot.board.domain.entity.Question;
import com.springboot.board.api.v1.dto.request.AnswerCreateRequest;
import com.springboot.board.api.v1.dto.response.AnswerResponse;
import com.springboot.board.application.service.QuestionService;

// AnswerMapper 인터페이스는 AnswerCreateRequest를 Answer 엔티티로 변환하고, Answer 엔티티를 AnswerResponse로 변환하는 매핑을 정의
@Mapper(componentModel = "spring", uses = {QuestionService.class})
public interface AnswerMapper {

    // AnswerCreateRequest의 questionId를 사용하여 Question 엔티티를 매핑
    @Mapping(target = "question", expression = "java(mapQuestion(request.getQuestionId()))")
    Answer toEntity(AnswerCreateRequest request);
    
    // Answer 엔티티를 AnswerResponse로 변환
    AnswerResponse toResponse(Answer answer);
    
    // questionId를 기반으로 Question 객체를 생성하는 기본 메서드
    default Question mapQuestion(Integer questionId) {
        // Question 객체를 빌더 패턴을 사용하여 생성
        return Question.builder()
                .subject("") // 질문의 제목을 빈 문자열로 초기화
                .content("") // 질문의 내용을 빈 문자열로 초기화
                .build(); // Question 객체를 빌드하여 반환
    }
} 