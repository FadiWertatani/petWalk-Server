package org.example.petwalk.services.implementations;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.User;
import org.example.petwalk.repository.IUserRepo;
import org.example.petwalk.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserImpl implements IUserService {
    IUserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    @Override
    public User updateUser(String email, User updatedUser) {
        Optional<User> optionalUser = userRepo.findByEmail(email);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setFullName(updatedUser.getFullName());
            existingUser.setMobile(updatedUser.getMobile());
            return userRepo.save(existingUser);
        } else {
            throw new RuntimeException("User not found with ID: " + email);
        }
    }


}
