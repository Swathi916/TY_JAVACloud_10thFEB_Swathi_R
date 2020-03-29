package com.capgemini.loanProcessingSystem.dao;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.loanProcessingSystem.beans.CustomerBean;
import com.capgemini.loanProcessingSystem.repository.LoanProcessingSystemDB;

public class CustomerDAOImpl implements CustomerDAO {
	static Logger log = LogManager.getLogger(CustomerDAOImpl.class);
	private ArrayList<CustomerBean> customerBeans = LoanProcessingSystemDB.CUSTOMER_BEANS;
	@Override
	public boolean payLoan(String userName, String password) {
		for (int i = 0; i < LoanProcessingSystemDB.CUSTOMER_BEANS.size(); i++) {
			if (userName.equals(LoanProcessingSystemDB.CUSTOMER_BEANS.get(i).getUserName())
					&& password.equals(LoanProcessingSystemDB.CUSTOMER_BEANS.get(i).getPassword())) {
				log.info("\n Amount to Pay : " + LoanProcessingSystemDB.CUSTOMER_BEANS.get(i).getAmountToPay());
			}
		}
		return false;
	}

	@Override
	public boolean checkBalance(String userName, String password) {
		for (int i = 0; i < LoanProcessingSystemDB.CUSTOMER_BEANS.size(); i++) {
			if (userName.equals(LoanProcessingSystemDB.CUSTOMER_BEANS.get(i).getUserName())
					&& password.equals(LoanProcessingSystemDB.CUSTOMER_BEANS.get(i).getPassword())) {
				log.info("\n Account Balance : " + LoanProcessingSystemDB.CUSTOMER_BEANS.get(i).getAccountBalance());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean changePassword(CustomerBean bean) {
		for (CustomerBean customerInfoBean  : LoanProcessingSystemDB.CUSTOMER_BEANS) {
			customerInfoBean.setPassword(bean.getPassword());
			return true;
		}
		return false;
	}

	@Override
	public boolean addCustomer(CustomerBean customerBean) {
		for (CustomerBean customerBeanInfo : customerBeans) {
			if ((customerBean.getCustomerId() == customerBeanInfo.getCustomerId())) {
				return false;
			}
		}
		LoanProcessingSystemDB.CUSTOMER_BEANS.add(customerBean);
		return true;
	}

}
