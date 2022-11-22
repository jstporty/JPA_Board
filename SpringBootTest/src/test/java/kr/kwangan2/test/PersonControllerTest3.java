package kr.kwangan2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import kr.kwangan2.test.domain.Person;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Log4j2
public class PersonControllerTest3 {

	@Autowired
	private TestRestTemplate restTemplate;

	
	@Test
	public void testHello() throws Exception{
		String result = restTemplate.getForObject("/hello?name=YEO", String.class);
		assertEquals("Hello:YEO",result);
	}
	
	@Test
	public void testGetPerson() throws Exception{
		Person person = restTemplate.getForObject("/getPerson", Person.class);
//		assertEquals("hong gil dong",person.getName());
		
		Person person2 = new Person();
		person2.setName("hong gil dong");
		person2.setAge(200);// 안에 내용 같으면 새로운거 생성안댐 ㅋ 다른 값 넣어 주니까 되네 ㅋ
		log.info("person======>"+person.hashCode());
		log.info("person2======>"+person2.hashCode());
		assertEquals(person2,person);
		
		
	}
	
}// class








