package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDto;


@Service
public class LoginService {
	// application.properries에 만든 상수 읽어오기
	@Value("${sample3.admin.username}")
	private String username;
	@Value("${sample3.admin.password}")
	private String password;
	
	public Boolean login(LoginDto loginDto) {
		return loginDto.getUsername().equals(username)&&
				loginDto.getPassword().equals(password);
	}
}
