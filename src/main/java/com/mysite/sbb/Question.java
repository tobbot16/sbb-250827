package com.mysite.sbb;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // mappedBy : Answer 클래스의 question 필드와 매핑됨, cascade : 질문이 삭제되면 관련된 답변도 삭제
    private List<Answer> answers;


}
