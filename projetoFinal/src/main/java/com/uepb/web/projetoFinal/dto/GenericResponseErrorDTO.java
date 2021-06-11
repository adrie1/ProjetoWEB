package com.uepb.web.projetoFinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResponseErrorDTO {
	
	private String error;
	
	public GenericResponseErrorDTO(String error) {
		this.error = error;
	}

}