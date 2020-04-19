package com.tyss.springmvc.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
public class EmployeeInfoBean {
	
	@Id
	@Column
	private Integer empId;
	@Column
	private String empName;
	@Column
	private Double salary;
	@Column
	private Long mobile;
	@Column
	private Integer depId;
	@Column 
	private Integer mgrId;
	@Column 
	private String designation;
	@Column 
	private LocalDate dob;
	@Column 
	private LocalDate doj;
	@Column
	private String password;
	

}// End of class
