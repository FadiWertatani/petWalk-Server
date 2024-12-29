package org.example.petwalk.services.interfaces;

import org.example.petwalk.entity.Message;

import java.util.List;

public interface MessageService {
    Message sendMessage(Message message, Long conversationId);

    List<Message> getMessagesByConversationId(Long conversationId);

    Message getLastMessageByConversationId(Long conversationId);

    void deleteMessage(Long id);
}
