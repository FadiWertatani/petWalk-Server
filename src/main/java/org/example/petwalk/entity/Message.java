package org.example.petwalk.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  Long idMessage;

    public String content;

    public Date timestamp;

    public String sender;

    public String receiver;

    public boolean isRead;

    public   boolean isSent;



    @ManyToOne
    @JoinColumn(name = "idConversation", nullable = false)
    public Conversation conversation;


    public void setTimestamp() {
    }
}
