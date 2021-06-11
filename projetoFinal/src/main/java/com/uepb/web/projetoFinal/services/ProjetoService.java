package com.uepb.web.projetoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uepb.web.projetoFinal.exceptions.ExistingProjetoSameNameException;
import com.uepb.web.projetoFinal.exceptions.TipoUsuarioAlunoException;
import com.uepb.web.projetoFinal.model.Projeto;
import com.uepb.web.projetoFinal.model.TipoUsuario;
import com.uepb.web.projetoFinal.model.Usuario;
import com.uepb.web.projetoFinal.repository.ProjetoRepository;

import javassist.NotFoundException;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	public Projeto saveProjeto(Projeto projeto, Usuario usuario)
			throws TipoUsuarioAlunoException, ExistingProjetoSameNameException {
		if (usuario.getTipoUsuario().equals(TipoUsuario.ALUNO)) {
			throw new TipoUsuarioAlunoException("Você não tem permissão para criar um projeto");
		} else if (usuario.getTipoUsuario().equals(TipoUsuario.PROFESSOR)) {
			if (projetoRepository.findByNome(projeto.getNome()).isPresent())
				throw new ExistingProjetoSameNameException(
						"Já possui um projeto cadastrado com o nome: " + projeto.getNome());
		}
		return projetoRepository.save(projeto);
	}

	public Projeto updateProjeto(Long id, Projeto projeto) {
		projeto.setId(id);
		return projetoRepository.save(projeto);
	}

	public List<Projeto> getProjetos() {
		return projetoRepository.findAll();
	}

	public Projeto getProjetoById(Long id) throws NotFoundException {
		return projetoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Não foi encontrado um projeto com o ID: " + id));
	}

	public void deleteProjeto(Long id) {
		Projeto projeto = projetoRepository.findById(id).get();
		projetoRepository.delete(projeto);
	}

}
