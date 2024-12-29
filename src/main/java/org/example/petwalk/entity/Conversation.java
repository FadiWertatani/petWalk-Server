package org.example.petwalk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Conversation {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long idConversation;

    public String userName;

    public String lastMessage;

    public String timestamp;

    public String userImageUrl;


    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;



}
