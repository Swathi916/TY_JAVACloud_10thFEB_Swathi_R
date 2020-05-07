package com.tyss.capgemini.lps.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tyss.capgemini.lps.beans.AdminBean;
import com.tyss.capgemini.lps.beans.ApplicationBean;
import com.tyss.capgemini.lps.beans.ApprovalTeamBean;
import com.tyss.capgemini.lps.beans.CustomerBean;
import com.tyss.capgemini.lps.beans.LoanBean;
import com.tyss.capgemini.lps.exception.AdminException;
import com.tyss.capgemini.lps.factory.FactoryDAO;
import com.tyss.capgemini.lps.repository.LoanProcessingSystemDB;
import com.tyss.capgemini.lps.repository.LoanProgRepository;
import com.tyss.capgemini.lps.service.AdminServices;
import com.tyss.capgemini.lps.service.AdminServicesImpl;
import com.tyss.capgemini.lps.service.ApplicationServices;
import com.tyss.capgemini.lps.service.ApplicationServicesImpl;
import com.tyss.capgemini.lps.service.ApprovalService;
import com.tyss.capgemini.lps.service.ApprovalServiceImpl;
import com.tyss.capgemini.lps.service.LoanServices;
import com.tyss.capgemini.lps.service.LoanServicesImpl;
import com.tyss.capgemini.lps.validation.Validations;

public class AdminController {

	static Logger log = LogManager.getLogger(AdminController.class);
	Scanner scanner = new Scanner(System.in);
	List<ApplicationBean> applicationBean2 = LoanProcessingSystemDB.APPLICATION_BEANS;

	public boolean adminLogin() {
		int count = 0;
		String userName;
		String password;
		while (true) {
			while (true) {
				log.info("Enter username : ");
				userName = scanner.nextLine();
				if (Validations.isUsername(userName)) {
					break;
				} else {
					log.info("Enter proper Username ");
				}
			}
			while (true) {
				log.info("Enter password : ");
				password = scanner.nextLine();
				if (Validations.isPassword(password)) {
					break;
				} else {
					log.info("Enter Valid Password !");
				}
			}
			for (AdminBean adminBean : LoanProcessingSystemDB.ADMIN_BEANS) {
				if (userName.equals(adminBean.getUserName()) && (password.equals(adminBean.getPassword()))) {
					count++;
				}
			}
			if (count > 0) {
				System.out.println("You have successfully logged in...");
				adminMenu();
				return true;
			} else {
				log.info("Sorry! cannot access because you are not an Admin");
				return false;
			}
		}
	}



//	public void delete(String bankName) throws AdminException {
//		LoanServices loanServices = new LoanServicesImpl();
//			if (Validations.isAlphabet(bankName)) {
//				if (loanServices.deleteLoanInformation(bankName)) {
//					log.info("Information Deleted Successfully...");
//					adminMenu();
//				} else {
//					throw new AdminException("Deletion failed");
//				}
//			} else {
//				log.info("Enter alphabets only !");
//			}
//		}
	
	
	
	public void adminMenu() {
		ApplicationServices applicationServices = FactoryDAO.getApplicationServices();
		LoanServices loanServices = FactoryDAO.getLoanServices();
		ApprovalService approvalservice = FactoryDAO.getApprovalService();
		int choice = 0;
		while (true) {
			log.info(" Press 1 to LOAN PROGRAMS      : ");
			log.info(" Press 2 to CLIENT MANAGER   : ");
			log.info(" Press 3 to LOG OUT          : ");
			String optn = scanner.nextLine();
			if (Validations.isNumber(optn)) {
				choice = Integer.parseInt(optn);
				break;
			} else {
				log.info("Enter Number Only!!");
			}
		}
		switch (choice) {
		case 1:
			int option = 0;
			log.info("================================================");
			log.info("||               LOAN PROGRAMS                 ||");
			log.info("================================================");
			log.info("------------------------------------------------");
			log.info("||               LOAN DETAILS                 ||");
			log.info("------------------------------------------------");
			while (true) {
				log.info(" Enter 1 to Add Loan Programs       : ");
				log.info(" Enter 2 to Delete Loan Programs    : ");
				log.info(" Enter 3 to View Loan Programs    : ");
				String value = scanner.nextLine();
				if (Validations.isNumber(value)) {
					option = Integer.parseInt(value);
					break;
				} else {
					log.info("Enter Number Only!!");
				}
			}
			switch (option) {
			case 1:
				log.info("------------------------------------------------");
				log.info("|               ADD LOAN PROGRAMS                |");
				log.info("------------------------------------------------");
				LoanBean loanBean2 = new LoanBean();
				while (true) {
					log.info("Enter Bank Name   :");
					String bankName = scanner.nextLine().trim();
					if (Validations.isAlphabet(bankName)) {
						loanBean2.setBankName(bankName);
						break;
					} else {
						log.info("Enter Alphabets Only!!");
					}
				}
				while (true) {
					log.info("Enter Loan Type   :");
					String loanType = scanner.nextLine().trim();
					if (Validations.isAlphabet(loanType)) {
						loanBean2.setLoanType(loanType);
						break;
					} else {
						log.info("Enter Alphabets Only !");
					}
				}
				while (true) {
					log.info("Enter Emi : ");
					String emi = scanner.nextLine();
					if (Validations.isEMI(emi)) {
						loanBean2.setEmi(emi);
						break;
					} else {
						log.info("Enter proper EMI !");
					}
				}
				while (true) {
					log.info("Enter Rate of interest : ");
					String rateOfInterest = scanner.nextLine();
					if (Validations.isRateOfIntrest(rateOfInterest)) {
						loanBean2.setRateOfInterest(rateOfInterest);
						break;
					} else {
						log.info("Enter Proper Rate Of Intrest!");
					}
				}
				while (true) {
					log.info("Enter loan amount : ");
					String loanAmount = scanner.nextLine();
					if (Validations.isAmount(loanAmount)) {
						loanBean2.setLoanAmount(loanAmount);
						break;
					} else {
						log.info("Enter Proper Loan Amount!");
					}
				}

				if (loanServices.addLoanInformation(loanBean2)) {
					LoanProgRepository.ARRAY_LIST.add(loanBean2);
					log.info("Information added Successfully...");
				} else {
					log.info("Duplicate info!!");
				}
				adminMenu();
				break;
			case 2:
				log.info("------------------------------------------------");
				log.info("|              DELETE LOAN PROGRAMS              |");
				log.info("------------------------------------------------");
				while (true) {
					log.info("Enter bank name :  ");
					String bankName = scanner.nextLine().trim();
					if (Validations.isAlphabet(bankName)) {
						if (loanServices.deleteLoanInformation(bankName)) {
							log.info("Information Deleted Successfully...");
							adminMenu();
						} else {
							log.info("Information Deletion Failed!!");
						}
						break;
					} else {
						log.info("Enter alphabets only !");
					}
				}
				adminMenu();
				break;
				
				
				
				
				
//			case 2:
//				log.info("--------------------------------------------");
//				log.info("|            DELETE INFORMATION            |");
//				log.info("--------------------------------------------");
//				while (true) {
//					log.info("Enter bank name :  ");
//					String bankName = scanner.nextLine();
//					try {
//						delete(bankName);						
//					} catch (AdminException e) {
//						log.info(e.getMsg());
//					}
//				break;
//			}
//			break;
//				
				
			case 3:
				log.info("-------------------------------------------------------");
				log.info("||               VIEW  LOAN PROGRAMS                    ||");
				log.info("-------------------------------------------------------");
				LoanServices loanServices1 = FactoryDAO.getLoanServices();
				loanServices1.getLoanPrograms();
				adminMenu();
				break;
				
				
				
//				log.info("------------------------------------------------");
//				log.info("|              UPDATE LOAN PROGRAMS              |");
//				log.info("------------------------------------------------");
//				LoanBean lb = new LoanBean();
//				String bankName = null;
//				lb.setBankName(bankName);
//				log.info("enter bank name");
//				 bankName = scanner.nextLine();
//				
//				while(true) {
//					log.info("Enter loan type");
//					String loanType = scanner.nextLine();
//					if(Validations.isAlphabet(loanType)) {
//						lb.setLoanType(loanType);
//					break;
//					}else {
//						log.info("Enter alphabets only");
//					}
//				}
//				while(true) {
//					log.info("Enter EMI");
//					String emi = scanner.nextLine();
//					if(Validations.isEMI(emi)) {
//						lb.setEmi(emi);
//					break;
//					}else {
//						log.info("Enter proper emi");
//					}
//				}
//				
//				while(true) {
//					log.info("Enter rate of intrest");
//					String rateOfInterest = scanner.nextLine();
//					if (Validations.isRateOfIntrest(rateOfInterest)) {
//						lb.setRateOfInterest(rateOfInterest);
//						break;
//					} else {
//						log.info("Enter Proper Rate Of Intrest!");
//					}
//				}
//				while(true) {
//					log.info("Enter Loan Amount");
//					String loanAmount = scanner.nextLine();
//					if (Validations.isEMI(loanAmount)) {
//						lb.setLoanAmount(loanAmount);
//						break;
//					} else {
//						log.info("Enter Proper Loan Amount!");
//					}
//				}
//				
//				if(loanServices.updateLoanInformation(lb)) {
////					LoanProgRepository.ARRAY_LIST.replaceAll(lb);
//					log.info("Loan information updated successfully");
//				}else {
//					log.info("updation is unsuccessfull!!");
//				}
//			adminMenu();
//				break;

			default:
				log.info("Please Enter Valid Choice!!");
				adminMenu();
				break;
			}
			break;
	
			
			
			
		case 2:
			log.info("------------------------------------------------");
			log.info("||               CLIENT MANAGER               ||");
			log.info("------------------------------------------------");
			int input = 0;
			while (true) {
				log.info("Enter 1 to ADD CLIENT    : ");
				log.info("Enter 2 to VIEW All Applications   : ");
				log.info("Enter 3 to VIEW CLIENTS   : ");
				String key = scanner.nextLine();
				if (Validations.isNumber(key)) {
					input = Integer.parseInt(key);
					break;
				} else {
					log.info("Enter Number Only!!!");
				}
			}

			switch (input) {
			case 1:
				log.info("---------------------------------------------");
				log.info("|             ADD CLIENT             |");
				log.info("---------------------------------------------");
//				CustomerBean customerBean = new CustomerBean();
//				Integer appId = 0;
//				while (true) {
//					log.info("Enter Application Id    : ");
//					String applicationId = scanner.nextLine();
//					if (Validations.isNumber(applicationId)) {
//						appId = Integer.parseInt(applicationId);
//						if (Validations.validAppicationId(appId)) {
//							log.info("Appication exists for this Id!!");
//							for (ApplicationBean appBean : applicationBean2) {
//								if (appId.equals(appBean.getApplicationId())) {
//									if (applicationServices.addApplication(customerBean)) {
//										log.info("Clients added successfully...");
//									} else {
//										log.info("Clients addition failed!!");
//									}
//								}
//							}
//						} else {
//							log.info("Application does not exists for this Id!!");
//						}
//						break;
//					} else {
//						log.info("Enter Number Only!!");
//					}
//				}
				
				ApprovalTeamBean approvalBean2 = new ApprovalTeamBean();
				while (true) {
					log.info("Enter Full Name   :");
					String fullName = scanner.nextLine().trim();
					if (Validations.isAlphabet(fullName)) {
						approvalBean2.setFullName(fullName);
						break;
					} else {
						log.info("Enter Alphabets Only!!");
					}
				}
				while (true) {
					log.info("Enter Password   :");
					String password = scanner.nextLine();
					if (Validations.isPassword(password)) {
						approvalBean2.setPassword(password);
						break;
					} else {
						log.info("Password should contain atleast one lowecase, uppercase letter, number, special character and minimum 8 characters !");
					}
				}
				while (true) {
					log.info("Enter Email Id : ");
					String email = scanner.nextLine();
					if (Validations.isEmail(email)) {
						approvalBean2.setEmailId(email);
						break;
					} else {
						log.info("Enter proper EMAIL !");
					}
				}
				
				while (true) {
					log.info("Enter Employee Id :-");
					int empId =0;
					String id = scanner.nextLine();
					if (Validations.isNumber(id)) {
						empId=Integer.parseInt(id);
						break;
					}
					else {
						log.info("Enter Number Only!!!");
					}

				}
				
				while (true) {
					log.info("Enter UserName : ");
					String userName = scanner.nextLine();
					if (Validations.isUsername(userName)) {
						approvalBean2.setUserName(userName);
						break;
					} else {
						log.info("UserName should contain minimum 8 characters ! ");
					}
				}

				if (approvalservice.addClient(approvalBean2)) {
					LoanProcessingSystemDB.APPROVAL_TEAM_BEANS.add(approvalBean2);
					log.info("Client added Successfully...");
				} else {
					log.info("Addition failed !!");
				} 
				adminMenu();
				break;
			case 2:
				log.info("---------------------------------------------");
				log.info("|             VIEW Applications             |");
				log.info("---------------------------------------------");
				List<ApplicationBean> appBean = applicationServices.viewApplication();
				for (ApplicationBean applicationBean2 : appBean) {
					log.info("*****************************************");
					log.info("Application Id    :- " + applicationBean2.getApplicationId());
					log.info("User Name         :- " + applicationBean2.getUserName());
					log.info("First Name        :- " + applicationBean2.getFirstName());
					log.info("Last Name         :- " + applicationBean2.getLastName());
					log.info("Mobile Number     :- " + applicationBean2.getMobileNumber());
					log.info("Date Of Birth     :- " + applicationBean2.getDateOfBirth());
					log.info("Email Id          :- " + applicationBean2.getEmailId());
					log.info("Status            :- " + applicationBean2.getStatus());
					log.info("*****************************************");
				}
				adminMenu();
				break;
			case 3:
				log.info("---------------------------------------------");
				log.info("|             VIEW CLIENTS            |");
				log.info("---------------------------------------------");
				List<ApprovalTeamBean> approvalBean = approvalservice.viewApplication();
				for (ApprovalTeamBean approvalBean3 : approvalBean) {
					log.info("*****************************************");
					log.info("Employee Id    :- " + approvalBean3.getEmpId());
					log.info("User Name         :- " + approvalBean3.getUserName());
					log.info("Full Name        :- " + approvalBean3.getFullName());
//					log.info("Last Name         :- " + approvalBean3.getLastName());
//					log.info("Mobile Number     :- " + applicationBean2.getMobileNumber());
//					log.info("Date Of Birth     :- " + applicationBean2.getDateOfBirth());
					log.info("Email Id          :- " + approvalBean3.getEmailId());
//					log.info("Status            :- " + applicationBean2.getStatus());
					log.info("*****************************************");
				}
				adminMenu();
				break;
				
			
				
			default:
				log.info("Please Enter Valid Choice!!");
				adminMenu();
				break;
			}
			break;
		case 3:
			log.info("LOGGED OUT...");
			HomePage.getStarted();
			break;
		default:
			log.info("Please Enter Valid Choice!!");
			adminMenu();
			break;
		}
		scanner.close();
	}
}
