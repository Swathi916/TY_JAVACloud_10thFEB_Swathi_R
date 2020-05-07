package com.tyss.capgemini.lps.service;

import java.util.List;

import com.tyss.capgemini.lps.beans.ApplicationBean;
import com.tyss.capgemini.lps.beans.CustomerBean;

public interface AdminServices {
	public boolean addClient(CustomerBean bean);

	public boolean addLoanInformation();

	public boolean deleteLoanInformation(String bankName);

	List<ApplicationBean> viewClient();
}
