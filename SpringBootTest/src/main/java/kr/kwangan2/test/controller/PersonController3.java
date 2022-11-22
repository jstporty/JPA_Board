package kr.kwangan2.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kwangan2.test.domain.Person;
import kr.kwangan2.test.service.PersonService;

@RestController
public class PersonController3 {

	@Autowired
	private PersonService personService;

	@GetMapping("/hello")
	public String hello(String name) {

		return personService.hello(name);
	}

	@GetMapping("/getPerson")
	public Person hello() {

		return personService.getPerson();
	}

	@GetMapping("/getPersonList")
	public List<Person> getPerson() {

		return personService.getPersonList();
	}

}// class
