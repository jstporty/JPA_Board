package kr.kwangan2.test.service;

import java.util.List;

import kr.kwangan2.test.domain.Person;

public interface PersonService {

	String hello(String name);

	Person getPerson();

	List<Person> getPersonList();
}
