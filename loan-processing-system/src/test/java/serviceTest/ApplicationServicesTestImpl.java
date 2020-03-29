package serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.loanProcessingSystem.beans.ApplicationBean;
import com.capgemini.loanProcessingSystem.beans.CustomerBean;
import com.capgemini.loanProcessingSystem.dao.ApplicationDAO;
import com.capgemini.loanProcessingSystem.factory.FactoryDAO;
import com.capgemini.loanProcessingSystem.services.ApplicationServices;
import com.capgemini.loanProcessingSystem.services.ApplicationServicesImpl;

public class ApplicationServicesTestImpl {
	private ApplicationBean application = new ApplicationBean();
	private CustomerBean customer =new CustomerBean();

	private ApplicationServices applicationService = new ApplicationServicesImpl();

	@Test
	void addApplicationTest() {
		application.setApplicationId(702);
		try {
			boolean flag = applicationService.addApplication(customer);
			assertEquals(true, flag);
		} catch (Exception e) {
			applicationService.addApplication(customer);
		};
	} // end of catch block


	@Test
	void getAllApplicationTest() {
		List<ApplicationBean> allApplication = applicationService.viewApplication();
		assertNotNull(allApplication);
	}


	@Test
	void updateApplication() {
		application.setApplicationId(702);
		application.setStatus("Accept");
		try {
			boolean flag = applicationService.updateApplicationStatus(702, "Accept");
			assertEquals(flag, true);
		} catch (Exception e) {
			applicationService.updateApplicationStatus(702, "Accept");
		}
	} // end of catch block
	

}
