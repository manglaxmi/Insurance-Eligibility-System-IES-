package com.IES.service;

import com.IES.dto.ForgetpasswordDto;
import com.IES.dto.LoginRequestDTO;
import com.IES.dto.LoginResponseDTO;
import com.IES.dto.SignUpDto;

public interface UserService {

    String signUp(SignUpDto dto);

    String forgetPassword(ForgetpasswordDto dto);

    LoginResponseDTO login(LoginRequestDTO dto);
}