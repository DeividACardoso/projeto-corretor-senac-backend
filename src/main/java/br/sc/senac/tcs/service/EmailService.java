package br.sc.senac.tcs.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

import br.sc.senac.tcs.model.entidade.Corretor;

@Service
public class EmailService {

    @Autowired
    private SendGrid sendGrid;

    @Autowired
    private CorretorService corretorService;

    public void mandarEmailComNovaSenha(Corretor corretor, String senhaNova) throws Exception {
        Email remetente = new Email("floripasafe@gmail.com", "Floripa SAFE");
        Email para = new Email(corretor.getEmail());
        System.out.println("Email: " + corretor.getEmail() + " | Senha: " + senhaNova);

        Mail mail = new Mail();

        mail.setFrom(remetente);

        Personalization personalization = new Personalization();

        personalization.addTo(para);
        personalization.setSubject("Segue sua nova senha de acesso ao Floripa SAFE.");
        personalization.addDynamicTemplateData("senha_nova", senhaNova);

        mail.addPersonalization(personalization);
        mail.setTemplateId("d-5abc87bf90a24339a1b45ff272495a8f");

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            if (response.getStatusCode() < 200 || response.getStatusCode() > 300) {
                throw new IOException("Ocorreu algum erro ao enviar o email: " + response.getBody());
            }
        } catch (IOException ex) {
            throw new Exception("Ocorreu algum erro ao enviar o email. Verifique o destinarário e tente novamente.");
        }
    }
}
