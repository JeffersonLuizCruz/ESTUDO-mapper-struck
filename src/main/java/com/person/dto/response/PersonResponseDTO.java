package com.person.dto.response;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PersonResponseDTO {
	
	@NotNull(message = "Campo nome obrigatório")
	private String name;
	@NotNull(message = "Campo cpf obrigatório")
	private String cpf;

}
