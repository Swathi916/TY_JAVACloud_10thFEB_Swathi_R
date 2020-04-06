<html>
<head>
<title></title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<body>
      <%
       String email =  (String)session.getAttribute("email");
      //if user is already logged in redirect it to list employee
      if(email !=null){
    	  response.sendRedirect("views/jspcrud.jsp");
      }
          String status = request.getParameter("status");
      if(status != null){
    	  
    	  if(status.equals("false")){
    		  out.println("Bad Credentials");
    		  
    	  }else if(status.equals("error")){
    		  out.println("Some error occured");
    		  
    	  }
      }
      
      
      
      
      
      
      %>

	<div class="container">
	<form action="loginprocess" method="post">
		<div class = "card">
			<div class="card-header">Login</div>
			<div class="card-body">
			<div class="form-group">
			<input type="text" name="email" class="form-control"  placeholder="Enter email"/>
			</div>
				
		    <div class="form-group">
				 <input type="password" name="password" class="form-control" placeholder="Enter password"/>
			</div>
			<div class="card-footer">

			<input type="submit" value="Login" class="btn btn-primary" />
		</div>
	</form>
	</div>


</body>





</html>