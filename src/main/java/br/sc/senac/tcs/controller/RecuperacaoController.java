package br.sc.senac.tcs.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    StringBuilder password = new StringBuilder();
    String specialCharacters = "!@#$%^&*";
    String numbers = "0123456789";
    String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";

    List<Character> passwordChars = new ArrayList<>();

    // Adiciona um caractere especial
    passwordChars.add(specialCharacters.charAt((int) (Math.random() * specialCharacters.length())));

    // Adiciona um número
    passwordChars.add(numbers.charAt((int) (Math.random() * numbers.length())));

    // Adiciona uma letra maiúscula
    passwordChars.add(uppercaseLetters.charAt((int) (Math.random() * uppercaseLetters.length())));

    // Adiciona cinco letras minúsculas
    for (int i = 0; i < 5; i++) {
        passwordChars.add(lowercaseLetters.charAt((int) (Math.random() * lowercaseLetters.length())));
    }

    // Embaralha os caracteres para garantir aleatoriedade
    Collections.shuffle(passwordChars);

    // Constrói a senha a partir dos caracteres embaralhados
    for (char c : passwordChars) {
        password.append(c);
    }

    return password.toString();
}
}
