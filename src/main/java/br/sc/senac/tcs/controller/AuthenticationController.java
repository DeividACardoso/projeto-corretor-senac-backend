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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.tcs.model.entidade.AuthenticationDTO;
import br.sc.senac.tcs.model.entidade.Corretor;
import br.sc.senac.tcs.model.entidade.LoginResponseDTO;
import br.sc.senac.tcs.model.entidade.RegisterDTO;
import br.sc.senac.tcs.model.infra.security.TokenService;
import br.sc.senac.tcs.model.repository.CorretorRepository;
import br.sc.senac.tcs.service.AuthorizationService;
import br.sc.senac.tcs.service.EmailServiceSpring;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500", "*" }, maxAge = 3600)
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CorretorRepository corretorRepository;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private EmailServiceSpring emailServiceSpring;
	
	

	@Autowired
	private AuthorizationService authService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		if (this.corretorRepository.findByEmail(data.login()) == null) {
			return ResponseEntity.badRequest().body("Login não encontrado.");
		}

		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());

		var auth = this.authenticationManager.authenticate(usernamePassword);

		System.out.println("Login para token: " + data.login());
		var corretor = corretorRepository.getByEmail(data.login());

		var token = tokenService.GenerateToken((Corretor) auth.getPrincipal());

		return ResponseEntity
				.ok(new LoginResponseDTO(token, corretor.getEmail(), corretor.getCpf(), corretor.getRole()));
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		System.out.println("login: " + data.email() + " | Senha: " + data.senha());
		if (this.corretorRepository.findByEmail(data.email()) != null)
			return ResponseEntity.badRequest().body("Login já utilizado.");

		String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());

		Corretor corretor = new Corretor(data.email(), data.nome(), encryptedPassword, data.telefone(), data.cpf());

		this.corretorRepository.save(corretor);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/enviar-email")
	public String enviarEmail() {
		System.out.println("AQUI FOII");
		emailServiceSpring.sendEmail("vitorgarciadevasconcelos@gmail.com", "Assunto", "Teste de envio de email");
		System.out.println("Passou aqui");
		return "Email de recuperação enviado com sucesso.";

	}

}