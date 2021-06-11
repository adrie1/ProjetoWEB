package com.uepb.web.projetoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uepb.web.projetoFinal.exceptions.ExistingAlunoSameNameException;
import com.uepb.web.projetoFinal.model.Aluno;
import com.uepb.web.projetoFinal.repository.AlunoRepository;

import javassist.NotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno saveAluno(Aluno aluno) throws ExistingAlunoSameNameException {
		if (alunoRepository.findByNome(aluno.getNome()).isPresent())
			throw new ExistingAlunoSameNameException("Já possui um aluno cadastrado com o nome: " + aluno.getNome());
		return alunoRepository.save(aluno);
	}

	public Aluno updateAluno(Long id, Aluno aluno) {
		aluno.setId(id);
		return alunoRepository.save(aluno);
	}

	public List<Aluno> getAlunos() {
		return alunoRepository.findAll();
	}

	public Aluno getAlunoById(Long id) throws NotFoundException {
		return alunoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não foi encontrado um aluno com o ID: " + id));
	}

	public void deleteAluno(Long id) {
		Aluno aluno = alunoRepository.findById(id).get();
		alunoRepository.delete(aluno);
	}

}

