package com.uepb.web.projetoFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uepb.web.projetoFinal.dto.UsuarioDTO;
import com.uepb.web.projetoFinal.mapper.UsuarioMapper;
import com.uepb.web.projetoFinal.services.UsuarioService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/signup")
@Api(value = "Sign Up")
public class UsuarioController {
	
	@Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @PostMapping
    public void signUp(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.signUpUsuario(usuarioMapper.convertFromUsuarioDTO(usuarioDTO));
    }

}
