package com.uepb.web.projetoFinal.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uepb.web.projetoFinal.dto.GenericResponseErrorDTO;
import com.uepb.web.projetoFinal.dto.ProjetoDTO;
import com.uepb.web.projetoFinal.exceptions.ExistingProjetoSameNameException;
import com.uepb.web.projetoFinal.mapper.ProjetoMapper;
import com.uepb.web.projetoFinal.model.Projeto;
import com.uepb.web.projetoFinal.services.ProjetoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

@RestController
@RequestMapping("/projetos")
@Api(value = "Projeto")
public class ProjetoController {
	
	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private ProjetoMapper projetoMapper;

	@PostMapping
	@ApiOperation(value = "Cria um novo Projeto")
	public ResponseEntity<?> saveProjeto(@RequestBody ProjetoDTO projetoDTO) {
		try {
			Projeto projeto = projetoMapper.convertFromProjetoDTO(projetoDTO);
            return new ResponseEntity<>(projetoService.saveProjeto(projeto), HttpStatus.CREATED);
        } catch (ExistingProjetoSameNameException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
		
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui um Projeto pelo seu id")
	public void deleteProjeto(@PathVariable Long id) {
		projetoService.deleteProjeto(id);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um Projeto pelo seu id")
	public ProjetoDTO updateProjeto(@PathVariable("id") Long id, @RequestBody ProjetoDTO projetoDTO) {
        Projeto projeto = projetoMapper.convertFromProjetoDTO(projetoDTO);
        return projetoMapper.convertToProjetoDTO(projetoService.updateProjeto(id, projeto));
    }

	@GetMapping
	@ApiOperation(value = "Busca uma lista de Projetos")
	public List<ProjetoDTO> getProjetos() {
		List<Projeto> projetos = projetoService.getProjetos();
		return projetos.stream()
						.map(projetoMapper::convertToProjetoDTO)
						.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um Projeto pelo seu id")
	public ResponseEntity<?> getProjetoById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(projetoMapper.convertToProjetoDTO(projetoService.getProjetoById(id)), HttpStatus.OK);
		} catch (NotFoundException e) {
			return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
		}
		
	}


}
