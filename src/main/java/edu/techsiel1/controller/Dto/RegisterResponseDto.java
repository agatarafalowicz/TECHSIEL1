package edu.techsiel1.controller.Dto;

import edu.techsiel1.commonTypes.UserRole;

public class RegisterResponseDto {
    private String userName;
    private UserRole role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
