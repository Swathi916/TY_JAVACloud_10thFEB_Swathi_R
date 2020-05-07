package com.tyss.capgemini.lps.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tyss.capgemini.lps.beans.ApplicationBean;
import com.tyss.capgemini.lps.beans.CustomerBean;
import com.tyss.capgemini.lps.beans.LoanBean;
import com.tyss.capgemini.lps.repository.LoanProcessingSystemDB;
import com.tyss.capgemini.lps.repository.LoanProgRepository;

public class AdminDAOImpl implements AdminDAO {
	private ArrayList<LoanBean> loanBean = LoanProgRepository.ARRAY_LIST;
	Logger log = Logger.getLogger(AdminDAOImpl.class);

	@Override
	public boolean addClient(CustomerBean bean) {
		for (CustomerBean CustomerBean : LoanProcessingSystemDB.CUSTOMER_BEANS) {
			if (CustomerBean.getCustomerId() == bean.getCustomerId()) {
				return false;
			}
		}
		LoanProcessingSystemDB.CUSTOMER_BEANS.add(bean);
		return true;
	}

	@Override
	public List<ApplicationBean> viewClient() {
		List<ApplicationBean> applicationBean = LoanProcessingSystemDB.APPLICATION_BEANS;
		return applicationBean;

	}

	@Override
	public boolean addLoanInformation(LoanBean loanBean) {
		for (LoanBean loanBeanBean : LoanProgRepository.ARRAY_LIST) {
			return false;
		}

		LoanProgRepository.ARRAY_LIST.add(loanBean);
		return true;
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

}
