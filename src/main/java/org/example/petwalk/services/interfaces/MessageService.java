package org.example.petwalk.services.interfaces;

import org.example.petwalk.entity.Message;

import java.util.List;

public interface MessageService {
    Message sendMessage(Message message);

    List<Message> getMessagesByReceiver(String receiver);

    List<Message> getMessagesBySender(String sender);

    Message markMessageAsRead(Long id);

    void deleteMessage(Long id);
}
