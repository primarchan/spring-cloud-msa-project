package com.primarchan.userservice.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {

    private String email;
    private String password;
    private String name;
    private String userId;
    private LocalDateTime createdAt;

    private String encryptedPassword;

    private List<ResponseOrder> orders;

}
