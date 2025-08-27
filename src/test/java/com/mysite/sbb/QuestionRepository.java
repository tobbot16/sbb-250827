package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
class QeustionRepositoryTest {


	@Autowired
	private QuestionRepository questionRepository;



	@Test
	void t1() {

		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}


	@Test
	void t2() {

		Optional<Question> oq = this.questionRepository.findById(1);
//		Question question = this.questionRepository.findById(1).get();


		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}

	}

	@Test
	void t3() {

		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?").get();
		assertEquals(1, q.getId());
	}
}
