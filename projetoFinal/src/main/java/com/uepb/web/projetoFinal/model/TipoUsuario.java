package com.uepb.web.projetoFinal.model;

public enum TipoUsuario {
	
	ALUNO(1), PROFESSOR(2);
	
	private int tipoUsuario;

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	private TipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
