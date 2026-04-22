package com.IES.dto;

import lombok.Data;

@Data
public class ForgetpasswordDto {
    private String email;

    public String getEmail() {
        return email;
    }
}