package com.capgemini.lps.rest;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lps.entity.Applicant;
import com.capgemini.lps.entity.User;
import com.capgemini.lps.exception.ApplicationNotFoundException;
import com.capgemini.lps.exception.UserNotFoundException;
import com.capgemini.lps.response.Response;
import com.capgemini.lps.service.ApplicantService;
import com.capgemini.lps.service.UserService;

@RestController
@RequestMapping("/api2")
@CrossOrigin(origins = "*")
public class ApplicantRestController implements Serializable {

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private UserService userService;


	@GetMapping("/loanApplication")
	public List<Applicant> findAllRequested() {
		return applicantService.findAll();
	}

	@PutMapping("/loanApplicationApprove/{appId}")
	public Response<Applicant> findAllApproved(@PathVariable Integer appId) {
		Applicant result = applicantService.setApproved(appId);
		if (result == null) {
			return new Response<>(true, "Updation failed", null);
		} else {
			return new Response<>(false, "successfully updated", result);
		}

	}

	@PutMapping("/loanApplicationReject/{appId}")
	public Response<Applicant> findAllRejected(@PathVariable Integer appId) {
		Applicant result = applicantService.setRejected(appId);
		if (result == null) {
			return new Response<>(true, "Updation failed", null);
		} else {
			return new Response<>(false, "successfully updated", result);
		}
	}

	@GetMapping("/loanApplication/{loanapplication}")
	public Applicant getById(@PathVariable int loanapplication) {

		Applicant applicant = applicantService.getById(loanapplication);

		if (applicant == null) {
			throw new ApplicationNotFoundException("id not found " + loanapplication);
		}
		return applicant;
	}

	@PostMapping("/AddLoanApplication")
	public Response<Applicant> saveApplicant(@Valid @RequestBody Applicant applicant) {
		applicant.setAppId(0);
		Applicant result = applicantService.saveApplicant(applicant);
		if (result == null) {
			return new Response<>(true, "save failed", null);
		} else {
			return new Response<>(false, "successfully saved", result);
		}
	}

	@PostMapping("/makeloan/{email}")
	public Response<Applicant> makeLoan(@PathVariable String email, @Valid @RequestBody Applicant applicant) {
		User user = userService.getByEmail(email);
		applicant.setUser(user);
		if (applicantService.saveApplicant(applicant) == null) {

			return new Response<>(true, "application not saved", null);

		} else {
			return new Response<>(false, "application saved successfull", null);
		}
	}

	@PutMapping("/updateLoanApplication")
	public Applicant updateApplicant(@Valid @RequestBody Applicant applicant) {
		applicantService.saveApplicant(applicant);
		return applicant;
	}


	@GetMapping("/getUser")

	public List<User> findAll() {

		return userService.findAll();
	}

	

	@GetMapping("getUserById/{userId}")
	public Response<User> getClient(@PathVariable int userId) {

		User theUser = userService.findById(userId);

		if (theUser != null) {
			return new Response<>(false, "records found", theUser);
		} else {
			throw new UserNotFoundException("record not found");
		}

	}

	@PostMapping("/addUser")
	public Response<User> addClient(@Valid @RequestBody User theUser) {

		User user1 = userService.save(theUser);

		if (user1 != null) {

			return new Response<>(false, "User added successfully", user1);

		} else {
			return new Response<>(true, "save failed", null);
		}
	}

	@DeleteMapping("/deleteUser/{userId}")
	public Response<User> deleteClient(@PathVariable int userId) {

		User tempUser = userService.findById(userId);

		if (tempUser != null) {
			userService.deleteById(userId);
			return new Response<>(false, "User Deleted Successfully", tempUser);
		} else {
			throw new UserNotFoundException("record not found");
		}
	}

	@GetMapping("/getUserByPage/{pageNo}/{itemsPerPage}")
	public Page<User> getClients(@PathVariable int pageNo, @PathVariable int itemsPerPage) {
		return userService.getClients(pageNo, itemsPerPage);
	}

	@GetMapping("/sortUser/{pageNo}/{itemsPerPage}/{fieldName}")
	public Page<User> getSortClients(@PathVariable int pageNo, @PathVariable int itemsPerPage,
			@PathVariable String fieldName) {
		return userService.getSortClients(pageNo, itemsPerPage, fieldName);
	}
	
}
