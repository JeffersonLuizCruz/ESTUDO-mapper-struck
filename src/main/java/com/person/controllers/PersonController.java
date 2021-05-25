package com.person.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.dto.mapper.PersonMapper;
import com.person.dto.request.PersonDTO;
import com.person.dto.response.PersonResponseDTO;
import com.person.entities.Person;
import com.person.services.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private PersonService personService;
	private final PersonMapper mapper;
	
	public PersonController(PersonService personService, PersonMapper mapper) {
		this.personService = personService;
		this.mapper = mapper;
	}
	
	@GetMapping(value = "/{id}")
	public Person findById(@PathVariable Long id) {
		Person result = personService.findById(id);
		
		return result;
	}
	
	@PostMapping
	public PersonResponseDTO save(@Valid @RequestBody PersonDTO personDTO) {
		Person person = mapper.toEntity(personDTO);
		Person entity = personService.save(person);
		PersonResponseDTO personResponse = mapper.toDTO(entity);
		
		return personResponse;
		
	}
	
	@PutMapping(value = "/{id}")
	public PersonResponseDTO update(@Valid @RequestBody PersonDTO personDTO, @PathVariable Long id) {
		personDTO.setId(id);
		Person person = mapper.toEntity(personDTO);
		Person entity = personService.update(person);
		PersonResponseDTO personResponse = mapper.toDTO(entity);
		
		return personResponse;
		
	}
	
	@GetMapping
	public List<PersonResponseDTO> list() {
		List<Person> list = personService.listAll();
		
		List<PersonResponseDTO> listDTO = list.stream().map(result -> mapper.toDTO(result)).collect(Collectors.toList());
		
		return listDTO;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>  delete(@PathVariable Long id) {
		personService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
