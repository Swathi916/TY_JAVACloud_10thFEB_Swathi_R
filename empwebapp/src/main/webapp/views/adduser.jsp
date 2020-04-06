<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Users</title>
</head>
<link href="https://unpkg.com/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet"/>

<body>

<h1> Add New User|Update User</h1>
<div class="container">
  <div class="float-right">
    <a href="${pageContext.request.contextPath}/UserController?action=LIST">View All Records</a>

      |
      <a href="${pageContext.request.contextPath}/logout.jsp" >Logout</a>
  </div>
  
     <form action="${pageContext.request.contextPath}/UserController" method="POST">
     Enter name: <input type = "text" name = "firstname" value="${user.name}"/><br/>
     Enter password: <input type = "text" name = "password" value="${user.password}"/><br/>
     Enter email: <input type = "text" name = "email" value="${user.email}"/><br/>
     sex: <input type="radio" name="sex" value="male" /> male 
          <input type="radio" name="sex" value="female" /> female <br/>
     Country:              <select name="country">
                <option value="India">INDIA</option>
                <option value="USA">USA</option>
                <option value="UK">UK</option>
                <option value="japan">JAPAN</option>
                </select></br>
    
     <input type = "hidden" value ="${user.id}" name="id"/>
     <button class="btn btn-primary" type="submit">Add	 User</button>
     </form>
  </div>
</body>
</html>