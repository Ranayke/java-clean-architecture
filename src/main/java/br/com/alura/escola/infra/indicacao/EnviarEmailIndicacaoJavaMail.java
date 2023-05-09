package br.com.alura.escola.infra.indicacao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.alura.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno indicado) {
	
		Properties props = new Properties();
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.socketFactory.port", "465");
	      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.port", "465");

	      // Criar uma sessão
	      Session session = Session.getDefaultInstance(props,
	         new javax.mail.Authenticator() {
	            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	               return new javax.mail.PasswordAuthentication("seuemail@gmail.com", "suasenha");
	            }
	         });

	      try {
	         // Criar uma mensagem de email
	         Message message = new MimeMessage(session);
	         message.setFrom(new InternetAddress("seuemail@gmail.com"));
	         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(indicado.getEmail()));
	         message.setSubject("Bem vindo a Escola " + indicado.getNome());
	         message.setText("Corpo do email");

	         // Enviar a mensagem
	         Transport.send(message);

	         System.out.println("Email enviado com sucesso para " + indicado.getEmail());
	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	   }

}
