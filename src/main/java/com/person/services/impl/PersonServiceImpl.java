package com.person.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.person.entities.Person;
import com.person.repositories.PersonRepository;
import com.person.services.PersonService;
import com.person.services.exceptions.BadRequestException;
import com.person.services.exceptions.NotFoundException;

@Service
public class PersonServiceImpl implements PersonService{
	
	private PersonRepository personRepository;
	
	private PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Person findById(Long id) {
		verifyIfExist(id);
		
		return personRepository.getById(id);
	}

	@Override
	public List<Person> listAll() {
		List<Person> result = personRepository.findAll();
		
		return result;
	}

	@Override
	public Person save(Person person) {
		verifyField(person.getCpf());
		return personRepository.save(person);
	}

	@Override
	public Person update(Person person) {
		verifyIfExist(person.getId());
		Person result = personRepository.save(person);
		
		return result;
	}

	@Override
	public void delete(Long id) {
		verifyIfExist(id);
		
		personRepository.deleteById(id);
	}
	
	private Person verifyIfExist(Long id) {
		Optional<Person> result = personRepository.findById(id);
		result.orElseThrow(() -> new NotFoundException("Pessoa não existe no base de dados " + "Tipo: " + id));
		
		return result.get();
	}
	
	private void verifyField(String cpf) {
		Optional<Person> result = personRepository.findByCpf(cpf);
		
		if(result.isPresent()) {
			throw new BadRequestException("CPF já cadastrado no sistema" + cpf);
		}
	}

}
