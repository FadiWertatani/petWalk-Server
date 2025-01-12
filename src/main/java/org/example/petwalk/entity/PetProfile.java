package org.example.petwalk.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PetProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpet;

    @Column
    private String animalType;

    @Column
    private String animalBreed;

    @Column
    private String animalAge;

    @Column
    private String animalCharacter;

    @Column
    private String animalHealth;

    @Column
    private String animalSize;

    @Column
    private String animalBehavior;
    @Column

    private String animalSex;
    @Column

    private String otherOptions;
}
