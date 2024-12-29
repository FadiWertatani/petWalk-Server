package org.example.petwalk.services.implementations;

import org.example.petwalk.entity.Conversation;
import org.example.petwalk.entity.Message;
import org.example.petwalk.repository.ConversationRepository;
import org.example.petwalk.repository.MessageRepository;
import org.example.petwalk.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    @Override
    public Message sendMessage(Message message, Long conversationId) {
        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new RuntimeException("Conversation non trouvée avec l'ID : " + conversationId));

        message.setConversation(conversation);
        message.setTimestamp(); // Ajouter la date d'envoi
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesByConversationId(Long conversationId) {
        return messageRepository.findMessagesByConversationIdOrdered(conversationId);
    }

    @Override
    public Message getLastMessageByConversationId(Long conversationId) {
        return messageRepository.findLastMessageByConversationId(conversationId);
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
