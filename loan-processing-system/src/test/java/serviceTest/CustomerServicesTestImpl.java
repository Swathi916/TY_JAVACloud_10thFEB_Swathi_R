package serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.capgemini.loanProcessingSystem.beans.CustomerBean;
import com.capgemini.loanProcessingSystem.dao.CustomerDAO;
import com.capgemini.loanProcessingSystem.exception.UserNameAlreadyExistsException;
import com.capgemini.loanProcessingSystem.factory.FactoryDAO;
import com.capgemini.loanProcessingSystem.services.CustomerServices;
import com.capgemini.loanProcessingSystem.services.CustomerServicesImpl;

public class CustomerServicesTestImpl {
	private CustomerBean customer = new CustomerBean();

	private CustomerServices customerServices = new CustomerServicesImpl();

	@Test
	void payLoan() {
		try {
			customer.setUserName("sanant28");
			customer.setPassword("Anant@123");
			customer.getLoanAmount();
		} catch (Exception e) {
			assertThrows(UserNameAlreadyExistsException.class, () -> {
				customerServices.changePassword(customer);
			});
		}
	}
	
	@Test
	void changePassword() {
		customer.setPassword("Anant#1234");
		try {
			boolean flag = customerServices.changePassword(customer);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(UserNameAlreadyExistsException.class, () -> {
				customerServices.changePassword(customer);
			});
		}
	}
	
	@Test
	void checkBalance() {
		String userName = "sanant28";
		String password = "Anant@123";
		try {
			boolean flag = customerServices.checkBalance(userName, password);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(UserNameAlreadyExistsException.class, () -> {
				customerServices.checkBalance(userName, password);
			});
		}	
		
	}

}
