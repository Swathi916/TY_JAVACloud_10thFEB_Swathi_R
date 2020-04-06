package com.capgemini.dao;

import com.capgemini.bean.Login;

public interface LoginDAO {

	String authenticate(Login login);
}
