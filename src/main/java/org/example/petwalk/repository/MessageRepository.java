package org.example.petwalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.example.petwalk.entity.Message;
import java.util.List;

@EnableJpaAuditing
@EnableJpaRepositories(basePackageClasses = Message.class)
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Find messages in a conversation, sorted by date
    @Query("SELECT m FROM Message m WHERE m.conversation.idConversation = :conversationId ORDER BY m.timestamp ASC")
    List<Message> findMessagesByConversationIdOrdered(@Param("conversationId") Long conversationId);

    // Find messages by conversation ID
    @Query("SELECT m FROM Message m WHERE m.conversation.idConversation = :conversationId")
    List<Message> findByConversationId(@Param("conversationId") Long conversationId);

    // Find the last message in a conversation
    @Query("SELECT m FROM Message m WHERE m.conversation.idConversation = :conversationId ORDER BY m.timestamp DESC")
    Message findLastMessageByConversationId(@Param("conversationId") Long conversationId);

    // Find messages by receiver
    List<Message> findByReceiver(String receiver);

    // Find messages by sender
    List<Message> findBySender(String sender);
}


