package com.example.demo.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DeptDao;
import com.example.demo.dao.EmpDao;
import com.example.demo.entity.Emp;

@Service
public class EmpService {
	@Autowired
	private EmpDao empDao;
	@Autowired
	private DeptDao deptDao;
	
	// 사원 목록
	public List<Emp> list(){
		return empDao.findAll();
	}
	
	// 사원
	public Emp read(Long empno) {
		return empDao.findByEmpno(empno);
	}
	
	// 추가를 위한 데이터 : 관리자 목록, 부서번호 목록, job 목록
	public Map<String,Object> findAddInfo(){
		List<String> jobs = empDao.findjob();
		List<Long> deptnos = empDao.findDeptnos();
		List<Long> mgrs = empDao.findMgrs();
		
		Map<String,Object> map = new HashMap<>();
		map.put("jobs", jobs);
		map.put("deptnos", deptnos);
		map.put("mgrs", mgrs);
		return map;
	}
	
	// 추가 : 사번은 백에서, 입사일은 없는 경우 오늘
	public Boolean add(Emp emp) {
		Long newEmpno = empDao.max()+1;
		if(emp.getHiredate()==null) {
			emp.setHiredate(LocalDate.now());
		}
		emp.setEmpno(newEmpno);
		return empDao.save(emp)==1L;
	}
	
}
