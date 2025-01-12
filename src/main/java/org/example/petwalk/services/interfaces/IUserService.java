package org.example.petwalk.services.interfaces;

import org.example.petwalk.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User addUser(User user);

    User getUserById(Long id);

    User getUserByEmail(String email);

    User updateUser(String email, User user);
}
