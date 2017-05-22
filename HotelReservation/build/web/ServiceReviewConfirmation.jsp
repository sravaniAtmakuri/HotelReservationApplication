<%@page import="bean.Service_ReviewBean"%>
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
    List<Service_ReviewBean>list=service.getServiceDetailswithUserName(userName);
    session.setAttribute("reviewlist", list);
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
String SType=request.getParameter("SType");
String hotelID=request.getParameter("hotelID");
String CID=request.getParameter("CID");
String checkInDate=request.getParameter("checkInDate");
     
session.setAttribute("SType", SType);
session.setAttribute("hotelID", hotelID);
session.setAttribute("CID", CID);
session.setAttribute("checkInDate", checkInDate);
      
      
      
    
     
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        <meta charset="UTF-8">
            <title>Reservation Details Page</title>
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
                            .modal-dialog1{
   position: absolute;
   left: 70%;
   /* now you must set a margin left under zero - value is a half width your window */
   margin-left: -550px;
   alignment-adjust:auto;
   /* this same situation is with height - example */
   height: 1050px;
   top: 30%;
   width: 45%;
   margin-top: -0px;
   
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
                <li><a href="ServiceReviewPage.jsp">Service Review</a>
               <li><a href="BreakfastReviewPage.jsp">BreakFast Review</a>
               <li><a href="RoomReview.jsp">Room Review</a>
               <li><a href="loginPage.jsp">LOGOUT</a>
             </ul>
  			
  		</nav> 
                                    </div>

                                </div> <!-- container-->

                            </nav> <!-- black nav bar-->
                            <!--jumbotron-->
                            <div class="jumbotron" style="padding-bottom:0px; margin-bottom:0px">
                                <div class="container text-center">
                                    <h1>Service  Review</h1>
                                    <!--<p>Using Data Mining</p>-->
                                </div>
                            </div><!-- End jumbotron-->

    <div class="modal-dialog1">
    <div class="modal-content">
        <div class="modal-header">
            <h1 class="text-center">Service Information</h1>
        </div>
         <form class="form-horizontal" name="ServiceReservation" id="ServiceReservation" action="ServiceReviewConfirmationServlet" method="get" onsubmit="">
             <div class="modal-body" align="left" >
                 <div class="form-inline">
                               
                                       
                                               <table width="150%">
                         <tr>
                             <td style="color: #000" width="15%" align="left"> Breakfast Type </td>
                             <td style="color: #000" width="100%" align="left"><%=SType%></td>
                         </tr>
                         <tr><td>&nbsp;</td>
                             <td>&nbsp;</td></tr>
                         <tr>
                             <td style="color: #000" width="15%" align="left"> Check-in Date </td>
                             <td style="color: #000" width="100%" align="left"><%=checkInDate%></td>
                         </tr>
                          <tr><td>&nbsp;</td>
                              <td>&nbsp;</td></tr>
                       
                          <tr>
                             <td style="color: #000" width="15%" align="left"> Rating</td>
                             <td style="color: #000" width="90%" align="left">
                                 <!--<input type="text" name="rating" id="rating"></input>-->
                                  <select class="form-control" id="rating" name="rating">
                                      <option>1</option>
                                        <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                      <option>5</option>
                                        <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                      <option>9</option>
                                        <option>10</option>
                                   </select>
                             </td>
<!--                             <td style="color: #000" width="50%" align="left"> 10 : Excellent<br/>
                                   5 : Average<br/>
                                   1 : Very Bad</td>-->
                         </tr>
                          <tr><td>&nbsp;</td>
                              <td>&nbsp;</td></tr>
                          
                          
                         <tr>
                             <td style="color: #000" width="15%" align="left"> Comments</td>
                             <td style="color: #000" width="100%" align="left"><textarea  id="descp" name="descp" maxlength="100"  row="50" style="min-width: 50%" cols="4"></textarea></td>
                                                                                        
                                 <!--<input type="text" name="descp" class="input-lg"id="descp"></input></td>-->
                         </tr>
                          <tr><td>&nbsp;</td>
                              <td>&nbsp;</td></tr>
                         
                         <tr><td>&nbsp;</td>
                              <td>&nbsp;</td></tr>
                          <tr>
                              <td style="color: #000" width="30%" align="center"> 
                                  <!--<input type="submit" name="submit" id="submit" value="Submit"></input>--> 
                                <input type="submit" class="btn btn-block btn-lg btn-primary" name="submit" id="submit" value="Submit"/></td>
                          </tr>
                     </table>
                         
                     
                                        
                                  
                            </form>
</div>
             </div>
                            <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
                            <!-- Latest compiled and minified JavaScript -->
                            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
                            </script>
                        </body>
                        </html>