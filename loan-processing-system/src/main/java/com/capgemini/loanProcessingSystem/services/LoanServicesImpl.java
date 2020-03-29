package com.capgemini.loanProcessingSystem.services;

import com.capgemini.loanProcessingSystem.beans.LoanBean;
import com.capgemini.loanProcessingSystem.dao.LoanDAO;
import com.capgemini.loanProcessingSystem.factory.FactoryDAO;
import com.capgemini.loanProcessingSystem.repository.LoanProgRepository;

public class LoanServicesImpl implements LoanServices {
	private LoanDAO dao = FactoryDAO.getLoanDAO();

	@Override
	public boolean addLoanInformation(LoanBean loanBean) {
		return dao.addLoanInformation(loanBean);
	}

	@Override
	public boolean deleteLoanInformation(String bankName) {
		return dao.deleteLoanInformation(bankName);
	}

	@Override
	public LoanProgRepository getLoanPrograms() {
		return dao.getloanPrograms();
	}

	@Override
	public boolean makeLoan() {
		return dao.makeLoan();
	}

}
