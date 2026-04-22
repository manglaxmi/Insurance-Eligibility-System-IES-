package com.IES.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor   
@NoArgsConstructor
public class LoginResponseDTO {
	
	  public LoginResponseDTO(String token, String message) {
	        this.token = token;
	        this.message = message;
	    }
	  
	  
    public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String token;
    private String message;
}
