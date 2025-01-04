package org.example.petwalk.services.implementations;

import org.example.petwalk.entity.Message;
import org.example.petwalk.repository.MessageRepository;
import org.example.petwalk.services.interfaces.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesByReceiver(String receiver) {
        return messageRepository.findByReceiver(receiver);
    }

    @Override
    public List<Message> getMessagesBySender(String sender) {
        return messageRepository.findBySender(sender);
    }

    @Override
    public Message markMessageAsRead(Long id) {
        return messageRepository.findById(id)
                .map(message -> {
                    message.setRead(true);
                    return messageRepository.save(message);
                }).orElseThrow(() -> new RuntimeException("Message not found"));
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
