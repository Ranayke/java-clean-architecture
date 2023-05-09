package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void naoDeveriaCriarEmailsComEnderecosInvalidos() {
		assertThrows(IllegalArgumentException.class, 
				() -> new Email(null));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Email(""));
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Email("emailinvalido"));
	}
	
	@Test
	void deveriaAceitarCriacaoDeEmailValido() {
		assertNotNull(new Email("email@example.com"));
		assertNotNull(new Email("emailtest@example.com"));
		assertNotNull(new Email("email.test@example.com"));
		assertNotNull(new Email("email_test@example.com"));
		assertNotNull(new Email("emailtest@example.com"));
	}
	

}
