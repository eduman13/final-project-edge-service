package com.ironhack.finalprojectedgeservice.controller;

import com.ironhack.finalprojectedgeservice.exception.NotValidCredentialsException;
import com.ironhack.finalprojectedgeservice.model.dto.DoctorDTO;
import com.ironhack.finalprojectedgeservice.model.dto.UserDTO;
import com.ironhack.finalprojectedgeservice.model.security.User;
import com.ironhack.finalprojectedgeservice.repository.UserRepository;
import com.ironhack.finalprojectedgeservice.service.UserService;
import com.ironhack.finalprojectedgeservice.utils.security.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestBody User user) {
        UserDetails securedUser = userDetailsService.loadUserByUsername(user.getUsername());
        if(PasswordUtil.isPassword(user.getPassword(),securedUser.getPassword())){
            return (User) securedUser;
        } else {
            throw new NotValidCredentialsException();
        }
    }

    @GetMapping("/user/find_by_username")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("/user/create_user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

}


