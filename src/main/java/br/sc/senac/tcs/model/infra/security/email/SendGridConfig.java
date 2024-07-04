package br.sc.senac.tcs.model.infra.security.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sendgrid.SendGrid;

@Configuration
public class SendGridConfig {

    @Value("${sendgrid.api.key}")
    private String apiKey;

    @Bean
    public SendGrid sendGrid() {
        System.out.println("apiKey: " + apiKey);
        return new SendGrid(apiKey);
    }
}
