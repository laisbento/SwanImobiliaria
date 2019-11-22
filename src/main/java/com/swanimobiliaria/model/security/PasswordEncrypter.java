package com.swanimobiliaria.model.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncrypter {

    private PasswordEncrypter() {
    }

    @Bean
    private static PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static String encodePasssword(String password){
        PasswordEncoder encoder = getEncoder();
        return encoder.encode(password);
    }
}
