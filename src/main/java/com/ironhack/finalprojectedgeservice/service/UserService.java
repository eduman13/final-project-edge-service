package com.ironhack.finalprojectedgeservice.service;

import com.ironhack.finalprojectedgeservice.model.dto.UserDTO;
import com.ironhack.finalprojectedgeservice.model.security.Role;
import com.ironhack.finalprojectedgeservice.model.security.User;
import com.ironhack.finalprojectedgeservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO findByUsername(String username) {
        return UserDTO.userToUserDTO(userRepository.findByUsername(username));
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserDTO.userDTOToUser(userDTO);
        Role role = new Role();
            role.setRole("DOCTOR");
            role.setUser(user);
            user.setRoles(Set.of(role));
        return UserDTO.userToUserDTO(userRepository.save(user));
    }
}
