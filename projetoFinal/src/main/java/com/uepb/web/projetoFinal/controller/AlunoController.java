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

import com.uepb.web.projetoFinal.dto.AlunoDTO;
import com.uepb.web.projetoFinal.dto.GenericResponseErrorDTO;
import com.uepb.web.projetoFinal.exceptions.ExistingAlunoSameNameException;
import com.uepb.web.projetoFinal.mapper.AlunoMapper;
import com.uepb.web.projetoFinal.model.Aluno;
import com.uepb.web.projetoFinal.services.AlunoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

@RestController
@RequestMapping("/alunos")
@Api(value = "Aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private AlunoMapper alunoMapper;

	@PostMapping
	@ApiOperation(value = "Cria um novo Aluno")
	public ResponseEntity<?> saveAluno(@RequestBody AlunoDTO alunoDTO) {
		try {
			Aluno aluno = alunoMapper.convertFromAlunoDTO(alunoDTO);
            return new ResponseEntity<>(alunoService.saveAluno(aluno), HttpStatus.CREATED);
        } catch (ExistingAlunoSameNameException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
		
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui um Aluno pelo seu id")
	public void deleteAluno(@PathVariable Long id) {
		alunoService.deleteAluno(id);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um Aluno pelo seu id")
	public AlunoDTO updateAluno(@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoMapper.convertFromAlunoDTO(alunoDTO);
        return alunoMapper.convertToAlunoDTO(alunoService.updateAluno(id, aluno));
    }

	@GetMapping
	@ApiOperation(value = "Busca uma lista de Alunos")
	public List<AlunoDTO> getAlunos() {
		List<Aluno> alunos = alunoService.getAlunos();
		return alunos.stream()
						.map(alunoMapper::convertToAlunoDTO)
						.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Busca um Aluno pelo seu id")
	public ResponseEntity<?> getAlunoById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(alunoMapper.convertToAlunoDTO(alunoService.getAlunoById(id)), HttpStatus.OK);
		} catch (NotFoundException e) {
			return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
		}
		
	}

}
