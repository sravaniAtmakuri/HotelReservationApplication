<%@page import="java.util.ArrayList"%>
<%@page import="bean.Credit_CardBean"%>
<%@page import="bean.Room_ReservationBean"%>
<%@page import="bean.ReservationBean"%>
<!DOCTYPE html>
<%@page import="javax.servlet.http.HttpSession" %>

<% 
ReservationBean reserve= (ReservationBean)request.getAttribute("ReservationBean");
Room_ReservationBean roomReserve= (Room_ReservationBean) request.getAttribute("Room_ReservationBean");
Credit_CardBean cardDetails =(Credit_CardBean) request.getAttribute("Credit_CardBean");

String InvoiceNo=request.getParameter("InvoiceNo");
ArrayList<String> stype=(ArrayList<String>)session.getAttribute("Stypes");
ArrayList<String> sprice=(ArrayList<String>)session.getAttribute("Sprices");






%>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title> Confirmation Page</title>
	<meta name="description" content="Smart Health App">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

</head>
	
<script type="text/javascript">
   
    
   
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
                 <li><a href="SearchLocation.jsp">Search Hotels</a>
                
         <li><a href="loginPage.jsp">LOGOUT</a>
             </ul>
  			
  		</nav> 

  		

  		<div class="jumbotron">
			<div class="container text-center" style="max-height: 100px">
                            <h1>Your Booking is done</h1>
			</div>
		</div>


 <div class="modal-dialog modal-lg" >
    <div class="modal-content">
        <div class="modal-header">
          <h4>Booking ID : <%=InvoiceNo%>  . All details will be sent to <%=session.getAttribute("userName") %></h4>
          <h6>Thank you for booking Hulton Hotel. Use the above booking id in all communication with Hulton Hotel. </h6>
        </div>
         <!--<form  action="SearchLocationServlet" method="post" id="loginPage" onsubmit=" return myFunction(this)">-->
             <p style="color: red">
                                   
                                </p>
         <div   class="modal-body  modal-dialog modal-lg form-inline">
             
             <div class="form-group">
                <h3> You Just Booked Services at Hulton Hotel  </h3>
                 <!--<input type="search" id="Location" name="Location" placeholder="location" class="form-control input-lg"/>-->
                 <fieldset class="row1">
                                    <legend style="color: #066A75">
                                    </legend>
                                    <table  style="width:80%" cellspacing="0" cellpadding="0">
                                        
                                        <tr>
                                            <th>Service</th>
                                            <th>Price</th>
                                        </tr>
                                        <tr>
                                            <% for(int i=0;i<stype.size();i++){ %>
                                            <td><%=stype.get(i)%></td>
                                           <td><%=sprice.get(i)%></td>
                                          </tr>
                                            <% } %>
                                        
                                        
                                      
                                       
                                        
                                    </table> 
                                </fieldset>
             </div>

             
         </div>
       </form>

    </div>
 </div>

  		
    <script src="https://code.jquery.com/jquery-3.1.1.js"> </script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
 
</body>	
</html> 