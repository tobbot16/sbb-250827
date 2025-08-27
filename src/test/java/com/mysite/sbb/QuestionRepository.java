package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest
class QuestionRepositoryTest {


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

	@Test
	void t4() {
		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.").get();
		assertEquals(1, q.getId());
	}

	@Test
	void t5(){
		List<Question>qList = this.questionRepository.findBySubjectLike("sbb%");
		Question q = qList.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

	@Test
	void t6(){
		Optional<Question> oq = this.questionRepository.findById(1);
			assertTrue(oq.isPresent());
			Question q = oq.get();
			q.setSubject("수정된 제목");
			this.questionRepository.save(q);

		Optional<Question> q2 = this.questionRepository.findById(1);
		assertEquals("수정된 제목", q2.get().getSubject());
	}

	@Test
	void t7(){
		assertEquals(2, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);

		assertEquals(1, this.questionRepository.count());
	}

}
