package com.capgemini.loanProcessingSystem.dao;

import com.capgemini.loanProcessingSystem.beans.CustomerBean;

public interface CustomerDAO {
	public boolean payLoan(String userName, String password);
	public boolean checkBalance(String userName, String password);
	public boolean changePassword(CustomerBean bean);
	public boolean addCustomer(CustomerBean customerBean);

}
