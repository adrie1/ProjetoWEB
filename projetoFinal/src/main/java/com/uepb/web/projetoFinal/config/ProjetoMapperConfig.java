package com.uepb.web.projetoFinal.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uepb.web.projetoFinal.mapper.ProjetoMapper;


@Configuration
public class ProjetoMapperConfig {
	
	@Bean
	public ModelMapper modelMapperProjeto() {
		return new ModelMapper();
	}
	
	@Bean
	public ProjetoMapper projetoMapper() {
		return new ProjetoMapper();
	}


}
