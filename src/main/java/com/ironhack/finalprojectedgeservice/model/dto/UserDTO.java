package com.ironhack.finalprojectedgeservice.model.dto;

import com.ironhack.finalprojectedgeservice.model.security.User;

public class UserDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
        return userDTO;
    }
}
