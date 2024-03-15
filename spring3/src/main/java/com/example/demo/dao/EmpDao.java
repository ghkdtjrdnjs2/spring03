package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Emp;

@Mapper
public interface EmpDao {
	// ename이 아이디고 empno가 비밀번호라면
	// 결과를 boolean으로 내보내기 -> 0이면 거짓, 0이 아니면 참
	@Select("select count(*) from emp where ename=#{ename} and empno=#{empno} and rownum=1")
	public Boolean findByEnameAndEmpno(String ename, Long empno);
	
	@Select("select empno, ename, job, hiredate, deptno from emp")
	public List<Emp> findAll();
	
	@Select("select * from emp where empno=#{empno} and rownum=1")
	public Emp findByEmpno(Long empno);
	
	@Select("select * from emp where deptno=#{deptno}")
	public List<Emp> findByDeptno(Long deptno);
	
	@Select("select distinct job from emp")
	public List<String> findjob();
	
	@Select("select distinct mgr from emp where mgr is not null")
	public List<Long> findMgrs();
	
	@Select("select * from emp where deptno=#{deptno}")
	public List<Long> findDeptnos();
}
