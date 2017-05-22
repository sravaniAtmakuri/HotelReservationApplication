<%@page import="bean.Room_ReservationBean"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@page import="bean.RoomBean"%>
<%@page import="Service.Service" %>
<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.http.HttpServlet" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.util.ArrayList" %>



<%
  
    Service service = new Service();
    String userName=(String)session.getAttribute("userName");
    List<Room_ReservationBean>list=service.getRoomReservationDetails(userName);
    String message=request.getParameter("message");
     session.setAttribute("RoomReservationlist", list);
    
      
      
      
    
     
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        <meta charset="UTF-8">
            <title>Room Review Page</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <!-- Latest compiled and minified CSS -->
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

                    <!-- Optional theme -->
                    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

                        </head>
                        <style>
                            table {
                                margin-left: auto;
                                margin-right: auto;
                                border:none;
                            }
                            tr {
                                
                                text-align: center;
                            }
                        </style>
                        <body>
                            <nav class="navbar navbar-inverse navbar-fixed-top" id="my-navbar">
                                       <div class="container">
	<div class="navbar-header">
		
	</div><!--navbar header-->
	
	<div class="collapse navbar-collapse" id="navbar-collapse">
	<ul class="nav navbar-nav">
	 <h4 class="navbar-text">Logged in as &nbsp;<%=session.getAttribute("userName") %></h4> 
        </ul>
             <ul class="nav navbar-nav navbar-right">
               <li><a href="ServiceReviewPage.jsp">Service Review</a>
               <li><a href="loginPage.jsp">BreakFast Review</a>
               <li><a href="SearchLocation.jsp">Search Hotels</a>
               <li><a href="loginPage.jsp">LOGOUT</a>
             </ul>
  			
  		</nav> 
                                    </div>

                                </div> <!-- container-->

                            </nav> <!-- black nav bar-->
                            <!--jumbotron-->
                            <div class="jumbotron" style="padding-bottom:0px; margin-bottom:0px">
                                <div class="container text-center">
                                    <h1>Room Reservation Details</h1>
                                    <!--<p>Using Data Mining</p>-->
                                </div>
                            </div><!-- End jumbotron-->

                            <!--<span style="text-align: center"><h2>Appointment Details</h2></span>--> 
                            <form  name="ListofRooms" id="" action="ListofHotelsServlet" method="get" onsubmit="">
                               <div><% if(message !=null){ %>
                                       <h2 style="color: green">    <%=message %></h2>
                                          <% } %></div>
                                <fieldset class="row1">
                                    <legend style="color: #066A75">
                                    </legend>
                                    <table  style="width:80%" cellspacing="0" cellpadding="0">
                                        
                                        <tr>
                                            <th>CID</th>
                                              <th >InvoiceNo</th>
                                              <th >CheckInDate</th>
                                              <th >CheckOutDate</th>
                                         
                                              
                                        </tr>

                                        <tr><td>&nbsp;</td></tr>
                                        <tr><td>&nbsp;</td></tr>
                                        <%
                                            for (int i = 0; i < list.size(); i++) {
                                                System.out.println("inside the if in list of romms jsp and i value is: "+i);
                                                Room_ReservationBean bean = list.get(i);
                                                
                                        %>
                                        
                                          <tr>
                                              <td style="color: #000" width="20%" align="left"><div><%=bean.getCID()%></div></td>
                                              <td style="color: #000" width="20%" align="left"><div><%=bean.getInvoiceNo()%></div></td>
                                              <td style="color: #000" width="20%" align="left"><div><%=bean.getCheckInDate()%></div></td>
                                              <td style="color: #000" width="20%" align="left"><div><%=bean.getCheckOutDate()%></div></td>
                                              
                                              <td style="color: #000" width="10%">
                                                  <div><a href="RoomReviewConfirmation.jsp?hotelID=<%=bean.getHotelID()%>&invoiceNo=<%=bean.getInvoiceNo() %>&CID=<%=bean.getCID()%>&RoomNo=<%=bean.getRoomNo()%>"/></div>Submit Room Review
                                                 <tr class="blank_row">
                                             <td bgcolor="#FFFFFF" colspan="5"><hr size="40"></hr></td>
                                       </tr>
                                                 
                                              <% }  %>
                                            
                                          </tr> 
                                      
                                       
                                        
                                    </table> 
                                </fieldset>
                            </form>
                            <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
                            <!-- Latest compiled and minified JavaScript -->
                            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
                            </script>
                        </body>
                        </html>