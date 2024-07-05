package br.sc.senac.tcs.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.tcs.model.dto.TrocaDeSenhaDTO;
import br.sc.senac.tcs.model.entidade.Corretor;
import br.sc.senac.tcs.model.repository.CorretorRepository;
import br.sc.senac.tcs.service.EmailService;

@RestController
@RequestMapping("/api/recuperacao")
public class RecuperacaoController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private CorretorRepository corretorRepository;

    @PostMapping("/atualizar-senha")
    public ResponseEntity resetPassword(@RequestBody Corretor data) throws Exception {
        Corretor corretor = this.corretorRepository.getByEmail(data.getEmail());

        if (corretor == null) {
            return ResponseEntity.badRequest().body("Email not found.");
        }

        String newPassword = generateRandomPassword();
        String encryptedPassword = new BCryptPasswordEncoder().encode(newPassword);

        corretor.setSenha(encryptedPassword);
        this.corretorRepository.save(corretor);

        this.emailService.mandarEmailComNovaSenha(corretor, newPassword);

        return ResponseEntity.ok().body("A new password has been sent to your email.");
    }

    private String generateRandomPassword() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
