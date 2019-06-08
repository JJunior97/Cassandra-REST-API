package api.api.controller;

import api.api.domain.Message;
import api.api.request.SendRequest;
import api.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class apiController {

    @Autowired
    MessageService messageService;

    @PostMapping("message")
    public Message postMessage(@RequestBody Message message){
        return messageService.saveMessage(message);
    }

    @GetMapping("messages/{emailValue}")
    public List<Message> getMessagesByEmail(@PathVariable String emailValue){
        return messageService.getMessagesByEmail(emailValue);
    }

    @RequestMapping(value = "send", consumes = {"text/plain", "application/*", "application/x-www-form-urlencoded"}, method = RequestMethod.POST)
    @ResponseBody
    public void sendMessages(@RequestBody SendRequest sendRequest){
        List<Message> messagesToSend = messageService.getMessagesByMagicNumber(sendRequest.getMagicNumber());
        for(Message message: messagesToSend){
                messageService.sendMessage(message);
            messageService.deleteMessage(message);
        }
    }
}
