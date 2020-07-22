package com.ironhack.finalprojectedgeservice.utils.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {

    static PasswordEncoder passwordProvider = new BCryptPasswordEncoder();

    public static boolean isPassword(String rawPassword, String encodedPassword){
        return passwordProvider.matches(rawPassword, encodedPassword);
    }

}
