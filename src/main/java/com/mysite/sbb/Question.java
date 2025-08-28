package com.mysite.sbb;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)// varchar(200) -> 200자 까지
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

     @OneToMany(mappedBy = "question",fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST}) // mappedBy : Answer 클래스의 question 필드와 매핑됨, cascade : 질문이 삭제되면 관련된 답변도 삭제
    private List<Answer> answers = new ArrayList<>();


    public void addAnswer(String string) {
        Answer answer = new Answer();
        answer.setContent(string);
        answer.setQuestion(this); // 현재 질문 객체를 설정
        answers.add(answer); // 질문의 답변 목록에 추가

    }
}
