package org.example.petwalk.services.implementations;

import org.example.petwalk.entity.Conversation;
import org.example.petwalk.repository.ConversationRepository;
import org.example.petwalk.services.implementations.ConversationServiceImpl;
import org.example.petwalk.services.interfaces.ConversationService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ConversationServiceImpl implements ConversationService {

    private final ConversationRepository conversationRepository;

    public ConversationServiceImpl(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    @Override
    public Conversation createConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    @Override
    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }

    @Override
    public Optional<Conversation> getConversationById(Long id) {
        return conversationRepository.findById(id);
    }

    @Override
    public Conversation updateConversation(Long id, Conversation updatedConversation) {
        return conversationRepository.findById(id)
                .map(conversation -> {
                    conversation.setUserName(updatedConversation.getUserName());
                    conversation.setLastMessage(updatedConversation.getLastMessage());
                    conversation.setTimestamp(updatedConversation.getTimestamp());
                    conversation.setUserImageUrl(updatedConversation.getUserImageUrl());
                    return conversationRepository.save(conversation);
                }).orElseThrow(() -> new RuntimeException("Conversation not found"));
    }

    @Override
    public void deleteConversation(Long id) {
        conversationRepository.deleteById(id);
    }
}
