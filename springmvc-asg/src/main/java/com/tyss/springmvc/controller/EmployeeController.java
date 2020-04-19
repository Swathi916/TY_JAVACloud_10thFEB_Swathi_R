package com.tyss.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tyss.springmvc.beans.EmployeeInfoBean;
import com.tyss.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/getEmployee")
	public String getSearchEmployeeForm() {
		
		return "searchEmp";
	}// End of getSearchEmployeeForm()
	
	@GetMapping("/getEmployee")
	public String getEmployee(int empId, ModelMap modelMap) {
		EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
		
		if (employeeInfoBean != null) {
			modelMap.addAttribute("empInfo", employeeInfoBean);
		} else {
			modelMap.addAttribute("errMsg", "Employee Id " + empId + " Not Found!");
		}
		
		return "searchEmp";
	}
	
	@GetMapping("/list")
	public String allEmp(HttpServletRequest request) {
		request.setAttribute("employees", service.getAllEmp());
		return"list";
	}
	
//	@GetMapping("/add")
//	public String addEmp(HttpServletRequest request) {
//		return null;
//		
//	}
}
