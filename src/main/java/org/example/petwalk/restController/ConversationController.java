package org.example.petwalk.restController;

import org.example.petwalk.entity.Conversation;
import org.example.petwalk.services.interfaces.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @PostMapping
    public Conversation createConversation(@RequestBody Conversation conversation) {
        return conversationService.createConversation(conversation);
    }

    @GetMapping("/{id}")
    public Conversation getConversationById(@PathVariable Long id) {
        return conversationService.getConversationById(id);
    }

    @GetMapping("/user/{userName}")
    public List<Conversation> getConversationsByUserName(@PathVariable String userName) {
        return conversationService.getConversationsByUserName(userName);
    }

    @DeleteMapping("/{id}")
    public void deleteConversation(@PathVariable Long id) {
        conversationService.deleteConversation(id);
    }
}
