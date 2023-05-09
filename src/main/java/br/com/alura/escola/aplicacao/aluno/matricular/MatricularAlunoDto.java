package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;

public class MatricularAlunoDto {

	private String nomeALuno;
	private String cpfAluno;
	private String emailAluno;
	
	
	public MatricularAlunoDto(String nomeALuno, String cpfALuno, String emailALuno) {
		super();
		this.nomeALuno = nomeALuno;
		this.cpfAluno = cpfALuno;
		this.emailAluno = emailALuno;
	}

	public Aluno criarAluno() {
		return new Aluno(new CPF(cpfAluno), nomeALuno, new Email(emailAluno));
	}
	
}
