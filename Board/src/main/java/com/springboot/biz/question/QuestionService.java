package com.springboot.biz.question;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.biz.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	public void create(String subject, String content) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
	
//	public List<Question> getList(){
//		return this.questionRepository.findAll();
//	}
	
	public Page<Question> getList(int page) {
	    Pageable pageable = PageRequest.of(page, 10);
	    return this.questionRepository.findAll(pageable);
	}

	
	public Question getQuestion(Integer id) {
	    Optional<Question> question = this.questionRepository.findById(id);

	    if (question.isPresent()) {
	        return question.get();
	    } else {
	        throw new DataNotFoundException("검색한 데이터가 없습니다");
	    }
	}


}
