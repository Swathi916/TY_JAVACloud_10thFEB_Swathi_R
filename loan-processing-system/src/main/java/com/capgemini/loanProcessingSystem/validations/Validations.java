package com.capgemini.loanProcessingSystem.validations;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

import com.capgemini.loanProcessingSystem.beans.ApplicationBean;
import com.capgemini.loanProcessingSystem.repository.LoanProcessingSystemDB;

public class Validations {
	public static boolean isPassword(String str) {
		return ((str != null) && (!str.equals("")) && (str.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})")));
	}

	public static boolean isEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		} else {
			return pattern.matcher(email).matches();
		}
	}

	public static boolean isNumber(String num) {
		if (num.matches("[0-9]+")) {
			return true;
		}
		return false;
	}

	public static boolean isUsername(String un) {
		if (un.matches("[a-zA-Z0-9]{8,10}")) {
			return true;
		}
		return false;
	}
	
	public static boolean isAlphabet(String alph) {
		if (alph.matches("[a-zA-Z ]+")) {
			return true;
		}
		return false;
	}

	public static boolean isEMI(String emi) {
		if (emi.matches("^[0-9]+(\\.[0-9]{1,2})?$")) {
			return true;
		}
		return false;
	}
	public static boolean isRateOfIntrest(String roi) {
		if (roi.matches("[0-9%._ ]+")) {
			return true;
		}
		return false;
	}
	public static boolean validateDate(String date) {
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);
		try {
			sdf.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}


	public static boolean validAppicationId(int id) {
		List<ApplicationBean> appBean = LoanProcessingSystemDB.APPLICATION_BEANS;
		for (ApplicationBean appInfo : appBean) {
			if (appInfo.getApplicationId() == id) {
				return true;
			}
		}
		return false;
	}

}
