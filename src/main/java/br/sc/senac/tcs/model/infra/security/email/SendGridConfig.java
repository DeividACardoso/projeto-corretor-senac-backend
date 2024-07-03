package br.sc.senac.tcs.model.infra.security.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sendgrid.SendGrid;

@Configuration
public class SendGridConfig {

    private String apiKey;

    @Bean
    public SendGrid sendGrid() {
        System.out.println("apiKey: " + apiKey);
        return new SendGrid(apiKey);
    }
}
