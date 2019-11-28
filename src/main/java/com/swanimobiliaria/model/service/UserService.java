package com.swanimobiliaria.model.service;

import com.swanimobiliaria.model.exception.ResourceNotFoundException;
import com.swanimobiliaria.model.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public boolean findByUsernameAndPassword(String username, String password) {
        return userJpaRepository.findByUsername(username)
                .map(user -> BCrypt.checkpw(password, user.getPassword()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong username or password"));
    }
}
