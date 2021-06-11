package com.uepb.web.projetoFinal.dto;

import lombok.Data;

@Data
public class AlunoDTO {
	
	private String nome;
	private String email;
	private String matricula;
	private int quantDisciplinas;
	
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
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getQuantDisciplinas() {
		return quantDisciplinas;
	}
	public void setQuantDisciplinas(int quantDisciplinas) {
		this.quantDisciplinas = quantDisciplinas;
	}
	
	

}
