package api.api.controller;

import api.api.model.Message;
import api.api.request.PostMessageRequest;
import api.api.request.SendRequest;
import api.api.service.MailService;
import api.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    MailService mailService;

    @RequestMapping(value = "message", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Message postMessage(@RequestBody PostMessageRequest messageRequest){
        Message message = new Message();
        message.setEmail(messageRequest.getEmail());
        message.setTitle(messageRequest.getTitle());
        message.setContent(messageRequest.getContent());
        message.setMagicNumber(messageRequest.getMagic_number());
        return messageService.saveMessage(message);
    }

    @RequestMapping(value = "messages/{emailValue}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Message> getMessagesByEmail(@PathVariable String emailValue){
        return messageService.getMessagesByEmail(emailValue);
    }

    @RequestMapping(value = "send", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void sendMessages(@RequestBody SendRequest sendRequest){
        List<Message> messagesToSend = messageService.getMessagesByMagicNumber(sendRequest.getMagic_number());

        messagesToSend.forEach(message -> {
            mailService.sendMessage(message);
            messageService.deleteMessage(message);
            });
    }
}