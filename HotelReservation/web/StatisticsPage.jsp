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
	
             <ul class="nav navbar-nav navbar-right">
         <li><a href="HomePage.jsp">HomePage</a>
          
             </ul>
  			
  		</nav> 

  		
                    <div class="jumbotron">
			<div class="container text-center" style="max-height: 100px">
                            <h1> HULTON HOTEL STATISTICS </h1>
			</div>
		     </div>



 <div class="modal-dialog modal-lg" >
    <div class="modal-content">
        <div class="modal-header">
        
        </div>
         <form  action="StatisticsServlet" method="post" id="loginPage" onsubmit=" ">
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
             
                 <div class="form-group" class="input-group-addon">
                 <h3> Start Date</h3>
                 <i class="fa fa-calendar">
                 </i>   
                 <input class="form-control input-lg" id="date" required="required" name="date" placeholder="YYYY-MM-DD" type="date"/>              
             </div>
             <div class="form-group" class="input-group-addon">
                 <h3> End Date</h3>
                 <i class="fa fa-calendar">
                 </i>   
                 <input class="form-control input-lg" id="date1" required="required" name="date1" placeholder="YYYY-MM-DD" type="date1"/>              
                               
             </div>
            <hr/>
             <div class="form-group" class="input-group-addon">
                  <input  id="option" type="radio" name="option" value="rtype"/>
            <label  for="rated_room"> Compute the highest rated room type for each hotel </label>
            <br>
            
            <input  id="option" type="radio" name="option" value="top5" />
            <label  for="topcust"> Compute the top 5 customer </label>
            <br>
            
            <input id="option" type="radio" name="option" value="btype" />
            <label  for="rated_bkfst"> Compute the highest rated breakfast type across all hotels </label>
            <br>
            
            <input id="option" type="radio" name="option" value="stype" />
            <label  for="rated_service"> Compute the highest rated service type across all hotels </label>
            <br>
            <br>         
            
            
            
            
             <div class="form-group" class="input-group-addon ">
                
                 
                 <input type="submit" class="btn btn-block btn-lg btn-primary" value="Submit"/>
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