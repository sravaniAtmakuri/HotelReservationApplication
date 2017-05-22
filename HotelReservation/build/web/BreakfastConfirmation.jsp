<%@page import="java.util.List"%>
<%@page import="bean.Credit_CardBean"%>
<%@page import="bean.Room_ReservationBean"%>
<%@page import="bean.ReservationBean"%>
<!DOCTYPE html>
<%@page import="javax.servlet.http.HttpSession" %>

<% 

String invoiceNo = request.getParameter("invoiceNo");

List<String> breakfasttype =(List<String>) session.getAttribute("BType");
List<String> breakfastPrice = (List<String>)session.getAttribute("BPrice");
List<String> quantity= (List<String>)session.getAttribute("quantities");

int sum=0;
for(int i=0;i<breakfastPrice.size();i++){
    sum=sum+(Integer.parseInt(breakfastPrice.get(i))*Integer.parseInt(quantity.get(i)));
}

String roomTotalAmount = (String)session.getAttribute("totalAmount");

System.out.println("Room total Amount\t"+roomTotalAmount+"\t\t"+request.getAttribute("roomtotalAmount"));
%>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title> Breakfast Confirmation Page</title>
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
                  <li><a href="SearchLocation.jsp">Search Hotels</a>
         <li><a href="loginPage.jsp">LOGOUT</a>
             </ul>
  			
  		</nav> 

  		

  		<div class="jumbotron">
<!--			<div class="container text-center" style="max-height: 100px">
                            <h1>Your Booking is done</h1>
			</div>-->
		</div>


 <div class="modal-dialog modal-lg" >
    <div class="modal-content">
        <div class="modal-header">
          <h4>Booking ID : <%=invoiceNo%>  
        </div>
         <!--<form  action="SearchLocationServlet" method="post" id="loginPage" onsubmit=" return myFunction(this)">-->
             <p style="color: red">
                                   
                                </p>
         <div   class="modal-body  modal-dialog modal-lg form-inline">
             
             <div class="form-group">
                <h3> Breakfast Selected  </h3>
                 <!--<input type="search" id="Location" name="Location" placeholder="location" class="form-control input-lg"/>-->
                 <fieldset class="row1">
                                    <legend style="color: #066A75">
                                    </legend>
                                    <table  style="width:70%" cellspacing="0" cellpadding="0">
                                        
                                        <tr>
                                            <th>Breakfast </th>
                                            <th>Quantity </th>
                                            <th> Price</th>
                                        </tr>
                                         <tr><td>&nbsp;</td></tr>
                                        <% for(int i=0;i<breakfasttype.size();i++){%>
                                        <tr>
                                           
                                            <td style="color: #000" width="10%" align="left"><%=breakfasttype.get(i)%></td> 
                                            <td style="color: #000" width="10%" align="left"><%=quantity.get(i)%></td> 
                                            <% int total = (Integer.parseInt(breakfastPrice.get(i)))*(Integer.parseInt(quantity.get(i)));%>
                                            <td style="color: #000" width="10%" align="left"><b>$&nbsp;</b><%=total%>  </td>
                                            
                                          
                                        </tr>
                                         <tr>
                                                <tr class="blank_row">
                                                    <td bgcolor="#FFFFFF" colspan="4">&nbsp;</td>
                                       </tr>
                                        
                                          <%}%>
                                          <td>&nbsp;</td>
                                              <td tyle="color: #000" width="10%" align="left">Total</td>
                                              <td style="color: #000" width="10%" align="left"><b>$ </b><%=sum%></td>
                                                 
                                          </tr>    
                                      
                                       
                                        
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