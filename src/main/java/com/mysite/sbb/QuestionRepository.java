package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {


    Optional<Question> findBySubject(String subject);     //중복되지 않는다고 가정
    Optional<Question> findBySubjectAndContent(String subject1, String subject2);

    List<Question> findBySubjectLike(String subject);


}
