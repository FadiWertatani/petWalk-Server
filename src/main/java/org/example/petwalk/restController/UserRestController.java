package org.example.petwalk.restController;

import lombok.AllArgsConstructor;
import org.example.petwalk.entity.User;
import org.example.petwalk.repository.IUserRepo;
import org.example.petwalk.services.interfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserRestController {

    IUserService userService;
    IUserRepo userRepo;
//    private PasswordEncoder passwordEncoder;

    @GetMapping(path = "/user/get-all")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(path = "/user/add")
    User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/user/get-By-Id/{id}")
    User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping(path = "/user/get-By-Email/{email}")
    User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @PutMapping("/user/update/{email}")
    User updateUserProfile(@RequestBody User user, @PathVariable String email) {
        return userService.updateUser(email, user);
    }




//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody User user) {
//        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
//        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepo.save(user);
//        return ResponseEntity.ok("User registered successfully");
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody User loginRequest) {
//        Optional<User> userOptional = userRepo.findByEmail(loginRequest.getEmail());
//        if (userOptional.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), userOptional.get().getPassword())) {
//            return ResponseEntity.ok("Login successful");
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//    }


}
