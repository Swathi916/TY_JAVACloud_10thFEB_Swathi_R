package com.tyss.springmvc.service;

import java.util.List;

import com.tyss.springmvc.beans.EmployeeInfoBean;

public interface EmployeeService {

		public EmployeeInfoBean getEmployee(Integer empId);
		public void addEmp(EmployeeInfoBean employee);
		List<EmployeeInfoBean> getAllEmp();
		public void deleteEmp(Integer id);
		public void updateEmp(EmployeeInfoBean employee);
		
	}

	

