package kr.kwangan2.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import kr.kwangan2.test.domain.Person;
import kr.kwangan2.test.service.PersonService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class PersonControllerTest4 {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonService personService;
	
	
	@Test
	public void testHello() throws Exception{
		when(personService.hello("YEO")).thenReturn("Hello:YEO");
		 mockMvc.perform(get("/hello").param("name", "YEO"))
	      .andExpect(status().is(200))
	      .andExpect(content().string("Hello:YEO"))
	      .andDo(print());
		
	}
	
	@Test
	public void testGetPerson() {
		Person person = new Person();
		person.setName("hong gil dong");
		person.setAge(20);// 안에 내용 같으면 새로운거 생성안댐 ㅋ 다른 값 넣어 주니까 되네 ㅋ
		when(personService.getPerson()).thenReturn(person);
	}
	
	
	@Test
	public void testGetPersonList() {
		
		Person person1 = new Person();
		person1.setName("hong gil dong1");
		person1.setAge(21);
		Person person2 = new Person();
		person2.setName("hong gil dong2");
		person2.setAge(22);
		
		List<Person> personList	= new ArrayList<Person>();
		personList.add(person1);
		personList.add(person2);
		
		when(personService.getPersonList()).thenReturn(personList);
		
	}
	
}// class








