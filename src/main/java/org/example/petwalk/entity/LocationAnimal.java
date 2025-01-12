package org.example.petwalk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class
LocationAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email; // email of the user or animal
    private Double latitude;
    private Double longitude;
    private LocalDateTime timestamp;
}