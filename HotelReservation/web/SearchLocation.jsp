<!DOCTYPE html>
<%@page import="javax.servlet.http.HttpSession" %>
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
           if (form.Location.value=="") {
           alert("Please enter Location!");
           form.Location.focus();
           return false;
        }
           if(form.checkIndate.value==""){
            alert("Please enter CheckIn Date!");
            form.checkIndate.focus();  
            return false;
        }
        if(form.checkOutdate.value==""){
            alert("Please enter CheckOut Date!");
            form.checkOutdate.focus();  
            return false;
        }
        else {
          //  alert("Login Successfull!!!");
            document.getElementById("SearchLocation").submit();
            return true;
        }
    
    }
</script>	


	
<body>

  		<nav class= "navbar navbar-inverse navbar-fixed-top" id="my-navbar">
                    <div class="container">
	<div class="navbar-header">
		
	</div><!--navbar header-->
	
	<div class="collapse navbar-collapse" id="navbar-collapse">
	<ul class="nav navbar-nav">
	 <h4 class="navbar-text">Logged in as &nbsp;<%=session.getAttribute("userName") %></h4> 
        </ul>
             <ul class="nav navbar-nav navbar-right">
                 <li><a href="ReservationDetails.jsp">Reservation Details</a>
         <li><a href="loginPage.jsp">LOGOUT</a>
             
                
             </ul>
  			
  		</nav> 

  		

  		<div class="jumbotron">
			<div class="container text-center" style="max-height: 100px">
                            <h1>Welcome to HULTON HOTEL </h1>
			</div>
		</div>


 <div class="modal-dialog modal-lg" >
    <div class="modal-content">
        <div class="modal-header">
          <h1 class="text-center">Search Location</h1>
        </div>
         <form  action="SearchLocationServlet" method="post" id="loginPage" onsubmit=" return myFunction(this)">
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
         <div   class="modal-body  modal-dialog modal-lg form-inline">
             
             <div class="form-group" >
                <h3> Location </h3>
                 <!--<input type="search" id="Location" name="Location" placeholder="location" class="form-control input-lg"/>-->
                 <select class="form-control input-lg" id="Location" name="Location">
              <option>New York</option>
              <option>New Jersey</option>
              <option>California</option>
              <option>Portland</option>
                        
              </select>
             </div>

             <div class="form-group" class="input-group-addon">
                 <h3> CheckIn Date</h3>
                 <i class="fa fa-calendar">
                 </i>   
                 <input class="form-control input-lg" id="date" required="required" name="date" placeholder="YYYY-MM-DD" type="date"/>              
             </div>
             <div class="form-group" class="input-group-addon">
                 <h3> CheckOut Date</h3>
                 <i class="fa fa-calendar">
                 </i>   
                 <input class="form-control input-lg" id="date1" required="required" name="date1" placeholder="YYYY-MM-DD" type="date1"/>              
                               
             </div>
            <hr/>
             <div class="form-group ">
                
                 
                 <input type="submit" class="btn btn-block btn-lg btn-primary" value="Search"/>
                 <!--<span class="pull-right"><a href="RegistrationPage.jsp">Register</a></span><span><a href="ForgotPassswordPage.jsp">Forgot Password</a></span>-->

             </div>
         </div>
       </form>

    </div>
 </div>

  		
    <script src="https://code.jquery.com/jquery-3.1.1.js"> </script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
  <!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<script>
    $(document).ready(function(){
        var date_input=$('input[name="date"]'); //our date input has the name "date"
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'yyyy-mm-dd',
            container: container,
            todayHighlight: true,
            autoclose: true,
            onSelect: function(){
                  var date = $(this).datepicker('getDate');
                  document.getElementById("date").value=date;
              }
        });
    });
    
</script>

 <script src="https://code.jquery.com/jquery-3.1.1.js"> </script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<script>
    $(document).ready(function(){
        var date_input=$('input[name="date1"]'); //our date input has the name "date"
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'yyyy-mm-dd',
            container: container,
            todayHighlight: true,
            autoclose: true,
            onSelect: function(){
                  var date = $(this).datepicker('getDate');
                  document.getElementById("date1").value=date;
              }
        });
    });
    
</script>
</body>	
</html> 