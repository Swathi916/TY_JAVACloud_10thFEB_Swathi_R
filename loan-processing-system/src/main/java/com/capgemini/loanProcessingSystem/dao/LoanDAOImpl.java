package com.capgemini.loanProcessingSystem.dao;

import org.apache.log4j.Logger;

import com.capgemini.loanProcessingSystem.beans.LoanBean;
import com.capgemini.loanProcessingSystem.repository.LoanProgRepository;

public class LoanDAOImpl implements LoanDAO{
	Logger log = Logger.getLogger(LoanDAOImpl.class);
	@Override
	public boolean addLoanInformation(LoanBean loanBean) {
		for (LoanBean loanBean1 : LoanProgRepository.ARRAY_LIST) {
			return true; 
		}

		LoanProgRepository.ARRAY_LIST.add(loanBean);
		return false; 
	}

	@Override
	public boolean deleteLoanInformation(String bankName) {
		for (int i = 0; i < LoanProgRepository.ARRAY_LIST.size(); i++) {
			if (bankName.equals(LoanProgRepository.ARRAY_LIST.get(i).getBankName())) {
				LoanProgRepository.ARRAY_LIST.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public LoanProgRepository getloanPrograms() {
		for (int i = 0; i < LoanProgRepository.ARRAY_LIST.size(); i++) {
			log.info(LoanProgRepository.ARRAY_LIST.get(i));
		}
		return null;
	}

	@Override
	public boolean makeLoan() {
		for (LoanBean bean : LoanProgRepository.ARRAY_LIST) {
			log.info(LoanProgRepository.ARRAY_LIST);
			return true;
		}
		return false;
	}
	

}
