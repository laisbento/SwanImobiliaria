package com.swanimobiliaria.model.service;

import com.swanimobiliaria.model.converter.UserConverter;
import com.swanimobiliaria.model.domain.User;
import com.swanimobiliaria.model.dto.UserDTO;
import com.swanimobiliaria.model.exception.ConflictException;
import com.swanimobiliaria.model.exception.ResourceNotFoundException;
import com.swanimobiliaria.model.repository.UserJpaRepository;
import com.swanimobiliaria.model.type.UserType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public UUID findByUsernameAndPassword(String username, String password) {
        User userName = userJpaRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found"));

        boolean checkpw = BCrypt.checkpw(password, userName.getPassword());

        if (!checkpw) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password");
        }

        if (userName.getType().equals(UserType.VISITANTE.name())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not allowed");
        }

        return userName.getId();

    }

    public void findByUserId(UUID userId) {
        User user = userJpaRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unable to find user"));
        if (user.getType().equals(UserType.VISITANTE.name())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User is visitor");
        }
    }

    public List<UserDTO> getUsers(UUID auth, String username) {
        if (StringUtils.isNotBlank(username)) {
            return findAnUser(username);
        }

        findByUserId(auth);
        return userJpaRepository.findAll()
                .stream()
                .map(UserConverter::buildDTO)
                .collect(Collectors.toList());
    }

    public UserDTO createUser(UUID auth, UserDTO userDTO) {
        findByUserId(auth);
        checkIfUserExists(userDTO);

        User savedUser = userJpaRepository.save(UserConverter.buildDomain(userDTO));

        return UserConverter.buildDTO(savedUser);
    }

    public void deleteAnUser(UUID auth, UUID userId) {
        findByUserId(auth);
        if (auth.equals(userId)) {
            throw new ConflictException("You can't delete your own user");
        }

        User user = userJpaRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userJpaRepository.delete(user);
    }

    public List<UserDTO> findAnUser(String userName) {
        Optional<User> user = userJpaRepository.findByUsername(userName).or(Optional::empty);

        return user.stream()
                .map(UserConverter::buildDTO)
                .collect(Collectors.toList());
    }

    private void checkIfUserExists(UserDTO userDTO) {
        userJpaRepository.findByUsername(userDTO.getUsername()).ifPresent(user -> {
            throw new ConflictException("Username " + user.getUsername() + " already exists");
        });
    }
}
