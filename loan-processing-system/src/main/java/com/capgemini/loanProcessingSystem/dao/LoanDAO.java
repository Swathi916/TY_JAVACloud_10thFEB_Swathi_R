package com.capgemini.loanProcessingSystem.dao;

import com.capgemini.loanProcessingSystem.beans.LoanBean;
import com.capgemini.loanProcessingSystem.repository.LoanProgRepository;

public interface LoanDAO {
	public boolean addLoanInformation(LoanBean loanBean);

	public boolean deleteLoanInformation(String bankName);

	public LoanProgRepository getloanPrograms();
	
	public boolean makeLoan();

}
