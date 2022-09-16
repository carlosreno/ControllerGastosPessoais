package GastosPessoais.APi_Service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EnvioEmail {
    @Autowired
    private JavaMailSender mailSender;
    
    public String sendMail(String titulo, String msg, String destinatario) {
        try {
        	MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper( mail );
            helper.setTo(destinatario);
            helper.setSubject(titulo);
            helper.setText(msg, true);
            mailSender.send(mail);

            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail";
        }
    }
}
