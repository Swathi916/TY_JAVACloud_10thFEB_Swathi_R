
package serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.capgemini.loanProcessingSystem.beans.LoanBean;
import com.capgemini.loanProcessingSystem.dao.LoanDAO;
import com.capgemini.loanProcessingSystem.dao.LoanDAOImpl;
import com.capgemini.loanProcessingSystem.exception.UserNameAlreadyExistsException;
import com.capgemini.loanProcessingSystem.repository.LoanProgRepository;
import com.capgemini.loanProcessingSystem.services.LoanServices;
import com.capgemini.loanProcessingSystem.services.LoanServicesImpl;

public class LoanServicesTestImpl {
	private LoanBean loanBean = new LoanBean();

	private LoanServices loanServices = new LoanServicesImpl();

	@Test
	void addLoanInformation() {
		loanBean.setBankName("HDFC Bank");
		loanBean.setEmi("4500");
		loanBean.setLoanAmount("200000");
		loanBean.setLoanType("Home Loan");
		loanBean.setRateOfInterest("8.0%");
		try {
			boolean flag = loanServices.addLoanInformation(loanBean);
			assertEquals(flag, true);			
		} catch (Exception e) {
			assertThrows(UserNameAlreadyExistsException.class, () -> {
				loanServices.addLoanInformation(loanBean);
			});
		}
	}
	@Test
	void makeLoan() {
		try {
			LoanProgRepository loanProgRepository = loanServices.getLoanPrograms();
			assertNull(loanProgRepository);
		} catch (Exception e) {
			assertThrows(UserNameAlreadyExistsException.class, () -> {
				loanServices.addLoanInformation(loanBean);
			});
		}
	}// end of makeLoan

	
	@Test
	void deleteLoanInformation() {
		loanBean.setBankName("HDFC Bank");
		boolean flag = loanServices.deleteLoanInformation(loanBean.getBankName());
		assertTrue(flag);
	}// end of deleteLoanInformation
	
	@Test
	void getLoanInformation() {
		try {
			LoanProgRepository loanProgRepository = loanServices.getLoanPrograms();
			assertNull(loanProgRepository);
		} catch (Exception e) {
			assertThrows(UserNameAlreadyExistsException.class, () -> {
				loanServices.addLoanInformation(loanBean);
			});
		}
	}// end of getLoanInformation
	

}
