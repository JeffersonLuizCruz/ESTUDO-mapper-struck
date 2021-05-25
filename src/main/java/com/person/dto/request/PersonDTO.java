package com.person.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PersonDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotNull(message = "Campo nome obrigatório")
	private String name;
	@NotNull(message = "Campo cpf obrigatório")
	private String cpf;

}
