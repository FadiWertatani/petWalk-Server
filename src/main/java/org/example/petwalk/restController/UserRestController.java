package org.example.petwalk.restController;

import lombok.AllArgsConstructor;
import org.example.petwalk.User;
import org.example.petwalk.services.interfaces.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserRestController {

    IUserService userService;

    @GetMapping(path = "/user/get-all")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
