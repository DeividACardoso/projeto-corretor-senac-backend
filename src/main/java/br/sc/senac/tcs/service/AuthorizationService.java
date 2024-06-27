package br.sc.senac.tcs.service;

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

	public UserDetails enviarEmail(Corretor corretorAtualizar) throws CampoInvalidoException {
		if (!usuarioRepository.existsById(corretorAtualizar.getId())) {
			throw new CampoInvalidoException("Usuário não encontrado");
		}

		Corretor corretorExistente = usuarioRepository.findByEmail(corretorAtualizar.getEmail());
		if (corretorExistente != null && !corretorExistente.getId().equals(corretorAtualizar.getId())) {
			throw new CampoInvalidoException("Email já cadastrado no sistema");
		}

//        enviarEmailCorretor(corretorAtualizar);

		return usuarioRepository.save(corretorAtualizar);
	}

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
	private String remetente;

	public String enviarEmailTexto(String destinatario, String assunto, String mensagem) {

		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(remetente);
			simpleMailMessage.setTo(destinatario);
			simpleMailMessage.setSubject(assunto);
			simpleMailMessage.setText(mensagem);
			javaMailSender.send(simpleMailMessage);
			return "Email enviado";
		} catch (Exception e) {
			return "Erro ao enviar email " + e.getLocalizedMessage();
		}

	}

}
