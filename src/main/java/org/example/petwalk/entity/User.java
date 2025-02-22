package org.example.petwalk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.petwalk.constants.Role;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column
    private String mobile;

    @Column(name = "profile_picture", columnDefinition = "BLOB")
    private byte[] profilePicture;

    @Enumerated(EnumType.STRING)
    private Role role;

}
