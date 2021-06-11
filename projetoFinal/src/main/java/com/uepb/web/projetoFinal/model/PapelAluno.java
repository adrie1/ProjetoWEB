package com.uepb.web.projetoFinal.model;

public enum PapelAluno {
	
	ESTAGIO(1), JUNIOR(2), PLENO(3), SENIOR(4), MASTER(5);
	
	private int papelAluno;

	private PapelAluno(int papelAluno) {
		this.papelAluno = papelAluno;
	}

	public int getPapelAluno() {
		return papelAluno;
	}

	public void setPapelAluno(int papelAluno) {
		this.papelAluno = papelAluno;
	}

}
