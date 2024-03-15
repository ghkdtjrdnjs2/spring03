package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Emp;
import com.example.demo.service.EmpService;

import jakarta.annotation.PostConstruct;

@Controller
public class EmpController {
	@Autowired
	private EmpService service;
	
	// 가입할 때 필요한 정보들을 저장 : mgrs, deptnos, jobs
	// 서버키면 처음에 읽어오자
	private Map<String, Object> addInfo;
	
	// 스프링빈의 초기화 메소드를 지정하는 어노테이션
	// 스프링빈의 생성자는 스프링이 사용(개발자는 어노테이션을 사용한다)
	// 객체가 태어나서 죽는 것을 생명주기 또는 수명주기(life cycle)
	// 서블릿의 생명주기 : init() -> service -> destroy()
	// 스프링빈의 생명주기 : @PostConstruct -> ???? -> @PreDestroy
	// @PreDestroy : 죽기직전
	@PostConstruct
	public void init() {
		addInfo = service.findAddInfo();
	}
	
	// url을 여러개 걸려면
	@GetMapping({"/","/emp/list"})
	public ModelAndView index() {
		
		List<Emp> list = service.list();
		return new ModelAndView("emp/list").addObject("list",list);
	}
}
