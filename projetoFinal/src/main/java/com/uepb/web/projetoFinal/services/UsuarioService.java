package com.uepb.web.projetoFinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uepb.web.projetoFinal.exceptions.ExistingProjetoInexistenteException;
import com.uepb.web.projetoFinal.exceptions.ExistingProjetoSameNameException;
import com.uepb.web.projetoFinal.exceptions.ExistingUsuarioInexistenteException;
import com.uepb.web.projetoFinal.exceptions.ExistingUsuarioSameNameException;
import com.uepb.web.projetoFinal.model.Projeto;
import com.uepb.web.projetoFinal.model.Usuario;
import com.uepb.web.projetoFinal.repository.ProjetoRepository;
import com.uepb.web.projetoFinal.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProjetoRepository projetoRepository;

	public Usuario signUp(Usuario usuario) throws ExistingUsuarioSameNameException {
		if (usuarioRepository.findByUsername(usuario.getUsername()))
			throw new ExistingUsuarioSameNameException(
					"Já possui um usuario cadastrado com o nome: " + usuario.getUsername());
		return usuarioRepository.save(usuario);
	}

	public Usuario login(Usuario usuario) throws ExistingUsuarioInexistenteException {
		if (!usuarioRepository.findByUsername(usuario.getUsername())
				|| !usuarioRepository.findByPassword(usuario.getPassword()))
			throw new ExistingUsuarioInexistenteException("Username ou password incorretos!");
		return usuarioRepository.save(usuario); // MUDAR RETORNO
	}

	public Projeto visualizarProjeto(Long id) throws ExistingProjetoInexistenteException {
		if (!projetoRepository.findById(id).isPresent()) {
			throw new ExistingProjetoInexistenteException("Não foi possível encontrar um projeto com esse id!");
		}
		return projetoRepository.getById(id);
	}
}
