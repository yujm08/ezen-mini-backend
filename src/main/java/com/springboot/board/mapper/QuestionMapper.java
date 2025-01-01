package com.springboot.board.mapper;


//QuestionMapper는 DTO(Data Transfer Object)와 엔티티(Entity) 간의 변환을 담당하는 클래스. 
//데이터 변환: 클라이언트와 서버 간의 데이터 전송을 위해 DTO와 엔티티 간의 변환을 수행. 
// 이는 데이터의 구조를 명확히 하고, API의 계약을 강화하는 데 도움.
//엔티티 생성: 클라이언트로부터 받은 요청 데이터를 엔티티로 변환
//응답 데이터 생성: 엔티티를 클라이언트에게 반환할 응답 데이터로 변환

import com.springboot.board.api.v1.dto.request.QuestionCreateRequest;
import com.springboot.board.api.v1.dto.response.QuestionResponse;
import com.springboot.board.api.v1.dto.response.AnswerResponse;
import com.springboot.board.domain.entity.Question;
import com.springboot.board.domain.entity.Answer;
import org.mapstruct.Mapper;

// Mapper는 MapStruct를 사용하여 구현되며, Spring의 컴포넌트 모델을 사용하여 스프링 컨테이너에 등록됩니다.
@Mapper(componentModel = "spring")
public interface QuestionMapper {
    // QuestionCreateRequest를 Question 엔티티로 변환하는 메서드
    Question toEntity(QuestionCreateRequest request);
    
    // Question 엔티티를 QuestionResponse DTO로 변환하는 메서드
    QuestionResponse toResponse(Question question);
    
    // Answer 엔티티를 AnswerResponse DTO로 변환하는 메서드
    AnswerResponse toResponse(Answer answer);
} 