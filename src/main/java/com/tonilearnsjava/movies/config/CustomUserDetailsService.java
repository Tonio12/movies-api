package com.tonilearnsjava.movies.config;

import com.tonilearnsjava.movies.models.Users;
import com.tonilearnsjava.movies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Users user = userRepository.findByUserName(username);
            String userName = user.getUserName();
            String password = user.getPassword();
            return new User(userName, password, new ArrayList<>());
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found: " + e);
        }
    }
}
