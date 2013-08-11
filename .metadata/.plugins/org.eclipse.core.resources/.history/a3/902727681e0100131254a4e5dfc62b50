package com.common.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import noNamespace.impl.CompanyDocumentImpl.CompanyImpl.DeptImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.common.mapper.DeptRowMapper;
import com.common.model.Dept;

@Repository
public class DeptConnection {
	@Autowired
    @Qualifier("jdbctemplete")
	private JdbcTemplate jdbctemp;
	
	public String getDepts(){
		String sql = "SELECT * FROM dept";
		List<Dept> dept = jdbctemp.query(sql,new DeptRowMapper());
		String result = "<Departmets>";
		for(Dept dep : dept){
			result += "\n\t\t<Dept>" +
			"\n\t\t\t<department>" + dep.getDepartment()+ "</department>" +
			"\n\t\t\t<deptDesc>" + dep.getDeptDesc()+ "</deptDesc>"+
			"\n\t\t</Dept>" ;
		}
		
		return result + "\n\t</Departmets>";
	}
	public String getDept(String id){
		String sql = "SELECT * FROM dept WHERE department=?";
		Dept dept = jdbctemp.queryForObject(
				sql, new Object[] { id }, new DeptRowMapper());
		return "<Dept>" +
		"\n\t\t<department>" + dept.getDepartment()+"</department>" +
		"\n\t\t<deptDesc>" + dept.getDeptDesc() + "</deptDesc>"+
		"\n\t</Dept>" ;
	}
	public String postDept(String id,String desc){
		String sql = "INSERT INTO dept(department,DeptDesc) values (?,?)";
		int k = jdbctemp.update(sql,new Object[] {id, desc});
		return "<Result>" + k + " Record has been successfully Inserted to database"+ 
				"</Result>";
	}
	public String putDept(String id,String desc){
		String sql = "UPDATE dept set DeptDesc=? WHERE department=?";
		int k = jdbctemp.update(sql, new Object[] {desc,  id});
		return "<Result>" + k + " Record has been successfully Updated in database"+ 
				"</Result>";
	}
	public String deleteDept(String id){
		String sql = "DELETE FROM dept WHERE department=?";
		int k = jdbctemp.update(sql, new Object[] { id});
		return "<Result>" + k + " Record has been Deleted successfully from database"+ 
				"</Result>";
	}

}
