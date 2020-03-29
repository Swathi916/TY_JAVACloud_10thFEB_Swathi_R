package com.capgemini.loanProcessingSystem.services;

import java.util.List;

import com.capgemini.loanProcessingSystem.beans.ApplicationBean;
import com.capgemini.loanProcessingSystem.beans.CustomerBean;

public interface ApplicationServices {
	public boolean addApplication(CustomerBean customerBean);
	public List<ApplicationBean> viewApplication();
	public boolean updateApplicationStatus(int appId, String status);
	public ApplicationBean getAllApplication(String loanType);

}
