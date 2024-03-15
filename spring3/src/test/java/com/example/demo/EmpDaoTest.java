package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.EmpDao;

@SpringBootTest
public class EmpDaoTest {
	@Autowired
	private EmpDao empDao;
	
	@Test
	public void findByEnameAndEmpnoTest() {
		assertEquals(true, empDao.findByEnameAndEmpno("SMITH", 7369L));
	} 
}
