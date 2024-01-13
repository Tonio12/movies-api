package com.tonilearnsjava.movies.controllers;


import com.tonilearnsjava.movies.models.Users;
import com.tonilearnsjava.movies.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user){
        Users savedUser = null;
        ResponseEntity<String> response = null;
        try {
            String hashedPwd = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPwd);
            savedUser = userService.createUser(user);
            if (savedUser.getId() != null){
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body("User Registration Successful");
            }
        }catch (Exception ex){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An Error occurred while registering user due to : " +ex.getMessage());
        }
        return response;
    }
}
