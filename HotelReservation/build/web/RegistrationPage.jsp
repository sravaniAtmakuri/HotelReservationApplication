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

<script>
    function myFunction(form) {
        
      if (form.phonenumber.value.length!=10) {
           alert("Error: Phone number should be 10 digits long!!");
           form.phonenumber.focus();
           return false;
        }
        if(form.password.value.length>8){
            alert("Error: Password length cannot be more than 8 characters!");
            form.password.focus();  
            return false;
        }
        if(form.password.value!=form.confirmpassword.value){
            alert("Error: Passwords donot match!");
            form.password.focus();  
            form.confirmpassword.focus();  
            return false;
        }
        else {
           // alert("Login Successfull!!!");
            document.getElementById("RegistrationPage.jsp").submit();
            return true;
        }
    }
</script>	



	
<body>

  		<nav class= "navbar navbar-inverse navbar-fixed-top" id="my-navbar">
  			
  		</nav> 

  		

  		<div class="jumbotron">
			<div class="container text-center" style="max-height: 100px">
				<h1>HULTON HOTEL </h1>
			</div>
                </div>


 <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
          <h1 class="text-center">Register Yourself</h1>
        </div>
        <form class="form-horizontal" id="patientReg" method="post" action="RegistrationServlet" onsubmit=" return myFunction(this)">
       <!--  <form  action="PatientRegistration" method="post">  -->
             <p style="color: red">
                                  <%
                                        String message=request.getParameter("message2");
                                         if(message!=null)
                                        {%>
                                        <% out.println(request.getParameter("message2"));%>
                                     <% }
                                    %>  
             </p>
         <div class="modal-body">
             <div class="form-group">
                 <input type="text" name="name" id="name" required="required" class="form-control"   placeholder="Enter your Name"/>
                </div>

             <div class="form-group">
                <input type="email"  name="email" id="email" required="required" class="form-control"   placeholder="Enter your Email"/>
                </div>

              <div class="form-group">
                <input type="text"  name="address" id="address"  required="required"  class="form-control"  placeholder="Enter your Address"/>
                </div>
             
             <div class="form-group">
             <input type="text" name="phonenumber" id="phonenumber" required = "required"  class="form-control"   placeholder="Enter your Mobile Number"/>                    
                </div>
             
             
             <div class="form-group">
                <input type="password"  name="password" id="password" required="required" class="form-control"   placeholder="Enter your password"/>
                </div>

            <div class="form-group">
                <input type="password"  name="confirmpassword" id="confirmpassword" required="required" class="form-control"   placeholder="Re-Enter the password"/>
                </div>  
             
             
             
             <div class="form-group">
              
                 <input type="submit" class="btn btn-block btn-lg btn-primary" value="Register"/>
                
             </div>
         </div>
                          </form>
                                

    </div>
 </div>

  		
    <script src="https://code.jquery.com/jquery-3.1.1.js"> </script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
</body>	
</html> 