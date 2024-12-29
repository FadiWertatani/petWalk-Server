package org.example.petwalk.services.interfaces;

import org.example.petwalk.entity.Conversation;

import java.util.List;

public interface ConversationService {
    Conversation createConversation(Conversation conversation);

    Conversation getConversationById(Long id);

    List<Conversation> getConversationsByUserName(String userName);

    void deleteConversation(Long id);
}
