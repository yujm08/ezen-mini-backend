package com.springboot.board.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.springboot.board.domain.repository.QuestionRepository;
import com.springboot.board.api.v1.dto.request.QuestionCreateRequest;
import com.springboot.board.api.v1.dto.response.QuestionResponse;
import com.springboot.board.domain.entity.Question;
import com.springboot.board.exception.DataNotFoundException;
import com.springboot.board.mapper.QuestionMapper;
import org.springframework.data.domain.PageRequest;

@Service
//Transactional(readOnly = true)은 데이터베이스의 읽기 전용 트랜잭션을 설정하여 성능을 최적화하고, 데이터의 일관성을 보장하기 위해 사용
@Transactional(readOnly = true) 
@RequiredArgsConstructor 
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    //DTO를 사용하여 입력과 출력을 명확히 하여 API의 계약을 강화. 이는 데이터의 유효성을 검사하고, API의 일관성을 높이는 데 기여
    //트랜잭션 관리:
    //원본에서는 `create` 메서드에 트랜잭션 관리가 없었으나, 수정된 클래스에서는 `@Transactional` 어노테이션이 추가
    //데이터베이스의 일관성을 보장하기 위해 트랜잭션을 명시적으로 관리. @Transactional(readOnly = true)는 읽기 전용 트랜잭션을 설정하여 성능을 최적화

    //method 이름 변경: create → createQuestion
    @Transactional
    public QuestionResponse createQuestion(QuestionCreateRequest request) {
        Question question = questionMapper.toEntity(request);
        Question savedQuestion = questionRepository.save(question);
        return questionMapper.toResponse(savedQuestion);
    }

    //method 이름 변경:getList → getQuestions
    public Page<QuestionResponse> getQuestions(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createDate"));
        Page<Question> questions = questionRepository.findAll(pageable);
        return questions.map(questionMapper::toResponse);
    }
    
    //method 이름 변경:getQuestion → getQuestion
    public QuestionResponse getQuestion(Long id) {
        Question question = questionRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("질문을 찾을 수 없습니다."));
        return questionMapper.toResponse(question);
    }
}

