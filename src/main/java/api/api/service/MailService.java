package api.api.service;

import api.api.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendMessage(Message message){
        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(message.getEmail());
            helper.setReplyTo("do-not-reply@example.com");
            helper.setFrom("do-not-reply@example.com");
            helper.setSubject(message.getTitle());
            helper.setText(message.getContent());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(mail);
    }
}
