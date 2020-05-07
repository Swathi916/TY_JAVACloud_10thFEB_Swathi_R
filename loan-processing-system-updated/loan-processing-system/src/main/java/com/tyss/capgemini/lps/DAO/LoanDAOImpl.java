package com.tyss.capgemini.lps.DAO;

import java.util.List;

import org.apache.log4j.Logger;

import com.tyss.capgemini.lps.beans.ApplicationBean;
//import com.capgemini.banking.beans.UserDetails;
import com.tyss.capgemini.lps.beans.LoanBean;
import com.tyss.capgemini.lps.repository.LoanProcessingSystemDB;
import com.tyss.capgemini.lps.repository.LoanProgRepository;

public class LoanDAOImpl implements LoanDAO {
	Logger log = Logger.getLogger(LoanDAOImpl.class);

	@Override
	public boolean addLoanInformation(LoanBean loanBean) {
		for (LoanBean loanBean1 : LoanProgRepository.ARRAY_LIST) {
			log.info(loanBean);
			return true; // false
		}

		LoanProgRepository.ARRAY_LIST.add(loanBean);
		return false; // true
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

//	@Override
//	public boolean makeLoan() {
//		for (LoanBean bean : LoanProgRepository.ARRAY_LIST) {
//			log.info(LoanProgRepository.ARRAY_LIST);
//			return true;
//		}
//		return false;
//	}
	


	@Override
	public boolean updateLoanInformation(LoanBean loanBean) {
		for (LoanBean loanInfoBean : LoanProgRepository.ARRAY_LIST) {
			if (loanInfoBean.getBankName().equals(loanBean.getBankName())) {
				loanInfoBean.setLoanType(loanBean.getLoanType());
				loanInfoBean.setRateOfInterest(loanBean.getRateOfInterest());
				loanInfoBean.setEmi(loanBean.getEmi());
				loanInfoBean.setLoanAmount(loanBean.getLoanAmount());
		
				return true;
			}
		}
		return false;
		
		
//		List<LoanBean> loanBean1 = LoanProgRepository.ARRAY_LIST;
//	
//		if(!loanBean1.isEmpty()) {
//			for(LoanBean user: loanBean1) {
//				if(user.getBankName().equals(loanBean.getBankName())) {
//					loanBean1.remove(user);
//					loanBean.setBankName(user.getBankName());
//					loanBean1.add(loanBean);
//					LoanProgRepository.ARRAY_LIST;
//				}
//			}
//			for(UserDetails user: loanBean1) {
//				log.info("updated the user details");
//				
//			}
//		}
	}



}
