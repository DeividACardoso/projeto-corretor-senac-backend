package br.sc.senac.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.tcs.model.entidade.AuthenticationDTO;
import br.sc.senac.tcs.model.entidade.Corretor;
import br.sc.senac.tcs.model.entidade.LoginResponseDTO;
import br.sc.senac.tcs.model.entidade.RegisterDTO;
import br.sc.senac.tcs.model.infra.security.TokenService;
import br.sc.senac.tcs.model.repository.CorretorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = { "http://localhost:8081", "exp://10.10.101.170:8081", "http://localhost:9000" }, maxAge = 3600)
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CorretorRepository corretorRepository;

    @Autowired
    private TokenService tokenService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        if (this.corretorRepository.findByEmail(data.login()) == null) {
            return ResponseEntity.badRequest().body("Login não encontrado.");
        }

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        var corretor = corretorRepository.getByEmail(data.login());

        var token = tokenService.GenerateToken((Corretor) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token, corretor.getEmail(), corretor.getCpf()));
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.corretorRepository.findByEmail(data.email()) != null)
            return ResponseEntity.badRequest().body("Login já utilizado.");

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());

        Corretor corretor = new Corretor(data.email(), data.nome(), encryptedPassword, data.telefone(), data.cpf());

        this.corretorRepository.save(corretor);

        return ResponseEntity.ok().build();
    }

}