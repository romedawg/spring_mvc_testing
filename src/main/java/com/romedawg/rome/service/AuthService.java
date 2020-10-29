package com.romedawg.rome.service;

import com.romedawg.rome.DTO.LoginRequest;
import com.romedawg.rome.DTO.RegisterRequest;
import com.romedawg.rome.Domain.User;
import com.romedawg.rome.Repositories.Post.UserRepository;
import com.romedawg.rome.security.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class AuthService {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;

    public void signup(RegisterRequest registerRequest){

        User user = new User();
        log.info("username is: " +registerRequest.getUsername());
        user.setUserName(registerRequest.getUsername());
        log.info("email is: " + registerRequest.getEmail());
        user.setEmail(registerRequest.getEmail());
        log.info("get password via encodePassword method");
        // This works
//        String password = encodePassword("test");
        String password = encodePassword(registerRequest.getPassword());
        log.info("password is: " + password);
        user.setPassword(password);

        userRepository.save(user);
    }

    private String encodePassword(String password){
        log.info("trying to call passwordEncoder.encode");
        log.info("password to encode is " + password);
        return passwordEncoder.encode(password);
    }

    public String login(LoginRequest loginRequest){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return jwtProvider.generateToken(authenticate);
    }

}
