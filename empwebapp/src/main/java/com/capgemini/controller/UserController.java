package com.capgemini.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.bean.User;
import com.capgemini.dao.UserDAO;
import com.capgemini.dao.UserDAOImpl;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  //create reference variable for employee DAO
	UserDAO userDAO = null;
	RequestDispatcher dispatcher = null;
	//create a constructor and initialize employee DAO
	
    public UserController() {
    	userDAO  = new UserDAOImpl();
        
      
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String action = request.getParameter("action");
    	if(action == null) {
    		action = "LIST";
    	}
    	
    	switch(action) {
    	      case "LIST":
    	    	  listEmployees(request, response);
    	    	  break;
    	    	  
   	      case "EDIT":
    	    	  getSingleEmployee(request, response);
    	    	  break;
    	    	  
   	      case "DELETE":
	    	      deleteEmployee(request, response);
	    	      break;  	  
    	      default:
    	    	  listEmployees(request, response);
    	    	  break;
    	    	  
    	      
    	}
    	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String name = request.getParameter("firstname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String country = request.getParameter("country");
		
		
		User e = new User();
		
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setSex(sex);
		e.setCountry(country);
		
		if(id.isEmpty() || id == null) {
			//save operation
			if(userDAO.save(e)) {
				request.setAttribute("message", "Added Successfully");
			}
		}else {
			//update operation
			e.setId(Integer.parseInt(id));
			if(userDAO.update(e)) {
				request.setAttribute("message", "Update Successfully");
			}
		}
		
		
		listEmployees(request, response);
	
	}
	
	public void listEmployees(HttpServletRequest request, HttpServletResponse response) {

    	//call the dao method to get list of employees
    	List<User> list = userDAO.get();
    	//add the employees to request object
    	request.setAttribute("list", list);
    	
    	
    	//get the request dispatcher
    	
    	 dispatcher =	request.getRequestDispatcher("/views/viewuser.jsp");
    	//forwrd the reques and response object
    	try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("id");
	     User user =	userDAO.get(Integer.parseInt(id));
	     request.setAttribute("user", user);
	     dispatcher =	request.getRequestDispatcher("/views/adduser.jsp");
	    
	     dispatcher.forward(request, response);            
	}
	
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		if(userDAO.delete(Integer.parseInt(id))){
			 request.setAttribute("message", "Record has been deleted");
		
	}

		listEmployees(request, response);
		
}
}
