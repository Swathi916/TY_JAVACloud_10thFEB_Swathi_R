package com.tyss.springmvc.dao;

import java.util.List;


import com.tyss.springmvc.beans.EmployeeInfoBean;
import com.tyss.springmvc.beans.Login;

public interface EmployeeDAO {

	public EmployeeInfoBean getEmployee(Integer empId);
	public void addEmp(EmployeeInfoBean employee);
	List<EmployeeInfoBean> getAllEmp();
	public void deleteEmp(Integer id);
	public void updateEmp(EmployeeInfoBean employee);
	//public String authenticate(Login login) ;
	
}
