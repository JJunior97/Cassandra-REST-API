package api.api.service;

import api.api.repository.MessageRepository;
import api.api.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
@ComponentScan(basePackages = "api.api")
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    JavaMailSender mailSender;


    public Message saveMessage(Message message){
        return messageRepository.save(message, 300);
    }

    public void deleteMessage(Message message){
        messageRepository.delete(message);
    }

    public List<Message> getMessagesByEmail(String email){
        return messageRepository.findMessagesByEmail(email);
    }

    public List<Message> getMessagesByMagicNumber(int magicNumber){
        return messageRepository.findMessagesByMagicNumber(magicNumber);
    }

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
