package com.tyss.capgemini.lps.DAO;

import java.util.List;

import com.tyss.capgemini.lps.beans.ApplicationBean;
import com.tyss.capgemini.lps.beans.CustomerBean;
import com.tyss.capgemini.lps.beans.LoanBean;

public interface AdminDAO {
	public boolean addClient(CustomerBean bean);

	public boolean addLoanInformation(LoanBean loanBean);

	public boolean deleteLoanInformation(String bankName);

	List<ApplicationBean> viewClient();

}
