package com.springboot.board.application.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.springboot.board.domain.repository.AnswerRepository;
import com.springboot.board.api.v1.dto.request.AnswerCreateRequest;
import com.springboot.board.application.mapper.AnswerMapper;
import com.springboot.board.api.v1.dto.response.AnswerResponse;
import com.springboot.board.domain.entity.Answer;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;
    private final QuestionService questionService;

    @Transactional
    public AnswerResponse createAnswer(AnswerCreateRequest request) {
        // Answer 엔티티로 변환 및 저장
        Answer answer = answerMapper.toEntity(request, questionService);
        Answer savedAnswer = answerRepository.save(answer);
        return answerMapper.toResponse(savedAnswer);
    }

    public List<AnswerResponse> getAnswersByQuestionId(Integer questionId) {
        // 특정 질문 ID의 답변 조회
        List<Answer> answers = answerRepository.findByQuestion_Id(questionId);

        // 조회된 답변이 없는 경우 예외 처리
        if (answers == null || answers.isEmpty()) {
            throw new NoSuchElementException("해당 질문에 대한 답변이 없습니다. 질문 ID: " + questionId);
        }

        // 답변 리스트를 AnswerResponse 리스트로 변환
        return answers.stream()
                .map(answerMapper::toResponse)
                .collect(Collectors.toList());
    }
}
