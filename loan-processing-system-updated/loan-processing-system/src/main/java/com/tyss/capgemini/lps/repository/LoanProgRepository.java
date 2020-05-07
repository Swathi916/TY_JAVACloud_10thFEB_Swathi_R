package com.tyss.capgemini.lps.repository;

import java.util.ArrayList;

import com.tyss.capgemini.lps.beans.LoanBean;

public class LoanProgRepository {
	public static final ArrayList<LoanBean> ARRAY_LIST = new ArrayList<LoanBean>();

	static {
		LoanBean loanBean1 = new LoanBean();
		loanBean1.setBankName("HDFC Bank");
		loanBean1.setLoanType("Home Purchase loan");
		loanBean1.setEmi("752");
		loanBean1.setRateOfInterest("8.00%");
		loanBean1.setLoanAmount("500000");
		ARRAY_LIST.add(loanBean1);

		LoanBean loanBean2 = new LoanBean();
		loanBean2.setBankName("SBI Bank");
		loanBean2.setLoanType("Loan Type:Home Construction loan");
		loanBean2.setEmi("EMI Rs.800/lakh*");
		loanBean2.setRateOfInterest("Rate of Interest 7.00%-8.50%");
		loanBean2.setLoanAmount("Loan Amount Rs 5L - Rs 15Cr ");
		ARRAY_LIST.add(loanBean2);

		LoanBean loanBean3 = new LoanBean();
		loanBean3.setBankName("SBI Bank");
		loanBean3.setLoanType("Loan Type:Home Extention loan");
		loanBean3.setEmi("EMI Rs.850/lakh*");
		loanBean3.setRateOfInterest("Rate of Interest 7.5%-8.50%");
		loanBean3.setLoanAmount("Loan Amount Rs 50L - Rs 5Cr ");
		ARRAY_LIST.add(loanBean3);
	}
}
