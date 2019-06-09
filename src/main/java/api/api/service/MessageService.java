package api.api.service;

import api.api.dao.MessageRepository;
import api.api.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
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
}
