package com.uepb.web.projetoFinal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	@OneToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	@OneToMany(mappedBy = "projeto")
	private List<Aluno> alunos;
	

	public Projeto(long id, String nome, String descricao, Professor professor, List<Aluno> alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.professor = professor;
		this.alunos = alunos;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Projeto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", professor=" + professor
				+ ", alunos=" + alunos + "]";
	}

}
