package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * 웹에서 사용자 입력은 모두 문자열이다
 * 스프링이 사용자 입력 문자열을 적절한 객체로 바꿔줘야한다
 * 
 * 그런데 스프링 프레임워크는 수많은 작은 부품들의 결합체 -> 언제든지 업그레이드 해야하기 때문에
 * 
 * 스프링에서 입력 문자열을 객체로 바꾸는 인터페이스(표준) : PropretyEditor
 * 그리고 스프링은 십여개의 PropertyEditor를 제공
 * 
 * ?학생=1					Long 학생 = 1
 * ?학생=1					Boolean 학생 = true;
 * 							과거에는 실패했는데 현재는 된다
 * ?hiredate=2024-01-20		변환 어노테이션을 제공
 */

@Data
@AllArgsConstructor
public class Emp {
	private	Long empno;
	private	String ename;
	private String job;
	private Long mgr;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate hiredate;
	private	Long sal;
	private Long comm;
	private	Long deptno;
}
