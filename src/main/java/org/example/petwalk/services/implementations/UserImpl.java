package org.example.petwalk.services.implementations;

import lombok.AllArgsConstructor;
import org.example.petwalk.User;
import org.example.petwalk.repository.IUserRepo;
import org.example.petwalk.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserImpl implements IUserService {
    IUserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
