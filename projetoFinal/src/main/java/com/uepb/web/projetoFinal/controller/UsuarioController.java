package com.uepb.web.projetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uepb.web.projetoFinal.dto.GenericResponseErrorDTO;
import com.uepb.web.projetoFinal.dto.UsuarioDTO;
import com.uepb.web.projetoFinal.exceptions.ExistingUsuarioSameNameException;
import com.uepb.web.projetoFinal.mapper.UsuarioMapper;
import com.uepb.web.projetoFinal.model.Usuario;
import com.uepb.web.projetoFinal.services.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(value = "Usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioMapper usuarioMapper;

	@PostMapping
	@ApiOperation(value = "Cria um novo Usuario")
	public ResponseEntity<?> saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			Usuario usuario = usuarioMapper.convertFromUsuarioDTO(usuarioDTO);
            return new ResponseEntity<>(usuarioService.signUp(usuario), HttpStatus.CREATED);
        } catch (ExistingUsuarioSameNameException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
	}
	
	

}
