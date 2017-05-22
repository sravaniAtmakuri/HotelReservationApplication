<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title> Hulton Hotel Reservation</title>
	<meta name="description" content="Smart Health App">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	
</head>
	
<script type="text/javascript">
    function myFunction(form) {
           if (form.userName.value=="") {
           alert("Error: Username cannot be blank!");
           form.userName.focus();
           return false;
        }
        if(form.password.value.length>8){
            alert("Error: Password length cannot be more than 8 characters!");
            form.password.focus();  
            return false;
        }
        if(form.password.value==""){
            alert("Error: Password cannot be blank!");
            form.password.focus();  
            return false;
        }
        else {
          //  alert("Login Successfull!!!");
            document.getElementById("loginPage").submit();
            return true;
        }
    
    }
</script>	


	
<body>

  		<nav class= "navbar navbar-inverse navbar-fixed-top" id="my-navbar">
                    <ul class="nav navbar-nav navbar-right">
                         <li> <a href="HomePage.jsp">HOME</a>
                         <li><a href="StatisticsPage.jsp">STATISTICS</a>                       
                         </ul>
  			
  		</nav> 

  		

  		<div class="jumbotron">
			<div class="container text-center" style="max-height: 100px">
                            <h1>HULTON HOTEL </h1>
			</div>
		</div>


 <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
          <h1 class="text-center">Welcome</h1>
        </div>
         <form  action="LoginServlet" method="post" id="loginPage" onsubmit=" return myFunction(this)">
             <p style="color: red">
                                    <%
                                        String message1=request.getParameter("message1");
                                        if(message1!=null)
                                        {%>
                                   <% out.println(request.getParameter("message1")); %>
                                     <% }
                                    %>
                                </p>
                                <p style="color: green">
                                    <%
                                        String message2=request.getParameter("message2");
                                        if(message2!=null)
                                        {%>
                                        <%=message2%>
                                     <% }
                                    %>
                                </p>
         <div class="modal-body modal-content">
             <div class="form-group">
                 <input type="email" id="userName" name="userName" placeholder="Username" class="form-control input-lg"/>
             </div>

             <div class="form-group">
                 <input type="password" id="password" name="password" placeholder="Password" class="form-control input-lg"/>
             </div>

             <div class="form-group">
              
                 <input type="submit" class="btn btn-block btn-lg btn-primary" value="Login"/>
                 <span class="pull-right"><a href="RegistrationPage.jsp">Register</a></span><span><a href="ForgotPassswordPage.jsp">Forgot Password</a></span>

             </div>
         </div>
                          </form>

    </div>
 </div>

  		
    <script src="https://code.jquery.com/jquery-3.1.1.js"> </script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
</body>	
</html> 