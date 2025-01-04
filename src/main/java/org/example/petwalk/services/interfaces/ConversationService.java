package org.example.petwalk.services.interfaces;

import org.example.petwalk.entity.Conversation;

import java.util.List;
import java.util.Optional;

public interface ConversationService {
    Conversation createConversation(Conversation conversation);

    List<Conversation> getAllConversations();

    Optional<Conversation> getConversationById(Long id);

    Conversation updateConversation(Long id, Conversation updatedConversation);

    void deleteConversation(Long id);
}
