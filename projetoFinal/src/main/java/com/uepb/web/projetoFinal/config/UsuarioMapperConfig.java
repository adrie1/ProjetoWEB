package com.uepb.web.projetoFinal.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uepb.web.projetoFinal.mapper.UsuarioMapper;


@Configuration
public class UsuarioMapperConfig {
	
	@Bean
	public ModelMapper modelMapperUsuario() {
		return new ModelMapper();
	}
	
	@Bean
	public UsuarioMapper usuarioMapper() {
		return new UsuarioMapper();
	}

}
