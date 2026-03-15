package com.example.thicketmanaging.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginRequest implements Serializable {
    private String username;
    private String password;

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
}