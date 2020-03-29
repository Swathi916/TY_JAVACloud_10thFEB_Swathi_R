package com.capgemini.loanProcessingSystem.services;

import com.capgemini.loanProcessingSystem.beans.CustomerBean;

public interface CustomerServices {
	public boolean payLoan(String userName, String password);
	public boolean checkBalance(String userName, String password);
	public boolean changePassword(CustomerBean bean);
	public boolean addCustomer(CustomerBean customerBean);

}
