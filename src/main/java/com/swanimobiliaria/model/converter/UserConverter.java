package com.swanimobiliaria.model.converter;

import com.swanimobiliaria.model.domain.User;
import com.swanimobiliaria.model.dto.UserDTO;
import com.swanimobiliaria.model.type.UserType;
import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCrypt;

@UtilityClass
public class UserConverter {

    public User buildDomain(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt(12)));
        user.setType(userDTO.getType().name());
        return user;
    }

    public UserDTO buildDTO(User user) {
        return UserDTO.builder()
                .username(user.getUsername())
                .id(user.getId())
                .type(UserType.valueOf(user.getType()))
                .build();
    }
}
