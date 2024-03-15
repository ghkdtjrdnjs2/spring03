package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.DeptDao;
import com.example.demo.entity.Dept;

@SpringBootTest
public class DeptDaoTest {
	@Autowired
	private DeptDao deptDao;
	
	@Test
	public void findByDeptnoTest() {
		Dept dept = deptDao.findByDeptno(10L);
		System.out.println(dept);
	}
}
