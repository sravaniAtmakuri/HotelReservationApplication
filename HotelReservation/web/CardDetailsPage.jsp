
<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.util.List"%>
<%@page import="bean.RoomBean"%>
<%@page import="Service.Service" %>
<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.http.HttpServlet" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.util.ArrayList" %>

<% RoomBean roombean=(RoomBean) session.getAttribute("roomBean"); %>
<%String str=request.getRequestURL()+"?";
Enumeration<String> paramNames = request.getParameterNames();

while (paramNames.hasMoreElements())
{
    String paramName = paramNames.nextElement();
    System.out.println(""+paramName);
    String[] paramValues = request.getParameterValues(paramName);
  //   System.out.println(""+paramValues.length);
    for (int i = 0; i < paramValues.length; i++) 
    {
        String paramValue = paramValues[i];
         System.out.println(""+paramValue);
        str=str + paramName + "=" + paramValue;
    }
    str=str+"&";
}
System.out.println(str.substring(0,str.length()-1)+"\t"); 
 String hotelID=request.getParameter("HotelID");
 String roomNo=request.getParameter("messageroomNo");
 
 System.out.println("roomNo is: "+roomNo+" hotelID is : "+hotelID);
 String checkindateString = (String)session.getAttribute("date");
  String checkoutdateString = (String)session.getAttribute("date1");
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
LocalDate checkindate = LocalDate.parse(checkindateString,formatter);
LocalDate checkoutdate=LocalDate.parse(checkoutdateString, formatter);
System.out.println("checkindate is :"+checkindate+"check out date is: "+checkoutdate);
long numberOfdays= ChronoUnit.DAYS.between(checkindate, checkoutdate);
System.out.println("number of nights is: "+numberOfdays );
session.setAttribute("NoOfDays", numberOfdays);

String priceString = request.getParameter("Price");
String roomdescription=request.getParameter("description");
String desc=""+roomdescription;
session.setAttribute("description", roomdescription);
System.out.println("Room description in carddetails jsp is: "+roomdescription);
System.out.println("Room description in carddetails jsp is: "+desc);
double subtotal = Double.parseDouble(priceString)*numberOfdays;
double tax = subtotal *0.10;
double total = subtotal+tax;
session.setAttribute("totalamount", total);
session.setAttribute("noOfDays", numberOfdays);

%>

<html lang="en">

<head>
	<meta charset="utf-8">
	<title> Hulton Hotel Reservation</title>
	<meta name="description" content="Smart Health App">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<Style>	
.modal-dialog{
   position: absolute;
   left: 50%;
   /* now you must set a margin left under zero - value is a half width your window */
   margin-left: -550px;
   /* this same situation is with height - example */
   height: 450px;
   top: 50%;
   width: 40%;
   margin-top: -100px;
} 
.modal-dialog1{
   position: absolute;
   left: 70%;
   /* now you must set a margin left under zero - value is a half width your window */
   margin-left: -150px;
   alignment-adjust:auto;
   /* this same situation is with height - example */
   height: 600px;
   top: 50%;
   width: 35%;
   margin-top: -100px;
} 
</style>
</head>

<script>
     function myFunction() {
          var securitycode = document.getElementById('securityCode').value;
          if (securitycode.length>3) {
           alert("Error: cannot be more than 3 digits!");
           form.securityCode.focus();
           return false;
        }else {
           // alert("Login Successfull!!!");
            document.getElementById("CardDetailsPage.jsp").submit();
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
                  <li><a href="SearchLocation.jsp">Search Hotels</a>
         <li><a href="loginPage.jsp">LOGOUT</a>
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
            <h1 class="text-center">Card Information</h1>
        </div>
        <form class="form-horizontal" id="patientReg" method="post" action="CardDetailsPageServlet" onsubmit="return myfunction()">
       <!--  <form  action="PatientRegistration" method="post">  -->
             <div class="modal-body">
                 
                  <div class="form-group">
                <input type="hidden" name="roomNo" id="roomNo" class="form-control" value=<%=roomNo %>  />
                </div>
                 <div class="form-group">
                <input type="hidden" name="hotelID" id="hotelID" class="form-control" value=<%=hotelID %>  />
                </div>
                 <div class="form-group">
                <input type="hidden" name="roomdescription" id="roomdescription" value=<%=desc%>  />
                </div>

             
             <div class="form-group">
               Card Number:  <input type="text" name="cardnumber" id="cardnumber" required="required" class="form-control" maxlength="16" pattern="[0-9]{16}"  placeholder="Enter your Card Number"/>
                </div>

             <div class="form-group">
               Card Type: <select class="form-control" id="cardType" name="cardType">
              <option>Visa</option>
              <option>Master</option>
              <option>Discover</option>
              <option>Amex</option>
              <option>Diners Club</option>
              <option>Australian BankCard</option>
              <option>Sears Canada</option>
              <option>Carte Blanche</option>
              </select>
             </div>
              <div class="form-group">
               Name On Card: <input type="text"  name="nameOnCard" id="nameOnCard"  required="required"  class="form-control"  placeholder="Enter your name on Card"/>
                </div>
             
             <div class="form-group">
             Billing Address:<input type="text" name="billingAddress" id="billingAddress" required = "required"  class="form-control"   placeholder="Enter your billing address"/>                    
                </div>
             
             
             <div class="form-group">
                Security Code:<input type="password"  name="securityCode" id="securityCode" required="required" class="form-control" maxlength="3" pattern="[0-9]{3}"  placeholder="Enter the security code on card"/>
                </div>

            <div class="form-inline">
              Expiry Date: <select class="form-control" id="Month" name="Month">
              <option>01</option>
              <option>02</option>
              <option>03</option>
              <option>04</option>
              <option>05</option>
              <option>06</option>
              <option>07</option>
              <option>08</option>
              <option>09</option>
              <option>10</option>
              <option>11</option>
              <option>12</option>
              </select> 
              <select class="form-control" id="Year" name="Year">
             <option>2017</option>
              <option>2018</option>
              <option>2019</option>
              <option>2020</option>
              <option>2021</option>
              <option>2022</option>
              <option>2023</option>
              <option>2024</option>
              <option>2025</option>
              <option>2026</option>
              <option>2027</option>
              <option>2028</option>
              <option>2029</option>
              <option>2030</option>
              <option>2031</option>
              <option>2032</option>
              <option>2033</option>
              <option>2034</option>
              <option>2035</option>
              <option>2036</option>
              </select> 
            </div>  
                 
              <br>
               <div class="form-group">
                                              
                 <input type="submit" class="btn btn-block btn-lg btn-primary" value="Confirm and Book"/>
                
             </div>
         
             
            
         </div>
                       
                             </form>
                  

    </div>
 </div>
<div class="modal-dialog1">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="text-center">Billing Information</h1>
                            </div>
                            <form class="form-horizontal" id="billingInfo" method="post" action="" onsubmit="">
                                <!--  <form  action="PatientRegistration" method="post">  -->
                                <div class="modal-body modal-lg">
                                    <div class="form-inline" >


                                        <table  style="width:50%" cellspacing="0" cellpadding="0">
                                            <tr>
                                             <font size="5" > Reservation Details</font>
                                            </tr>
                                            <tr class="blank_row"><td>&nbsp;</td></tr>

                                            <tr>
                                                <td  width="30%" align="left"><b>Room Type</b></td>
                                                <td align="left"><%=request.getParameter("roomtype")%>&nbsp;(<%=roomdescription %>)</td> 
                                            </tr>
                                            <tr class="blank_row"><td>&nbsp;</td></tr>
                                            <tr>
                                                <td  width="40%" align="left"><b>Arrival</b></td>
                                                <td align="center"><%=session.getAttribute("date")%></td>

                                            </tr>
                                            <tr class="blank_row"><td>&nbsp;</td></tr>
                                            <tr>
                                                <td  width="40%" align="left"><b>Departure</b></td>
                                                <td align="center"><%=session.getAttribute("date1")%></td> 
                                            </tr>
                                            <tr class="blank_row"><td>&nbsp;</td></tr>
                                            <tr>
                                                <td  width="40%" align="left"><b>Number of days</b></td>
                                                <td align="center"><%=numberOfdays %></td> 
                                            </tr>
                                            <tr class="blank_row"><td>&nbsp;</td></tr>
                                         
                                           <tr>
                                                <td  width="40%" align="left"><b>Best Available Rate</b></td>
                                                <td align="center"><%=priceString %>&nbsp; USD</td> 
                                            </tr>
                                               <tr class="blank_row"><td>&nbsp;</td></tr>
                                                  <tr class="blank_row"><td>&nbsp;</td></tr>
                                             <tr>
                                                <td  width="40%" align="left"><b>Subtotal</b></td>
                                                <td align="center"><%=subtotal %> &nbsp; USD</td> 
                                            </tr>
                                             <tr>
                                                <td  width="40%" align="left"><b>Taxes & Fees </b></td>
                                                <td align="center"><%=tax %>&nbsp; USD</td> 
                                            </tr>
                                             <tr>
                                                <td  width="40%" align="left"><b> Estimated Total Cost </b></td>
                                                <td align="center"><font color="green" size="4"><b><%= total %>&nbsp; USD</b></td> 
                                            </tr>
                                        </table>

                                    </div>           
              <br>
             
                      
                                
    </div>
 </div>

  		
    <script src="https://code.jquery.com/jquery-3.1.1.js"> </script>
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
</body>	
</html> 