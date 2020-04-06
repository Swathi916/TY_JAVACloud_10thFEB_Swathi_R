<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View User</title>
</head>
<link href="https://unpkg.com/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<h1>Users List</h1>

    <div class="container">
    <div class="float-right">
      <a href="${pageContext.request.contextPath}/logout.jsp" >Logout</a>
  </div>
    <p>${message}</p>
    <button class="btn btn-primary" onclick="window.location.href='views/adduser.jsp'">Add New User</button>
    
    <table border = "1" class="table table-striped table-bordered">
   <tr class="thead-dark">
   <th>Id</th>
   <th>Name</th>
    <th>password</th>
     <th>Email</th>
     <th>Sex</th>
      <th>Country</th>
       <th>Edit|Delete</th>
        <th></th>
    
   </tr>
   <c:forEach items="${list}" var="employee"> 
   <tr>
    <td>${employee.id}</td>
     <td>${employee.name}</td>
      <td>${employee.password}</td> 
      <td>${employee.email}</td>
      <td>${employee.sex}</td>  
      <td>${employee.country}</td> 
      
     
      <td>
            <a href="${pageContext.request.contextPath}/UserController?action=EDIT&id=${employee.id}">Edit</a>
            |
            <a href="${pageContext.request.contextPath}/UserController?action=DELETE&id=${employee.id}">Delete</a>
      
      </td>
      
   </tr>
   </c:forEach> 
   </table>
    </div>
    </body>
</html>