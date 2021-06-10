package com.uepb.web.projetoFinal.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uepb.web.projetoFinal.mapper.AlunoMapper;


@Configuration
public class AlunoMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public AlunoMapper alunoMapper() {
		return new AlunoMapper();
	}

}
