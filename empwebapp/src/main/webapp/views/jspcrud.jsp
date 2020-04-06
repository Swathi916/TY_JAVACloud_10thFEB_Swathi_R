<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP CRUD</title>
</head>
<body>

 <%
     
    String email = (String)session.getAttribute("email");  
     if(email == null) {
    	 response.sendRedirect("index.jsp");
     }
     %>
<h1> JSP CRUD EXAMPLE</h1>

  
<a href="${pageContext.request.contextPath}/views/adduser.jsp" >Add User</a>|

<a href="${pageContext.request.contextPath}/UserController?action=LIST">View User</a>

<div class="container">
  <div class="float-right">
    

      |
      <a href="${pageContext.request.contextPath}/logout.jsp" >Logout</a>
  </div>
  </div>

  

</body>
</html>