package com.tyss.capgemini.lps.service;

import java.util.List;

import com.tyss.capgemini.lps.DAO.AdminDAO;
import com.tyss.capgemini.lps.beans.ApplicationBean;
import com.tyss.capgemini.lps.beans.CustomerBean;
import com.tyss.capgemini.lps.factory.FactoryDAO;

public class AdminServicesImpl implements AdminServices {
	private AdminDAO ads = FactoryDAO.getAdminDAO();

	@Override
	public boolean addClient(CustomerBean bean) {
		return ads.addClient(bean);
	}

	@Override
	public List<ApplicationBean> viewClient() {
		return ads.viewClient();
	}

	@Override
	public boolean addLoanInformation() {
		return true; // Changes
	}

	@Override
	public boolean deleteLoanInformation(String bankName) {
		return ads.deleteLoanInformation(bankName);
	}

}
