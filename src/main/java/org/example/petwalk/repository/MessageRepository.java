package org.example.petwalk.repository;

import org.example.petwalk.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Trouver les messages d'une conversation, triés par date
    @Query("SELECT m FROM Message m WHERE m.conversation.idConversation = :conversationId ORDER BY m.timestamp ASC")
    List<Message> findMessagesByConversationIdOrdered(@Param("conversationId") Long conversationId);

    // Trouver le dernier message d'une conversation
    @Query("SELECT m FROM Message m WHERE m.conversation.idConversation = :conversationId ORDER BY m.timestamp DESC")
    Message findLastMessageByConversationId(@Param("conversationId") Long conversationId);
}
