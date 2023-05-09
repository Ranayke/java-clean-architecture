package br.com.alura.escola.dominio.aluno;

public class CPF {
    private String numero;

    public CPF(String numero) {
        String cpfRegex = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}";
        if (numero == null || !numero.matches(cpfRegex)) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        this.numero = numero;
    }

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
    
    

}
