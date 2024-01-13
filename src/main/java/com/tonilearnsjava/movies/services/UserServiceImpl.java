package com.tonilearnsjava.movies.services;

import com.tonilearnsjava.movies.models.Users;
import com.tonilearnsjava.movies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }
}
