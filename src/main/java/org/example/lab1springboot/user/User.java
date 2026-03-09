package org.example.lab1springboot.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotEmpty
    @NotNull(message = "Username cannot be empty")
    private String username;

    @NotNull(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotNull(message = "Id cannot be empty")
    private String id;



}
