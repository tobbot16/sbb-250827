package com.mysite.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ActiveProfiles("dev")
public class SbbApplication {

	MainController mainController = new MainController();

	public static void main(String[] args) {

		//답글로 부터 질문을 참조하는 경우
//		Answer a = new Answer();
//		a.getQuestion().getContent();

		//질문으로 부터 답글을 참조하는 경우
		//5번 질문글을 조회
		//Question q5 = questionRepository.findById(5).get();
		//5번 질문글의 답변을 조회
		//answerRepository.findByQuestion(q5);
		//answerRepository.findByQuestionId(5);
		// List<Answer> answerList = q5.getAnswers();
//		Question q = new Question();
//		List<Answer> answers = q.getAnswers();


		SpringApplication.run(SbbApplication.class, args);
	}


}
