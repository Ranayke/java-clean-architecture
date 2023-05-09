package br.com.alura.escola.dominio.aluno;

public class Email {

	private String endereco;

	public Email(String endereco) {
		String emailRegex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		if (endereco == null || !endereco.matches(emailRegex)) {
			throw new IllegalArgumentException("Endereço de e-mail inválido");
		}
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

}
