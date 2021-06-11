package com.uepb.web.projetoFinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String matricula;
	@OneToOne
	(mappedBy = "professor")
	private Projeto projeto;
	
	public Professor(long id, String nome, String matricula, Projeto projeto) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.projeto = projeto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", projeto="
				+ projeto + "]";
	}
	
}
