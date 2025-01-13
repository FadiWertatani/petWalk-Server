package org.example.petwalk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.petwalk.constants.Role;

import java.util.ArrayList;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "owner")
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToMany(mappedBy = "promeneurs")
    private List<Reservation> promeneursReservations = new ArrayList<>();
}
