package org.example.petwalk.restController;

import org.example.petwalk.entity.Message;
import org.example.petwalk.services.interfaces.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        return ResponseEntity.ok(messageService.sendMessage(message));
    }

    @GetMapping("/received")
    public ResponseEntity<List<Message>> getReceivedMessages(@RequestParam String receiver) {
        return ResponseEntity.ok(messageService.getMessagesByReceiver(receiver));
    }

    @GetMapping("/sent")
    public ResponseEntity<List<Message>> getSentMessages(@RequestParam String sender) {
        return ResponseEntity.ok(messageService.getMessagesBySender(sender));
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<Message> markMessageAsRead(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.markMessageAsRead(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
