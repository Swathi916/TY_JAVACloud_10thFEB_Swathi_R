package com.capgemini.loanProcessingSystem.repository;

import java.util.ArrayList;

import com.capgemini.loanProcessingSystem.beans.AdminBean;
import com.capgemini.loanProcessingSystem.beans.ApplicationBean;
import com.capgemini.loanProcessingSystem.beans.ApprovalTeamBean;
import com.capgemini.loanProcessingSystem.beans.CustomerBean;

public class LoanProcessingSystemDB {
	public static final ArrayList<CustomerBean> CUSTOMER_BEANS = new ArrayList<CustomerBean>();

	public static final ArrayList<AdminBean> ADMIN_BEANS = new ArrayList<AdminBean>();

	public static final ArrayList<ApprovalTeamBean> APPROVAL_TEAM_BEANS = new ArrayList<ApprovalTeamBean>();

	public static final ArrayList<ApplicationBean> APPLICATION_BEANS = new ArrayList<ApplicationBean>();

	static {
		CustomerBean customerBean1 = new CustomerBean();
		customerBean1.setCustomerId(201);
		customerBean1.setUserName("Amrutha");
		customerBean1.setPassword("Amrutha@123");
		customerBean1.setFirstName("Amrutha");
		customerBean1.setLastName("K C");
		customerBean1.setDateOfBirth("28-01-1998");
		customerBean1.setApplicationId(601);
		customerBean1.setMobileNumber(9480342924L);
		customerBean1.setLoanAccountNo(1236987456321L);
		customerBean1.setEmailId("amrutha12@gmail.com");
		customerBean1.setAccountBalance(30000.23);
		customerBean1.setAmountToPay(5000.28);
		customerBean1.setLoanAmount(90000.32);
		customerBean1.setLoanAccountNo(32147852369L);
		customerBean1.setLoanApprovedDate("20-02-2020");
		customerBean1.setLoanType("Home Extention");
		CUSTOMER_BEANS.add(customerBean1);

		CustomerBean customerBean2 = new CustomerBean();
		customerBean2.setCustomerId(202);
		customerBean2.setUserName("sanant28");
		customerBean2.setPassword("Anant@123");
		customerBean2.setFirstName("Anant");
		customerBean2.setLastName("Soni");
		customerBean2.setApplicationId(602);
		customerBean2.setDateOfBirth("28-06-1998");
		customerBean2.setMobileNumber(9480112924L);
		customerBean2.setLoanAccountNo(1233232156321L);
		customerBean2.setEmailId("anant12@gmail.com");
		customerBean2.setAccountBalance(50000.23);
		customerBean2.setAmountToPay(6000.28);
		customerBean2.setLoanAmount(80000.32);
		customerBean2.setLoanAccountNo(32100052369L);
		customerBean2.setLoanApprovedDate("22-01-2020");
		customerBean2.setLoanType("Home construction");
		CUSTOMER_BEANS.add(customerBean2);

		CustomerBean customerBean3 = new CustomerBean();
		customerBean3.setCustomerId(203);
		customerBean3.setUserName("Swathi");
		customerBean3.setPassword("swathi@123");
		customerBean3.setFirstName("Swathi");
		customerBean3.setLastName("R");
		customerBean3.setApplicationId(603);
		customerBean3.setDateOfBirth("20-10-1998");
		customerBean3.setMobileNumber(8880342924L);
		customerBean3.setLoanAccountNo(8836900456321L);
		customerBean3.setEmailId("swathi.165@gmail.com");
		customerBean3.setAccountBalance(66000.23);
		customerBean3.setAmountToPay(6000.28);
		customerBean3.setLoanAmount(100000.32);
		customerBean3.setLoanAccountNo(22227852369L);
		customerBean3.setLoanApprovedDate("01-02-2020");
		customerBean3.setLoanType("Home Improvement");
		CUSTOMER_BEANS.add(customerBean3);

		CustomerBean customerBean4 = new CustomerBean();
		customerBean4.setCustomerId(204);
		customerBean4.setUserName("Sachin");
		customerBean4.setPassword("Sachin@123");
		customerBean4.setFirstName("Sachin");
		customerBean4.setLastName("H N");
		customerBean4.setApplicationId(604);
		customerBean4.setDateOfBirth("05-02-1998");
		customerBean4.setMobileNumber(9400042924L);
		customerBean4.setLoanAccountNo(120000456321L);
		customerBean4.setEmailId("sachin.12@gmail.com");
		customerBean4.setAccountBalance(77000.23);
		customerBean4.setAmountToPay(5600.28);
		customerBean4.setLoanAmount(95000.32);
		customerBean4.setLoanAccountNo(32007852449L);
		customerBean4.setLoanApprovedDate("09-01-2020");
		customerBean4.setLoanType("Home Conversion");
		CUSTOMER_BEANS.add(customerBean4);

		AdminBean adminBean1 = new AdminBean();
		adminBean1.setEmpId(2020001);
		adminBean1.setUserName("Qwerty");
		adminBean1.setPassword("Qwerty@123");
		adminBean1.setFirstName("Qwerty");
		adminBean1.setLastName("D");
		adminBean1.setEmailId("qwerty2@gmail.com");
		ADMIN_BEANS.add(adminBean1);

		AdminBean adminBean2 = new AdminBean();
		adminBean2.setEmpId(2020002);
		adminBean2.setUserName("Mickey");
		adminBean2.setPassword("Mickey@123");
		adminBean2.setFirstName("Mickey");
		adminBean2.setLastName("m");
		adminBean2.setEmailId("mickey12@gmail.com");
		ADMIN_BEANS.add(adminBean2);

		ApprovalTeamBean approvalteamBean1 = new ApprovalTeamBean();
		approvalteamBean1.setEmpId(2020003);
		approvalteamBean1.setFirstName("Anu");
		approvalteamBean1.setLastName("Gupta");
		approvalteamBean1.setPassword("Anuu@123");
		approvalteamBean1.setUserName("Anu");
		approvalteamBean1.setEmailId("anu12@gmail.com");
		APPROVAL_TEAM_BEANS.add(approvalteamBean1);

		ApprovalTeamBean approvalteamBean2 = new ApprovalTeamBean();
		approvalteamBean2.setEmpId(2020004);
		approvalteamBean2.setFirstName("Manu");
		approvalteamBean2.setUserName("Manu");
		approvalteamBean2.setLastName("Patil");
		approvalteamBean2.setPassword("Manu@123");
		approvalteamBean2.setEmailId("manu12@gmail.com");
		APPROVAL_TEAM_BEANS.add(approvalteamBean2);

		ApplicationBean applicationBean1 = new ApplicationBean();
		applicationBean1.setApplicationId(700);
		applicationBean1.setUserName("RajuGuru");
		applicationBean1.setFirstName("Raju");
		applicationBean1.setLastName("Guru");
		applicationBean1.setPassword("Raju@123");
		applicationBean1.setDateOfBirth("20-02-1988");
		applicationBean1.setEmailId("raju@gmail.com");
		applicationBean1.setMobileNumber(9638527412L);
		applicationBean1.setStatus("Approved");
		applicationBean1.setLoanType("House Extention");
		APPLICATION_BEANS.add(applicationBean1);

		ApplicationBean applicationBean2 = new ApplicationBean();
		applicationBean2.setApplicationId(701);
		applicationBean2.setUserName("ManjuRavi");
		applicationBean2.setFirstName("Manju");
		applicationBean2.setLastName("Ravi");
		applicationBean2.setPassword("Manju@123");
		applicationBean2.setDateOfBirth("18-02-1988");
		applicationBean2.setEmailId("manju@gmail.com");
		applicationBean2.setMobileNumber(9638500002L);
		applicationBean2.setStatus("Rejected");
		applicationBean2.setLoanType("House Construction");
		APPLICATION_BEANS.add(applicationBean2);
		

		ApplicationBean applicationBean3 = new ApplicationBean();
		applicationBean3.setApplicationId(702);
		applicationBean3.setUserName("RaviSharma");
		applicationBean3.setFirstName("Ravi");
		applicationBean3.setLastName("Sharma");
		applicationBean3.setPassword("ravi@123");
		applicationBean3.setDateOfBirth("18-02-1987");
		applicationBean3.setEmailId("ravi.s@gmail.com");
		applicationBean3.setMobileNumber(9638500202L);
		applicationBean3.setStatus("Requested");
		applicationBean3.setLoanType("House Conversion");
		APPLICATION_BEANS.add(applicationBean3);

		ApplicationBean applicationBean4 = new ApplicationBean();
		applicationBean4.setApplicationId(704);
		applicationBean4.setUserName("SuryaRaju");
		applicationBean4.setFirstName("Surya");
		applicationBean4.setLastName("Raju");
		applicationBean4.setPassword("SuryaRaju@123");
		applicationBean4.setDateOfBirth("18-05-1988");
		applicationBean4.setEmailId("raju.s@gmail.com");
		applicationBean4.setMobileNumber(9638500002L);
		applicationBean4.setStatus("Requested");
		applicationBean4.setLoanType("House Improvement");
		APPLICATION_BEANS.add(applicationBean2);

	}

}
