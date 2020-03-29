package com.capgemini.loanProcessingSystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.loanProcessingSystem.beans.AdminBean;
import com.capgemini.loanProcessingSystem.beans.ApplicationBean;
import com.capgemini.loanProcessingSystem.beans.CustomerBean;
import com.capgemini.loanProcessingSystem.beans.LoanBean;
import com.capgemini.loanProcessingSystem.repository.LoanProcessingSystemDB;
import com.capgemini.loanProcessingSystem.services.ApplicationServices;
import com.capgemini.loanProcessingSystem.services.ApplicationServicesImpl;
import com.capgemini.loanProcessingSystem.services.LoanServices;
import com.capgemini.loanProcessingSystem.services.LoanServicesImpl;
import com.capgemini.loanProcessingSystem.validations.Validations;

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
				if (Validations.isAlphabet(userName)) {
					break;
				} else {
					log.info("Enter alphabets only ! ");
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

	public void adminMenu() {
		ApplicationServices applicationServices = new ApplicationServicesImpl();
		LoanServices loanServices = new LoanServicesImpl();
		int choice = 0;
		while (true) {
			log.info(" Press 1 to DASH BOARD       : ");
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
			log.info("||                DASH BOARD                  ||");
			log.info("================================================");
			log.info("------------------------------------------------");
			log.info("||               LOAN DETAILS                 ||");
			log.info("------------------------------------------------");
			while (true) {
				log.info(" Enter 1 to Add Information       : ");
				log.info(" Enter 2 to Delete Information    : ");
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
				log.info("|               ADD INFORMATION                |");
				log.info("------------------------------------------------");
				LoanBean loanBean2 = new LoanBean();
				while (true) {
					log.info("Enter Bank Name   :");
					String bankName = scanner.nextLine();
					if (Validations.isAlphabet(bankName)) {
						loanBean2.setBankName(bankName);
						break;
					} else {
						log.info("Enter Alphabets Only!!");
					}
				}
				while (true) {
					log.info("Enter Loan Type   :");
					String loanType = scanner.nextLine();
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
					if (Validations.isEMI(loanAmount)) {
						loanBean2.setLoanAmount(loanAmount);
						break;
					} else {
						log.info("Enter Proper Loan Amount!");
					}
				}

				if (loanServices.addLoanInformation(loanBean2)) {
					log.info("Information added Successfully...");
				} else {
					log.info("Duplicate info!!");
				}
				adminMenu();
				break;
			case 2:
				log.info("------------------------------------------------");
				log.info("|              DELETE INFORMATION              |");
				log.info("------------------------------------------------");
				while (true) {
					log.info("Enter bank name :  ");
					String bankName = scanner.nextLine();
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
				break;

			default:
				log.info("Invalid choice!");
				break;
			}
			break;
		case 2:
			log.info("------------------------------------------------");
			log.info("||               CLIENT MANAGER               ||");
			log.info("------------------------------------------------");
			int input = 0;
			while (true) {
				log.info("Enter 1 to ADD Application    : ");
				log.info("Enter 2 to VIEW Application   : ");
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
				log.info("|             ADD Application               |");
				log.info("---------------------------------------------");
				CustomerBean customerBean = new CustomerBean();
				Integer appId = 0;
				while (true) {
					log.info("Enter Application Id    : ");
					String applicationId = scanner.nextLine();
					if (Validations.isNumber(applicationId)) {
						appId = Integer.parseInt(applicationId);
						if (Validations.validAppicationId(appId)) {
							log.info("Appication exists for this Id!!");
							for (ApplicationBean appBean : applicationBean2) {
								if (appId.equals(appBean.getApplicationId())) {
									if (applicationServices.addApplication(customerBean)) {
										log.info("Clients added successfully...");
									} else {
										log.info("Clients addition failed!!");
									}
								}
							}
						} else {
							log.info("Application does not exists for this Id!!");
						}
						break;
					} else {
						log.info("Enter Number Only!!");
					}
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
			default:
				log.info("Invalid option!!");
			}
			break;
		case 3:
			log.info("LOGGED OUT...");
			HomePage.getStarted();
			break;
		default:
			log.info("Invalid Choice!!");
			break;
		}
		scanner.close();
	}

}
