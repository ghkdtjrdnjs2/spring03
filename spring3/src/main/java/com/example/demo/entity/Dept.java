package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dept {
	private Long deptno;
	private String dname;
	private String Loc;
}
