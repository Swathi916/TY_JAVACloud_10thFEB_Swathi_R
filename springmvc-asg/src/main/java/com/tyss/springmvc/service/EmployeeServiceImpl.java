package com.tyss.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springmvc.beans.EmployeeInfoBean;
import com.tyss.springmvc.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public EmployeeInfoBean getEmployee(Integer empId) {
		if (empId < 1) {
			return null;
		}
		
		return dao.getEmployee(empId);
	}

	@Override
	public void addEmp(EmployeeInfoBean employee) {
		dao.addEmp(employee);
		
	}

	@Override
	public List<EmployeeInfoBean> getAllEmp() {
		return dao.getAllEmp();
	}

	@Override
	public void deleteEmp(Integer id) {
		dao.deleteEmp(id);
		
	}

	@Override
	public void updateEmp(EmployeeInfoBean employee) {
		dao.updateEmp(employee);
		
	}

}// End of class
