package com.romedawg.rome.service;

import com.romedawg.rome.DTO.RegisterRequest;
import com.romedawg.rome.Domain.User;
import com.romedawg.rome.Repositories.Post.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public void signup(RegisterRequest registerRequest){

        User user = new User();
        user.setUserName(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodePassword(user.getPassword()));

        userRepository.save(user);


    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

}
