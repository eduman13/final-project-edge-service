package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.model.dto.UserDTO;
import com.ironhack.finalprojectedgeservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO findByUsername(String username) {
        return UserDTO.userToUserDTO(userRepository.findByUsername(username));
    }
}
