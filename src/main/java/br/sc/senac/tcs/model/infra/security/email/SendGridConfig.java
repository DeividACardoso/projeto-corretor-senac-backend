package br.sc.senac.tcs.model.infra.security.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sendgrid.SendGrid;

@Configuration
public class SendGridConfig {

    private String API_KEY = "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";

    @Bean
    public SendGrid sendGrid() {
        return new SendGrid(API_KEY);
    }
}
