package com.springboot.board.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.board.domain.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query("SELECT a FROM Answer a JOIN FETCH a.question WHERE a.question.id = :questionId")
    List<Answer> findByQuestion_Id(Integer questionId);
}
