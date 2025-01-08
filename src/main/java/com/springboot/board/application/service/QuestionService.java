package com.springboot.board.application.service;

//DTO를 사용하여 입력과 출력을 명확히 하여 API의 계약을 강화. 이는 데이터의 유효성을 검사하고, API의 일관성을 높이는 데 기여
//트랜잭션 관리:
//원본에서는 `create` 메서드에 트랜잭션 관리가 없었으나, 수정된 클래스에서는 `@Transactional` 어노테이션이 추가
//데이터베이스의 일관성을 보장하기 위해 트랜잭션을 명시적으로 관리. @Transactional(readOnly = true)는 읽기 전용 트랜잭션을 설정하여 성능을 최적화

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.springboot.board.domain.repository.QuestionRepository;
import com.springboot.board.api.v1.dto.request.QuestionCreateRequest;
import com.springboot.board.api.v1.dto.response.QuestionResponse;
import com.springboot.board.application.mapper.QuestionMapper;
import com.springboot.board.domain.entity.Question;
import com.springboot.board.common.exception.DataNotFoundException;

import org.springframework.data.domain.PageRequest;


// Transactional(readOnly = true)은 데이터베이스의 읽기 전용 트랜잭션을 설정하여 성능을 최적화하고, 데이터의 일관성을
// 보장하기 위해 사용
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    // method 이름 변경: create → createQuestion
    // createQuestion 메서드는 QuestionCreateRequest를 받아 Question 엔티티로 변환한 후,
    // 데이터베이스에 저장하고, 저장된 질문을 QuestionResponse로 변환하여 반환.
    @Transactional
    public QuestionResponse createQuestion(QuestionCreateRequest request) {

        // 요청을 기반으로 Question 엔티티 생성
        Question question = questionMapper.toEntity(request);

        // Question 엔티티를 데이터베이스에 저장
        Question savedQuestion = questionRepository.save(question);

        // 저장된 Question 엔티티를 QuestionResponse DTO로 변환하여 반환
        return questionMapper.toResponse(savedQuestion);
    }

    // method 이름 변경:getList → getQuestions
    // getQuestions 메서드는 페이지 번호를 받아 해당 페이지의 질문 목록을 반환.
    // Pageable 객체를 생성하여 페이지 크기와 정렬 기준을 설정.
    public Page<QuestionResponse> getQuestions(int page) {

        // 페이지 요청을 생성하고, 정렬 기준으로 생성일자를 내림차순으로 설정
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createDate"));

        // 질문 목록을 데이터베이스에서 조회
        Page<Question> questions = questionRepository.findAll(pageable);

        // Question 엔티티를 QuestionResponse DTO로 변환하여 반환
        // question -> questionMapper.toResponse(question) 표현식과 동일
        // question은 컴파일러가 자동으로 추론하여 제공
        return questions.map(questionMapper::toResponse);
    }

    // method 이름 변경:getQuestion → getQuestion
    // getQuestion 메서드는 주어진 ID로 질문을 조회하고,
    // 해당 질문이 존재하지 않을 경우 DataNotFoundException을 발생.
    public QuestionResponse getQuestion(Integer id) {
        Question question = questionRepository.findByIdWithAnswers(id)
                .orElseThrow(() -> new DataNotFoundException("질문을 찾을 수 없습니다."));

        return questionMapper.toResponse(question);
    }

    // Entity 조회를 위한 메서드 추가
    public Question getQuestionById(Integer id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("질문을 찾을 수 없습니다."));
    }
    
}
