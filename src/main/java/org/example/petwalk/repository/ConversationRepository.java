package org.example.petwalk.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.petwalk.entity.Conversation;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    // Trouver les conversations par utilisateur
    List<Conversation> findByUserName(String userName);
}
