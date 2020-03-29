package com.capgemini.loanProcessingSystem.services;

import java.util.List;

import com.capgemini.loanProcessingSystem.beans.ApplicationBean;
import com.capgemini.loanProcessingSystem.beans.CustomerBean;
import com.capgemini.loanProcessingSystem.dao.ApplicationDAO;
import com.capgemini.loanProcessingSystem.factory.FactoryDAO;

public class ApplicationServicesImpl implements ApplicationServices {
private ApplicationDAO dao = FactoryDAO.getApplicationDAO();
	
	@Override
	public boolean addApplication(CustomerBean customerBean) {
		return dao.addApplication(customerBean);
	}

	@Override
	public List<ApplicationBean> viewApplication() {
		return dao.viewApplication();
	}

	@Override
	public boolean updateApplicationStatus(int appId, String status) {
		return dao.updateApplicationStatus(appId, status);
	}

	@Override
	public ApplicationBean getAllApplication(String loanType) {
		return dao.getAllApplication(loanType);
	}

}
