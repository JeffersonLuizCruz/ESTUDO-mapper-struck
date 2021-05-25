package com.person.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.person.dto.request.PersonDTO;
import com.person.dto.response.PersonResponseDTO;
import com.person.entities.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	Person toEntity(PersonDTO personDTO);
	PersonResponseDTO toDTO(Person person);

}
