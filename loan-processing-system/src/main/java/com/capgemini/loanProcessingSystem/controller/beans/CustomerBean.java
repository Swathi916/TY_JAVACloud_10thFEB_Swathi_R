package com.capgemini.loanProcessingSystem.beans;

import lombok.Data;

@Data
public class CustomerBean {

	private Long accountNumber;
	private Long loanAccountNo;
	private Integer applicationId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private String userName;
	private String password;
	private Long mobileNumber;
	private String emailId;
	private Double accountBalance;
	private Double loanAmount;
	private Double amountToPay;
	private String loanApprovedDate;
	private Double salary;
	private  String loanType;
}
