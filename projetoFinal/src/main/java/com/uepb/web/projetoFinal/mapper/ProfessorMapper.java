package com.uepb.web.projetoFinal.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.uepb.web.projetoFinal.dto.ProfessorDTO;
import com.uepb.web.projetoFinal.model.Professor;


public class ProfessorMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	public ProfessorDTO convertToProfessorDTO(Professor professor) {
		ProfessorDTO professorDTO = modelMapper.map(professor, ProfessorDTO.class);

		return professorDTO;
	}

	public Professor convertFromProfessorDTO(ProfessorDTO professorDTO) {
		Professor professor = modelMapper.map(professorDTO, Professor.class);

		return professor;
	}


}
