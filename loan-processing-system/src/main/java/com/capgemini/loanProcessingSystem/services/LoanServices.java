package com.capgemini.loanProcessingSystem.services;

import com.capgemini.loanProcessingSystem.beans.LoanBean;
import com.capgemini.loanProcessingSystem.repository.LoanProgRepository;

public interface LoanServices {
	public boolean addLoanInformation(LoanBean loanBean);

	public boolean deleteLoanInformation(String bankName);

	public LoanProgRepository getLoanPrograms();
	
	public boolean makeLoan();

}
