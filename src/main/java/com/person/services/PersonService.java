package com.person.services;

import java.util.List;

import com.person.entities.Person;

public interface PersonService{
	
	Person findById(Long id);
	List<Person> listAll();
	Person save(Person person);
	Person update(Person person);
	void delete(Long id);

}
