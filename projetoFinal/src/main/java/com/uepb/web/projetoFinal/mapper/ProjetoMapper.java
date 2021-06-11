package com.uepb.web.projetoFinal.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.uepb.web.projetoFinal.dto.ProjetoDTO;
import com.uepb.web.projetoFinal.model.Projeto;

public class ProjetoMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	public ProjetoDTO convertToProjetoDTO(Projeto projeto) {
		ProjetoDTO projetoDTO = modelMapper.map(projeto, ProjetoDTO.class);

		return projetoDTO;
	}

	public Projeto convertFromProjetoDTO(ProjetoDTO projetoDTO) {
		Projeto projeto = modelMapper.map(projetoDTO, Projeto.class);

		return projeto;
	}

}
