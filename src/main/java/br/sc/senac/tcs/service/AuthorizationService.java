package br.sc.senac.tcs.service;


import org.springframework.beans.factory.annotation.Autowired;
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
    
}
