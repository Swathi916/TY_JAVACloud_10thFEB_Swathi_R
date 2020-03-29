package com.capgemini.loanProcessingSystem.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.loanProcessingSystem.beans.ApprovalTeamBean;
import com.capgemini.loanProcessingSystem.repository.LoanProcessingSystemDB;
import com.capgemini.loanProcessingSystem.services.ApplicationServices;
import com.capgemini.loanProcessingSystem.services.ApplicationServicesImpl;
import com.capgemini.loanProcessingSystem.services.LoanServices;
import com.capgemini.loanProcessingSystem.services.LoanServicesImpl;
import com.capgemini.loanProcessingSystem.validations.Validations;

public class ApprovalController {
	static Logger log = Logger.getLogger(ApprovalTeamBean.class);

	Scanner scanner = new Scanner(System.in);

	public boolean approvalLogin() {

		int count = 0;
		String userName;
		String password;
		while (true) {
			while (true) {
				log.info("Enter username :");
				userName = scanner.nextLine();
				if (Validations.isAlphabet(userName)) {
					break;
				} else {
					log.info("Enter alphabets only!!");
				}
			}
			while (true) {
				log.info("Enter password :");
				password = scanner.nextLine();
				if (Validations.isPassword(password)) {
					break;
				} else {
					log.info("Enter Valid Password!!");
				}
			}
			for (ApprovalTeamBean approvalTeamBean : LoanProcessingSystemDB.APPROVAL_TEAM_BEANS) {
				if (userName.equals(approvalTeamBean.getUserName())
						&& (password.equals(approvalTeamBean.getPassword())))
					count++;
			}

			if (count > 0) {
				System.out.println("You have successfully logged in....");
				approvalMenu();
				return true;
			} else {
				log.info("Sorry! cannot access because you are not from approval department");
				return false;
			}
		}
	}

	public void approvalMenu() {

		ApplicationServices applicationServices = new ApplicationServicesImpl();
		int option = 0;
		while (true) {
			log.info("Press 1 for LOAN PROGRAMS          : ");
			log.info("Press 2 to VIEW LOAN APPLICATIONS  : ");
			log.info("Press 3 to UPDATE STATUS           : ");
			log.info("Press 4 to LOG OUT                 : ");
			String optn = scanner.nextLine();
			if (Validations.isNumber(optn)) {
				option = Integer.parseInt(optn);
				break;
			} else {
				log.info("Enter Number Only!!!");
			}
		}

		switch (option) {

		case 1:
			log.info("-------------------------------------------------------");
			log.info("||                  LOAN PROGRAMS                    ||");
			log.info("-------------------------------------------------------");
			LoanServices loanServices = new LoanServicesImpl();
			loanServices.getLoanPrograms();
			approvalMenu();
			break;

		case 2:
			log.info("-------------------------------------------------------");
			log.info("||              VIEW LOAN APPLICATIONS               ||");
			log.info("-------------------------------------------------------");
			while (true) {
				log.info("Enter loan type : ");
				String loanType = scanner.nextLine();
				if (Validations.isAlphabet(loanType)) {
					applicationServices.getAllApplication(loanType);
					break;
				} else {
					log.info("Enter alphabets only!!");
				}
			}
			approvalMenu();
			break;

		case 3:
			log.info("-------------------------------------------------------");
			log.info("||      UPDATE STATUS OF REQUESTED APPLICATIONS      ||");
			log.info("-------------------------------------------------------");
			int appId=0;
			String status=null;
			while (true) {
				log.info("Enter Application Id :-");
				String id = scanner.nextLine();
				if (Validations.isNumber(id)) {
					appId=Integer.parseInt(id);
					break;
				}
				else {
					log.info("Enter Number Only!!!");
				}

			}
			log.info("Enter 1 to Accept");
			log.info("Enter 2 to Reject");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:
				status="Accept";
			case 2:
				status="Reject";
			}
			if(choice==1)
			{
				log.info("Status changed to Accepted");
			}
			else
			{
				log.info("Staus changed to Rejected");
			}

			if (applicationServices.updateApplicationStatus(appId,status)) {
				log.info("Application status Updated Successfully...");
				break;
			} else {
				log.info("status Updation Failed!!!");
			}
			break;
		case 4:
			log.info("LOGGED OUT...");
			HomePage.getStarted();
			break;
		default:
			log.info("Invalid Choice!!");
			break;
		}
	}

}
