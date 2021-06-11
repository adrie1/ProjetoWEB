package com.uepb.web.projetoFinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	private String matricula;
	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;
	private PapelAluno papelAluno;

	public Aluno(long id, String nome, String email, String matricula, Projeto projeto) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.projeto = projeto;
	}
	
	public Aluno() {
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public PapelAluno getPapelAluno() {
		return papelAluno;
	}

	public void setPapelAluno(PapelAluno papelAluno) {
		this.papelAluno = papelAluno;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", email=" + email + ", matricula=" + matricula + ", projeto="
				+ projeto + ", papelAluno=" + papelAluno + "]";
	}
}
