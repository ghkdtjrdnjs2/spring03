package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Dept;

@Mapper
public interface DeptDao {
	@Select("select * from dept where deptno=#{deptno} and rownum=1")
	public Dept findByDeptno(Long deptno);
}
