package org.example.petwalk.restController;

import org.example.petwalk.entity.Message;
import org.example.petwalk.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/createMessage/{conversationId}")
    public Message sendMessage(@RequestBody Message message, @PathVariable Long conversationId) {
        return messageService.sendMessage(message, conversationId);
    }

    @GetMapping("/{conversationId}")
    public List<Message> getMessagesByConversationId(@PathVariable Long conversationId) {
        return messageService.getMessagesByConversationId(conversationId);
    }

    @GetMapping("/last/{conversationId}")
    public Message getLastMessageByConversationId(@PathVariable Long conversationId) {
        return messageService.getLastMessageByConversationId(conversationId);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }
}
