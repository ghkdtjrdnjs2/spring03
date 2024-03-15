package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.LoginDto;
import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private LoginService service; 
	
	// 컨트롤러 메소드의 리턴이 void면 jsp의 주소는 url과 같다
	@GetMapping("/member/login")
	public void login() {
	}
	
	// 서버에 사용자 정보를 저장하는 방법
	// request : 하나의 작업 동안
	// session : 쉽게 생각하면 로그아웃할 때까지
	// 			 세션은 쉽게 털릴 수 있다 -> 세션 번호의 계속적인 변경등 작업 필요
	// db : 삭제할 때 까지 저장
	@PostMapping("/member/login")
	public ModelAndView login(@ModelAttribute LoginDto loginDto, HttpSession session) {
		Boolean result = service.login(loginDto);
		if(result) {
			// 성공하면 세션에 아이디를 저장
			session.setAttribute("username", loginDto.getUsername());
			return new ModelAndView("redirect:/");
		}
		// 로그인에 실패하면 로그인으로 간다
		return new ModelAndView("redirect:/member/login?error");
	}
	// 로그아웃
	@PostMapping("/member/logout")
	public ModelAndView login(HttpSession session) {
		// 세션을 무효화(파괴) -> 세션이 없잖아?
		// 					  사용자가 세션이 없으면 자동생성
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
}