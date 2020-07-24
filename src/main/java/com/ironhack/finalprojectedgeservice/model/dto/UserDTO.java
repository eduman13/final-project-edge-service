package com.ironhack.finalprojectedgeservice.model.dto;

import com.ironhack.finalprojectedgeservice.model.security.User;

public class UserDTO {

    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
        return userDTO;
    }

    public static User userDTOToUser(UserDTO userDTO) {
        User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
        return user;
    }
}
