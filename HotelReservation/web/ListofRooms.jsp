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
   String str=request.getRequestURL()+"?";
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

    Service service = new Service();
   // String location=request.getParameter("location");
    String location = (String) session.getAttribute("Location");
      String street = request.getParameter("messageStreet");
      String zip=request.getParameter("zip");
      System.out.println("zip is: "+zip);
      session.setAttribute("zip", zip);
      session.setAttribute("street", street);
            
      String checkInDate=(String)session.getAttribute("date");
      String checkOutDate=(String)session.getAttribute("date1");
      System.out.println("checkIn and checkOut Dates are:"+checkInDate+"  "+checkOutDate);
      System.out.println(""+street);
      
      
      
      List<RoomBean> roomList = service.findRoomsDetails(location,street,checkInDate,checkOutDate);
     
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        <meta charset="UTF-8">
            <title>Doctor Result</title>
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
                                    <h1>Rooms in <%=location%></h1>
                                    <!--<p>Using Data Mining</p>-->
                                </div>
                            </div><!-- End jumbotron-->

                            <!--<span style="text-align: center"><h2>Appointment Details</h2></span>--> 
                            <form  name="ListofRooms" id="" action="ListofHotelsServlet" method="get" onsubmit="">
                                <fieldset class="row1">
                                    <legend style="color: #066A75">
                                    </legend>
                                    <table  style="width:80%" cellspacing="0" cellpadding="0">
                                        
                                        <tr></tr>
                                        <%
                                            for (int i = 0; i < roomList.size(); i++) {
                                                if((roomList.get(i).getAvailability())==null){
                                                    System.out.println("inside the if in list of romms jsp and i value is: "+i);
                                                RoomBean bean = roomList.get(i);
                                                
                                        %>
                                        
                                          <tr>
                                              
                                              <% if(roomList.get(i).getRoomType().equalsIgnoreCase("Standard")){ %>
                                              <td><div class="img"><img src="images/sd.jpg" width="140" height="100"> </img></div>
                                                  <p>Maximum Occupancy : <%=bean.getCapacity()%></p>
                                              </td>
                                              <% } else if(roomList.get(i).getRoomType().equalsIgnoreCase("Double")){%>
                                                  <td><div class="img"><img src="images/db1.jpg" width="140" height="100"> </img></div>
                                                   <p>Maximum Occupancy : <%=bean.getCapacity()%></p>
                                                  </td>    
                                               <% } else if(roomList.get(i).getRoomType().equalsIgnoreCase("Deluxe")){%>
                                               <td><div class="img"><img src="images/del1.jpg" width="140" height="100"> </img></div>
                                                    <p>Maximum Occupancy : <%=bean.getCapacity()%></p>
                                               </td> 
                                                <% } else if(roomList.get(i).getRoomType().equalsIgnoreCase("Suite")){%>
                                               <td><div class="img"><img src="images/suite1.jpg" width="140" height="100"> </img></div>
                                                <p>Maximum Occupancy : <%=bean.getCapacity()%></p>
                                               </td> 
                                              <%}%>
                                              
                                              
                                            <td style="color: #000" width="40%" align="left"><div><%=bean.getRoomType()%></div> <div><%=bean.getDescription()%></div></td>
                                            <% if(roomList.get(i).getDiscountedPrice()==0){ %>
                                            <td style="color: #000" width="30%"><div>$<%=roomList.get(i).getPrice()%></div><div>per night</div><a href="CardDetailsPage.jsp?messageroomNo=<%=bean.getRoomNo()%>&HotelID=<%=bean.getHotelID()%>&Price=<%=bean.getPrice() %>&description=<%=bean.getDescription()%>&roomtype=<%=bean.getRoomType() %>">Book</a> </td> 
                                           
                                             <%                                                     } 
                                              else{ %>
                                             <td style="color: #000" width="30%"><div><strike>$<%=roomList.get(i).getPrice()%></strike>&nbsp;&nbsp;$<%=roomList.get(i).getDiscountedPrice() %></div><div>per night</div><a href="CardDetailsPage.jsp?messageroomNo=<%=bean.getRoomNo()%>&HotelID=<%=bean.getHotelID()%>&Price=<%=bean.getDiscountedPrice()%>&description=<%=bean.getDescription()%>">Book</a></td>
                                             <% session.setAttribute("roomBean",roomList.get(i));} %>
                                          </tr> 
                                        <tr class="blank_row">
                                             <td bgcolor="#FFFFFF" colspan="3"><hr size="40"></hr></td>
                                       </tr>
                                       
                                        <% }}%>
                                    </table> 
                                </fieldset>
                            </form>
                            <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
                            <!-- Latest compiled and minified JavaScript -->
                            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
                            </script>
                        </body>
                        </html>