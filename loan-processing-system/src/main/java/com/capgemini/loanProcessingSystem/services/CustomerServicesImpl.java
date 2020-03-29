package com.capgemini.loanProcessingSystem.services;

import com.capgemini.loanProcessingSystem.beans.CustomerBean;
import com.capgemini.loanProcessingSystem.dao.CustomerDAO;
import com.capgemini.loanProcessingSystem.factory.FactoryDAO;

public class CustomerServicesImpl implements CustomerServices {
	private CustomerDAO dao = FactoryDAO.getCustomerDAO();

	@Override
	public boolean changePassword(CustomerBean bean) {
		return dao.changePassword(bean);
	}

	@Override
	public boolean payLoan(String userName, String password) {
		return dao.payLoan(userName, password);
	}

	@Override
	public boolean checkBalance(String userName, String password) {
		return dao.checkBalance(userName, password);
	}

	@Override
	public boolean addCustomer(CustomerBean customerBean) {
		return dao.addCustomer(customerBean);
	}

}
