package org.example.petwalk.services.implementations;

import org.example.petwalk.entity.Conversation;
import org.example.petwalk.repository.ConversationRepository;
import org.example.petwalk.services.interfaces.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Override
    public Conversation createConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    @Override
    public Conversation getConversationById(Long id) {
        return conversationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conversation non trouvée avec l'ID : " + id));
    }

    @Override
    public List<Conversation> getConversationsByUserName(String userName) {
        return conversationRepository.findByUserName(userName);
    }

    @Override
    public void deleteConversation(Long id) {
        conversationRepository.deleteById(id);
    }
}
