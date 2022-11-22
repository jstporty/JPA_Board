package kr.kwangan2.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kwangan2.test.domain.Person;

//@RestController
public class PersonController {

	@GetMapping("/hello")
	public String hello(String name) {

		return "Hello:" + name;
	}

	@GetMapping("/getPerson")
	public Person getPerson() {
		System.out.println("===?BoardController 생성");

		Person person = new Person();
		person.setName("hong gil dong");
		person.setAge(20);
		return person;
	}
	
	@GetMapping("/getPersonList")
	public List<Person>	getPersonList(){
		Person person1 = new Person();
		person1.setName("hong gil dong1");
		person1.setAge(21);
		Person person2 = new Person();
		person2.setName("hong gil dong2");
		person2.setAge(22);
		
		List<Person> personList	= new ArrayList<Person>();
		personList.add(person1);
		personList.add(person2);
		
		return personList;
		
	}

}
