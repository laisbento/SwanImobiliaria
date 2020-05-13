package com.swanimobiliaria.model.service;

import com.swanimobiliaria.model.domain.User;
import com.swanimobiliaria.model.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public UUID findByUsernameAndPassword(String username, String password) {
        Optional<User> userName = userJpaRepository.findByUsername(username);
        boolean login = userName
                .map(user -> BCrypt.checkpw(password, user.getPassword()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong username"));

        if(!login) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password");
        }

        Optional<UUID> userId = userName.map(User::getId);

        return userId.orElse(null);

    }

    public UUID findByUserId(UUID userId) {
        return userJpaRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unable to find user"))
                .getId();
    }
}
