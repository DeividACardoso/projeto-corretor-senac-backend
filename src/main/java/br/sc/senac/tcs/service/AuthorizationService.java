package br.sc.senac.tcs.service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.exception.CampoInvalidoException;
import br.sc.senac.tcs.model.entidade.Corretor;
import br.sc.senac.tcs.model.repository.CorretorRepository;

@Service
public class AuthorizationService implements UserDetailsService {

	@Autowired
	CorretorRepository usuarioRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepository.findByEmail(username);
	}

//	public UserDetails enviarEmail(Corretor corretorAtualizar) throws CampoInvalidoException {
//		if (!usuarioRepository.existsById(corretorAtualizar.getId())) {
//			throw new CampoInvalidoException("Usuário não encontrado");
//		}
//
//		Corretor corretorExistente = usuarioRepository.findByEmail(corretorAtualizar.getEmail());
//		if (corretorExistente != null && !corretorExistente.getId().equals(corretorAtualizar.getId())) {
//			throw new CampoInvalidoException("Email já cadastrado no sistema");
//		}
//
////        enviarEmailCorretor(corretorAtualizar);
//
//		return usuarioRepository.save(corretorAtualizar);
//	}

//    private void enviarEmailCorretor(Corretor corretor) {
//        // Lógica para enviar o email
//        String destinatario = corretor.getEmail();
//        String assunto = "Atualização de Senha";
//        String mensagem = "Olá " + corretor.getNome() + ",\n\nSeus dados foram atualizados com sucesso.\n\nAtenciosamente,\nEquipe";
//        
//		// Você pode usar uma biblioteca como JavaMail para enviar o email
//        emailService.enviarEmail(destinatario, assunto, mensagem);
//    	
//    }
//	private String remetente;
	private static final String USERNAME = "vitorgarciabackup@gmail.com";
	private static final String PASSWORD = "password";

	private Session getSession() {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		return Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});
	}

	public void sendEmail(List<String> recipients, String subject, String messageBody) {
		try {
			Message message = new MimeMessage(getSession());
			message.setFrom(new InternetAddress(USERNAME));

			for (String recipient : recipients) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			}

			message.setSubject(subject);
			message.setText(messageBody);

			Transport.send(message);

			System.out.println("Emails enviados com sucesso!");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

//	public String enviarEmailTexto(String destinatario, String assunto, String mensagem) {
//
//		try {
//			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//			simpleMailMessage.setFrom(remetente);
//			simpleMailMessage.setTo(destinatario);
//			simpleMailMessage.setSubject(assunto);
//			simpleMailMessage.setText(mensagem);
//			javaMailSender.send(simpleMailMessage);
//			return "Email enviado";
//		} catch (Exception e) {
//			return "Erro ao enviar email " + e.getLocalizedMessage();
//		}
//	}
	
//    public String generateRecoveryCode() {
//        Random random = new Random();
//        int code = 100000 + random.nextInt(900000);
//        return String.valueOf(code);
//    }

}
