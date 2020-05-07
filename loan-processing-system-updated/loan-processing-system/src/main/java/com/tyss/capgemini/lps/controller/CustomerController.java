package com.tyss.capgemini.lps.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tyss.capgemini.lps.beans.ApplicationBean;
import com.tyss.capgemini.lps.beans.CustomerBean;
import com.tyss.capgemini.lps.factory.FactoryDAO;
import com.tyss.capgemini.lps.repository.LoanProcessingSystemDB;
import com.tyss.capgemini.lps.service.ApplicationServices;
import com.tyss.capgemini.lps.service.CustomerServices;
import com.tyss.capgemini.lps.service.CustomerServicesImpl;
import com.tyss.capgemini.lps.service.LoanServices;
import com.tyss.capgemini.lps.service.LoanServicesImpl;
import com.tyss.capgemini.lps.validation.Validations;

public class CustomerController {
	static Logger log = LogManager.getLogger(CustomerController.class);
	Scanner scanner = new Scanner(System.in);

	public boolean logIn() {
		int counter = 0;
		String userName;
		String password;
		while (true) {
			while (true) {
				log.info("\nEnter Username : ");
				userName = scanner.nextLine();
				if (Validations.isUsername(userName)) {
					break;
				} else {
					log.info("Enter Valid Username!!");
				}
			}
			while (true) {
				log.info("Enter password   : ");
				password = scanner.nextLine();
				if (Validations.isPassword(password)) {
					break;
				} else {
					log.info("Enter Valid Password!!");
				}
			}
			for (int i = 0; i < LoanProcessingSystemDB.CUSTOMER_BEANS.size(); i++) {
				if (userName.equals(LoanProcessingSystemDB.CUSTOMER_BEANS.get(i).getUserName())
						&& password.equals(LoanProcessingSystemDB.CUSTOMER_BEANS.get(i).getPassword())) {
					counter++;
				}
			}
			if (counter > 0) {
				System.out.println("You have successfully logged in...");
				menuOption(userName, password);
				return true;
			} else {
				log.info("Opps! invalid choice");
				return false;
			}
		}
	}

	public void makeLoan() {
		CustomerServices service = FactoryDAO.getCustomerServices();
		LoanServices loanService = FactoryDAO.getLoanServices();
		ApplicationServices applicationService = FactoryDAO.getApplicationServices();
		ApplicationBean applicationBean = new ApplicationBean();

		while(true) {
			log.info("Enter Application Id :- ");
			String applicationId = scanner.nextLine();
			if (Validations.isNumber(applicationId)) {
				applicationBean.setApplicationId(Integer.parseInt(applicationId));
				break;
			} else {
				log.info("Enter correct application id!");
			}
		}
		while(true) {
			log.info("Enter Username :- ");
			String userName = scanner.nextLine();
			if (Validations.isUsername(userName)) {
				applicationBean.setUserName(userName);
				break;
			} else {
				log.info("Enter proper Username!!");
			}
			log.info("Enter number and alphabets Only!");
		}

		while(true) {
			log.info("Enter Password :- ");
			String password = scanner.nextLine();
			if (Validations.isPassword(password)) {
				applicationBean.setPassword(password);
				break;
			} else {
				log.info("Enter proper Password!");
			}
			log.info("Enter the combination of number, alphabets and special characters !");
		}

		while(true) {
			log.info("Enter First Name :- ");
			String firstName = scanner.nextLine();
			if (Validations.isAlphabet(firstName)) {
				applicationBean.setFirstName(firstName);
				break;
			} else {
				log.info("Enter alphabets only!");
			}
		}

		while(true) {
			log.info("Enter Last Name :- ");
			String lastName = scanner.nextLine();
			if (Validations.isAlphabet(lastName)) {
				applicationBean.setLastName(lastName);
				break;
			} else {
				log.info("Enter alphabets only!");
			}
		}

		while (true) {
			log.info("Enter Customer EmailId :- ");
			String email = scanner.nextLine();
			if (Validations.isEmail(email)) {
				applicationBean.setEmailId(email);
				break;
			} else {
				log.info("Email already exist!");
			}
		}

		while(true) {
			log.info("Enter Mobile Number :- ");
			String mobileNumber = scanner.nextLine();
			if (Validations.isMobile(mobileNumber)) {
				applicationBean.setMobileNumber(Long.parseLong(mobileNumber));
				break;
			} else {
				log.info("Enter correct mobile number!");
			}
		}
		while(true) {
			log.info("Enter Date of Birth :- ");
			String dob = scanner.nextLine();
			if (Validations.validateDate(dob)) {
				applicationBean.setDateOfBirth(dob);
				break;
			} else {
				log.info("Enter correct date of birth!");
			}
		}
		while(true) {
			log.info("Enter Account Number :- ");
			String accNumber = scanner.nextLine();
			if (Validations.isNumber(accNumber)) {
				applicationBean.setMobileNumber(Long.parseLong(accNumber));
				break;
			} else {
				log.info("Enter correct Account Number!");
			}
		}
		while (true) {
			log.info("Enter loan type  :- ");
			log.info("Available loans  :- ");
			log.info("1 - House Extention");
			log.info("2 - House Construction");
			log.info("3 - House Conversion");
			log.info("4 - House Improvement");
			log.info("Enter your choice :- ");
			int choice = scanner.nextInt();		
//			switch (choice) {
//			case 1:
//				loanType = "House Extention";
//				break;
//			case 2:
//				loanType = "House Construction";
//				break;
//			case 3:
//				loanType = "House Conversion";
//				break;
//			case 4:
//				loanType = "House Improvement";
//				break;
//			default:
//				log.info("Invalid option!");
//				break;
//			}
//			applicationBean.setLoanType(loanType);
			if (choice == 1) {
				applicationBean.setLoanType("House Extention");
				break;
			} else if(choice == 2) {
				applicationBean.setLoanType("House Construction");
				break;
			} else if(choice == 3) {
				applicationBean.setLoanType("House Conversion");
				break;
			}else if(choice == 4) {
				applicationBean.setLoanType("House Improvement");
				break;
			}
			break;
		}
		while (true) {
			String status = "Requested";
			if (Validations.isAlphabet(status)) {
				applicationBean.setStatus(status);
				break;
			}
		}
		if (applicationService.makeLoan(applicationBean)) {
			LoanProcessingSystemDB.APPLICATION_BEANS.add(applicationBean);
			log.info("Customer added successfully..");
		} else {
			log.info("Duplicate Id's");
		}
	}// end of makeLoan()

	public void menuOption(String userName, String password) {
		CustomerServices customerService = FactoryDAO.getCustomerServices();
		int choice1 = 0;
		while (true) {
			log.info("Press 1 to MAKE LOAN           :");
			log.info("Press 2 to VIEW LOAN PROGRAMS  :");
			log.info("Press 3 to LOAN DETAILS        :");
			log.info("Press 4 to log-out             :");
			log.info("Enter your choice              :");
			String option = scanner.nextLine();		
			if (Validations.isOneDigit(option)) {
				choice1 = Integer.parseInt(option);
				break;
			}
			else {
				log.info("Please enter only one digit!!");
			}
		}
		switch (choice1) {
		case 1:
			log.info("------------------------------------------------");
			log.info("||            Make Loan Section               ||");
			log.info("------------------------------------------------");
			makeLoan();
			menuOption(userName, password);
			break;
		case 2:
			log.info("------------------------------------------------");
			log.info("||            View Loan Programs              ||");
			log.info("------------------------------------------------");
//			customerService.loanDetails();
			LoanServices loanServices1 = FactoryDAO.getLoanServices();
			loanServices1.getLoanPrograms();
			menuOption(userName, password);
			break;

		case 3:
			log.info("------------------------------------------------");
			log.info("||              Loan Details                  ||");
			log.info("------------------------------------------------");
			customerService.viewCustomer(userName, password);
			menuOption(userName, password);
			break;	

		case 4:
			log.info("You logged out successfully!");
			HomePage.getStarted();
			break;

		default:
			log.info("Invalid Choice");
			break;
		}
	}
} // CustomerController}
