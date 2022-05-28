package com.duth.engapp.payload;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
}