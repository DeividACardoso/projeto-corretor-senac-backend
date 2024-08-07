package br.sc.senac.tcs.service;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.sc.senac.tcs.model.repository.CorretorRepository;

@Service
public class AuthorizationService implements UserDetailsService {

	@Autowired
	CorretorRepository usuarioRepository;

	
//	private EmailService emailService;

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

	public void enviarEmail() {
//		List<String> recipients, String subject, String messageBody
//		try {
//			Message message = new MimeMessage(getSession());
//			message.addRecipients(null, null);
//			message.setFrom(new InternetAddress(USERNAME));
//
//			for (String recipient : recipients) {
//				message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//			}
//
//			message.setSubject(subject);
//			message.setText(messageBody);
//
//			Transport.send(message);
			EmailServiceSpring emailService = new EmailServiceSpring();
			emailService.sendEmail("vitorgarciadevasconcelos@gmail.com", "Assunto", "Teste de envio de email");


//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
	}
//	public void solicitarRecuperacaoSenha(String email) {
////		Corretor corretores = usuarioRepository.findByEmail(email);
////	        Corretor findByEmail(String email);
//
//		Corretor corretor = usuarioRepository.findByEmail(email);
//
//		if (corretor != null) {
//			String token = gerarTokenRecuperacaoSenha(); // Implemente este método para gerar um token único
//			String resetLink = "http://seu-dominio.com/reset-senha?token=" + token;
//
//			String subject = "Recuperação de Senha";
//			String text = "Olá, " + corretor.getNome() + "\n\n" + "Clique no link abaixo para redefinir sua senha:\n"
//					+ resetLink;
//
//			emailService.enviarMessagem(token, subject, text);
//
//			// Salve o token no banco de dados associado ao corretor, se necessário
//			// corretor.setResetToken(token);
//			// corretorRepository.save(corretor);
//		} else {
//			throw new UsernameNotFoundException("Corretor não encontrado com o email: " + email);
//		}
//	}
	
//	 public boolean solicitarRecuperacaoSenha(String email) {
//	        Corretor corretor = usuarioRepository.findByEmail(email);
//	        if (corretor != null) {
//	            String token = gerarTokenRecuperacaoSenha();  // Implemente este método para gerar um token único
//
//	            String subject = "Recuperação de Senha";
//	            String text = "Olá, " + corretor.getNome() + "\n\n" +
//	                          "O seu código de recuperação é: " + token;
////	            		no link abaixo para redefinir sua senha:\n" + resetLink;
//
//	            emailService.enviarMessagem(token, subject, text);
//
//	            return true; // Email enviado com sucesso
//	        } else {
//	            return false; // Corretor não encontrado
//	        }
//	    }
//
//	private String gerarTokenRecuperacaoSenha() {
//		// Implemente um método para gerar um token único para recuperação de senha
//		return UUID.randomUUID().toString();
//	}

}
