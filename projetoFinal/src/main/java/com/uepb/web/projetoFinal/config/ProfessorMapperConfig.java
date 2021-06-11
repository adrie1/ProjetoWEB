package com.uepb.web.projetoFinal.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uepb.web.projetoFinal.mapper.ProfessorMapper;

@Configuration
public class ProfessorMapperConfig {
	
	@Bean
	public ModelMapper modelMapperProfessor() {
		return new ModelMapper();
	}
	
	@Bean
	public ProfessorMapper professorMapper() {
		return new ProfessorMapper();
	}

}