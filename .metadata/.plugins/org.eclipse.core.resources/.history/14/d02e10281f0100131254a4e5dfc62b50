package com.common.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.connection.DeptConnection;
import com.common.model.Dept;

@Controller
public class CompanyHandler {

	@Autowired
	DeptConnection connection;

	@RequestMapping(value="/dept",method=RequestMethod.GET)
	public String getDepts(HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		String result ;
		try{
			result = connection.getDepts();
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return "error";	
		}
		model.addAttribute("message",result);
		return "result";

	}
	
	@RequestMapping(value="/dept/{id}",method=RequestMethod.GET)
	public String getDept(@PathVariable String id, HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		String result ;
		try{
			result = connection.getDept(id);
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return "error";	
		}
		model.addAttribute("message",result);
		return "result";

	}
	@RequestMapping(value="/dept/{deptid}/{deptDesc}",method=RequestMethod.POST)
	@Transactional
	public String postDept(@PathVariable String deptid, @PathVariable String deptDesc,
			HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		String result ;
		try{
			result = connection.postDept(deptid, deptDesc);
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		model.addAttribute("message", result);
		return "result";

	}
	@RequestMapping(value="/dept/{deptid}/{deptDesc}",method=RequestMethod.PUT)
	@Transactional
	public String putDept(@PathVariable String deptid, @PathVariable String deptDesc,
			HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		String result ;
		try{
			result = connection.putDept(deptid, deptDesc);
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		model.addAttribute("message", result);
		return "result";

	}
	@RequestMapping(value="/dept/{id}",method=RequestMethod.DELETE)
	@Transactional
	public String deleteDept(@PathVariable String id, HttpServletRequest   request,
			HttpServletResponse  response, ModelMap model) throws Exception{
		String result ;
		try{
			result = connection.deleteDept(id);
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return "error";	
		}
		model.addAttribute("message", result);
		return "result";

	}
}
