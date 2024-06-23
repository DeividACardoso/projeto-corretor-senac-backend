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
    
    public UserDetails atualizarSenha(Integer id, Corretor corretorAtualizar) throws CampoInvalidoException {
    	usuarioRepository.existsById(id);
    	corretorAtualizar.setSenha(corretorAtualizar.getSenha());
		return usuarioRepository.saveAndFlush(corretorAtualizar);
	}
    
}
