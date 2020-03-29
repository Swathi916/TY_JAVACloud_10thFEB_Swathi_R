package com.capgemini.loanProcessingSystem.factory;

import com.capgemini.loanProcessingSystem.dao.ApplicationDAO;
import com.capgemini.loanProcessingSystem.dao.ApplicationDAOImpl;
import com.capgemini.loanProcessingSystem.dao.CustomerDAO;
import com.capgemini.loanProcessingSystem.dao.CustomerDAOImpl;
import com.capgemini.loanProcessingSystem.dao.LoanDAO;
import com.capgemini.loanProcessingSystem.dao.LoanDAOImpl;

public class FactoryDAO {
	public static CustomerDAO getCustomerDAO(){
		return new CustomerDAOImpl();
	}

	public static ApplicationDAO getApplicationDAO() {
		return new ApplicationDAOImpl();
	}
	
	public static LoanDAO getLoanDAO() {
		return new LoanDAOImpl();
	}

}
