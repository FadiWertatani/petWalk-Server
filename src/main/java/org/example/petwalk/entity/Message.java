package org.example.petwalk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.petwalk.entity.Conversation;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;  // Texte du message
    private Date timestamp;  // Horodatage
    private boolean sent;    // Indique si le message est envoyé ou reçu
    private boolean imageMessage;  // Si le message contient une image
    private String imageBase64;    // Contenu de l'image encodé en Base64
    private boolean audioMessage;  // Si le message contient un audio
    private String audioFilePath;  // Chemin ou URL du fichier audio
    private boolean isRead; // Ensure this field exists
    private String sender;
    private String receiver;


    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false)
    private Conversation conversation;
}
