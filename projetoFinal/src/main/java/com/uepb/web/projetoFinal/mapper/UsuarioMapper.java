package com.uepb.web.projetoFinal.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.uepb.web.projetoFinal.dto.UsuarioDTO;
import com.uepb.web.projetoFinal.model.Usuario;


public class UsuarioMapper {
	
	@Autowired
	private ModelMapper modelMapperUsuario;

	public UsuarioDTO convertToUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = modelMapperUsuario.map(usuario, UsuarioDTO.class);

		return usuarioDTO;
	}

	public Usuario convertFromUsuarioDTO(UsuarioDTO usuarioDTO) {
		Usuario usuario = modelMapperUsuario.map(usuarioDTO, Usuario.class);

		return usuario;
	}


}
