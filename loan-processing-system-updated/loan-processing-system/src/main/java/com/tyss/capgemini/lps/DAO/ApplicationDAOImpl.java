package com.tyss.capgemini.lps.DAO;

import java.util.List;

import org.apache.log4j.Logger;

import com.tyss.capgemini.lps.beans.ApplicationBean;
import com.tyss.capgemini.lps.beans.CustomerBean;
import com.tyss.capgemini.lps.repository.LoanProcessingSystemDB;

public class ApplicationDAOImpl implements ApplicationDAO {
	Logger log = Logger.getLogger(ApplicationDAOImpl.class);

	@Override
	public boolean addApplication(CustomerBean bean) {
		for (ApplicationBean applicationBean : LoanProcessingSystemDB.APPLICATION_BEANS) {
			if (applicationBean.getApplicationId() == bean.getApplicationId()) {
				return false;
			}
		}
		LoanProcessingSystemDB.CUSTOMER_BEANS.add(bean);
		return true;
	}

	@Override
	public List<ApplicationBean> viewApplication() {
		List<ApplicationBean> applicationBean = LoanProcessingSystemDB.APPLICATION_BEANS;
		return applicationBean;
	}
	
	@Override
	public boolean makeLoan(ApplicationBean bean) {
		for (ApplicationBean applicationBean : LoanProcessingSystemDB.APPLICATION_BEANS) {
			if(applicationBean.getApplicationId().equals(bean.getApplicationId()))
				return false;
		}
//		LoanProcessingSystemDB.APPLICATION_BEANS.add(bean);
		return true;
	}

	@Override
	public boolean updateApplicationStatus(int appId, String status) {
		for (ApplicationBean applicationinfoBean : LoanProcessingSystemDB.APPLICATION_BEANS) {
			if (applicationinfoBean.getApplicationId() == appId) {
				applicationinfoBean.setStatus(status);
				return true;
			}
		}
		return false;
	}

	@Override
	public ApplicationBean getAllApplication(String loanType) {

		for (int i = 0; i < LoanProcessingSystemDB.APPLICATION_BEANS.size(); i++) {
			if (loanType.equals(LoanProcessingSystemDB.APPLICATION_BEANS.get(i).getLoanType())) {
				log.info(LoanProcessingSystemDB.APPLICATION_BEANS.get(i));
				break;
			}
		}
		return null;
	}

}
