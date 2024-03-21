package com.primarchan.userservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestLogin {

    @Size(min = 2, message = "Email not be less than two characters")
    @NotNull(message = "Email cannot be null")
    private String email;

    @Size(min = 8, message = "Password must be equals or grater than 8 characters")
    @NotNull(message = "Password cannot be null")
    private String password;

}
