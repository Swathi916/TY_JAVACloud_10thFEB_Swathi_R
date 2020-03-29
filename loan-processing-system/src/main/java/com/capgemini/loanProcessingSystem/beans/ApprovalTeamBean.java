package com.capgemini.loanProcessingSystem.beans;

import lombok.Data;

@Data
public class ApprovalTeamBean {
	private Integer empId;
	private String firstName;
	private String lastName;
	private String password;
	private String emailId;
	private Integer applicationId;
	private String status;
	private String userName;

}
