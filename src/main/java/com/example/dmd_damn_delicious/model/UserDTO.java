package com.example.dmd_damn_delicious.model;

public class UserDTO {

    private Long id;
    private String username;
    private boolean admin;

    public static UserDTO fromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.id = user.getId();
        userDTO.username = user.getUsername();
        userDTO.admin = user.isAdmin();
        return userDTO;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdmin() {
        return admin;
    }

}
