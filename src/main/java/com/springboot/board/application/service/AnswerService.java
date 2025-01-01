package com.springboot.board.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.springboot.board.domain.repository.AnswerRepository;
import com.springboot.board.api.v1.dto.response.AnswerResponse;
import com.springboot.board.api.v1.dto.request.AnswerCreateRequest;
import com.springboot.board.mapper.AnswerMapper;
import com.springboot.board.domain.entity.Answer;  


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;
    
    @Transactional
    public AnswerResponse createAnswer(AnswerCreateRequest request) {
        Answer answer = answerMapper.toEntity(request);
        Answer savedAnswer = answerRepository.save(answer);
        return answerMapper.toResponse(savedAnswer);
    }
} 