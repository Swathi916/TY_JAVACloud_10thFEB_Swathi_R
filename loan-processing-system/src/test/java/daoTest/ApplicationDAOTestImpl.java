package daoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;


import org.junit.jupiter.api.Test;

import com.capgemini.loanProcessingSystem.beans.ApplicationBean;
import com.capgemini.loanProcessingSystem.beans.CustomerBean;
import com.capgemini.loanProcessingSystem.dao.ApplicationDAO;
import com.capgemini.loanProcessingSystem.factory.FactoryDAO;

public class ApplicationDAOTestImpl {
	private ApplicationBean application = new ApplicationBean();
	private CustomerBean customer =new CustomerBean();

	private ApplicationDAO applicationDao = FactoryDAO.getApplicationDAO();

	@Test
	void addApplicationTest() {
		application.setApplicationId(702);
		try {
			boolean flag = applicationDao.addApplication(customer);
			assertEquals(true, flag);
		} catch (Exception e) {
			applicationDao.addApplication(customer);
		};
	} // end of catch block


	@Test
	void getAllApplicationTest() {
		List<ApplicationBean> allApplication = applicationDao.viewApplication();
		assertNotNull(allApplication);
	}


	@Test
	void updateApplication() {
		application.setApplicationId(702);
		application.setStatus("Accept");
		try {
			boolean flag = applicationDao.updateApplicationStatus(702, "Accept");
			assertEquals(flag, true);
		} catch (Exception e) {
			applicationDao.updateApplicationStatus(702, "Accept");
		}
	} // end of catch block
	

}
