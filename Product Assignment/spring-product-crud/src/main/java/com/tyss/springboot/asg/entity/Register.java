package com.tyss.springboot.asg.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register")
public class Register implements Serializable {
	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	Register(){
		
	}
	@Override
	public String toString() {
		return "Register [email=" + email + ", fullName=" + fullName + ", password=" + password + ", role=" + role
				+ "]";
	}

	public Register(String email, String fullName, String password, String role) {
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.role = role;
	}

}