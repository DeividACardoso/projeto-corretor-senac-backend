package br.sc.senac.tcs.service;

import java.util.Optional;

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
    
//    public UserDetails recuperarSenha(Integer id, Corretor corretorAtualizar) throws CampoInvalidoException {
//    	usuarioRepository.existsById(id);
//    	if(corretorAtualizar.getEmail() != null) {
//    		
//    	}
//    	corretorAtualizar.setSenha(corretorAtualizar.getSenha());
//		return usuarioRepository.saveAndFlush(corretorAtualizar);
//	}
    
    public UserDetails enviarEmail(Integer id, Corretor corretorAtualizar) throws CampoInvalidoException {
        if (!usuarioRepository.existsById(id)) {
            throw new CampoInvalidoException("Usuário não encontrado");
        }

        Corretor corretorExistente = usuarioRepository.findByEmail(corretorAtualizar.getEmail());
        if (corretorExistente != null && !corretorExistente.getId().equals(id)) {
            throw new CampoInvalidoException("Email já cadastrado no sistema");
        }

        corretorAtualizar.setSenha(corretorAtualizar.getSenha());
        return usuarioRepository.save(corretorAtualizar);
    }
    
}
