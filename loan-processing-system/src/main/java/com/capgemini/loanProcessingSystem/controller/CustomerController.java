package com.capgemini.loanProcessingSystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.loanProcessingSystem.beans.CustomerBean;
import com.capgemini.loanProcessingSystem.factory.FactoryDAO;
import com.capgemini.loanProcessingSystem.repository.LoanProcessingSystemDB;
import com.capgemini.loanProcessingSystem.services.CustomerServices;
import com.capgemini.loanProcessingSystem.services.CustomerServicesImpl;
import com.capgemini.loanProcessingSystem.services.LoanServices;
import com.capgemini.loanProcessingSystem.services.LoanServicesImpl;
import com.capgemini.loanProcessingSystem.validations.Validations;

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
	
	public void register() {
		CustomerServices service = new CustomerServicesImpl();
		CustomerBean customerBean = new CustomerBean();
		while (true) {
			log.info("Enter Customer Id :- ");
			String customerId = scanner.nextLine();
			if (Validations.isNumber(customerId)) {
				customerBean.setCustomerId(Integer.parseInt(customerId));
				break;
			} else {
			}
			log.info("Enter Number Only!!!");
		}
		
		while(true) {
			log.info("Enter Username :");
			String userName = scanner.nextLine();
			if (Validations.isUsername(userName)) {
				customerBean.setUserName(userName);
				break;
			} else {
				log.info("Enter proper Username!!");
			}
			log.info("Enter number and digits Only!");
		}
		
		while(true) {
			log.info("Enter Password :");
			String password = scanner.nextLine();
			if (Validations.isPassword(password)) {
				customerBean.setUserName(password);
				break;
			} else {
				log.info("Enter proper Password!!");
			}
			log.info("Enter the combination of number, digits and special!");
		}
		
		while(true) {
			log.info("Enter First Name :");
			String firstName = scanner.nextLine();
			if (Validations.isAlphabet(firstName)) {
				customerBean.setUserName(firstName);
				break;
			} else {
				log.info("Enter String value only!!");
			}
		}
		
		while(true) {
			log.info("Enter Last Name :");
			String lastName = scanner.nextLine();
			if (Validations.isAlphabet(lastName)) {
				customerBean.setUserName(lastName);
				break;
			} else {
				log.info("Enter String value only!!");
			}
		}
		
		while (true) {
			log.info("Enter Customer EmailId");
			String email = scanner.nextLine();
			if (Validations.isEmail(email)) {
				customerBean.setEmailId(email);
				break;
			} else {
				log.info("Email already exist");
			}
		}
		
		while(true) {
			log.info("Enter Mobile Number:");
			String mobileNumber = scanner.nextLine();
			if (Validations.isNumber(mobileNumber)) {
				customerBean.setMobileNumber(Long.parseLong(mobileNumber));
				break;
			} else {
				log.info("Enter correct mobile number");
			}
		}
		if (service.addCustomer(customerBean)) {
			log.info("Customer added successfully..");
		} else {
			log.info("Duplicate Id's");
		}
	}

	public void menuOption(String userName, String password) {
		CustomerServices customerService = new CustomerServicesImpl();
		LoanServices loan = new LoanServicesImpl();
		int choice = 0;
		while (true) {
			log.info("Press 1 to MAKE LOAN          :");
			log.info("Press 2 to PAY LOAN           :");
			log.info("Press 3 to CHECK BALANCE      :");
			log.info("Press 4 to INBOX              :");
			log.info("Press 5 to CHANGE OF PASSWORD :");
			log.info("Press 6 to log-out            :");
			log.info("Enter your choice             :");
			String option = scanner.nextLine();		
			if (Validations.isNumber(option)) {
				choice = Integer.parseInt(option);
				break;
			}
		}
		switch (choice) {
		case 1:
			log.info("------------------------------------------------");
			log.info("||            Make Loan Section               ||");
			log.info("------------------------------------------------");
			loan.makeLoan();
			menuOption(userName, password);
			break;
		case 2:
			log.info("------------------------------------------------");
			log.info("||      Welcome to Loan Payment Section       ||");
			log.info("------------------------------------------------");
			customerService.payLoan(userName, password);
			menuOption(userName, password);
			break;
		case 3:
			log.info("------------------------------------------------");
			log.info("||           Check Balance Section            ||");
			log.info("------------------------------------------------");
			customerService.checkBalance(userName, password);
			menuOption(userName, password);
			break;
		case 4:
			log.info("------------------------------------------------");
			log.info("||              Welcome to INBOX              ||");
			log.info("------------------------------------------------");
			menuOption(userName, password);
			break;
		case 5:
			log.info("------------------------------------------------");
			log.info("||           Change Password option           ||");
			log.info("------------------------------------------------");
			CustomerBean bean = new CustomerBean();
			while (true) {
				log.info("Enter Password :");
				String newPassword = scanner.nextLine();
				if (Validations.isPassword(newPassword)) {
					bean.setPassword(newPassword);
					break;
				} else {
					log.info("Enter Proper Password!!!");
				}
			}
			if (FactoryDAO.getCustomerDAO().changePassword(bean)) {
				log.info("Password update Successfully...");
			} else {
				log.info("Something went wrong!!");
			}
			menuOption(userName, password);
			break;
		case 6:
			log.info("You logged out successfully!");
			HomePage.getStarted();
			break;
		default:
			log.info("Invalid Choice");
			break;
		}
	}

}
