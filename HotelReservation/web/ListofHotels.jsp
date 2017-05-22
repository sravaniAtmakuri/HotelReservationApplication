<%@page import="java.sql.Array"%>
<%@page import="java.util.List"%>
<%@page import="bean.HotelBean"%>
<%@page import="Service.Service" %>
<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.http.HttpServlet" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.util.ArrayList" %>
 <% ArrayList<HotelBean> list = (ArrayList<HotelBean>) request.getAttribute("ListofHotels");
 ArrayList<String> images=new ArrayList<String>();
 images.add("images/Hotel.jpg");
 images.add("images/Hotel2.jpg");
 images.add("images/HotelPool.jpg");
 images.add("images/Image1.jpeg");
 images.add("images/Image2.jpeg");
 
 
 
 %>
 <script> 
 function randomImg(){
    var randomNumber = Math.floor(Math.random() * 5) + 1;
    var imgName = "" + randomNumber + ".jpeg";
    document.getElementById("imageid").src= "images" + "/" + imgName ;
    return imgName;
 }
 </script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        <meta charset="UTF-8">
            <title>Hulton Hotel Reservation</title>
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
  			
                            </nav> <!-- black nav bar-->
                            <!--jumbotron-->
                            <div class="jumbotron" style="padding-bottom:0px; margin-bottom:0px">
                                <div class="container text-center">
                                    <h1>Hotels in <%= list.get(0).getState() %></h1>
                                    <!--<p>Using Data Mining</p>-->
                                </div>
                            </div><!-- End jumbotron-->


                              <form  action="ListofHotelsServlet" method="post" id="loginPage" onload="randomImg()">

                                <fieldset class="row1">
                                    <legend style="color: #066A75">
                                    </legend>
                                    <table  style="width:80%" cellspacing="0" cellpadding="0">
                                        <tr></tr>
                                        <%
                                            for (int i = 0; i < list.size(); i++) {
                                                HotelBean bean = list.get(i);
                                        %>
                                         
                                        <tr>
                                            <td style width="30%"><div class="img"><img id="imageid" src="<%=images.get(i)%>" width="250" height="150"></img></div></td>
                                            <td style="color: #000" width="30%"><div>Hulton Hotel</div> <div><%=bean.getStreet()%></div><div><%=bean.getState()%> ,&nbsp;<%=bean.getZip()%></div></td>
                                            <td style="color: #000" width="10%"><a href="ListofRooms.jsp?messageStreet=<%=bean.getStreet()%>&zip=<%=bean.getZip()%>">Book</a></td>
                                        </tr>
                                        <tr class="blank_row">
                                             <td bgcolor="#FFFFFF" colspan="3"><hr size="40"></hr></td>
                                       </tr>
                                        <% }%>
                                    </table> 
                                </fieldset>
                            </form>
                            <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
                            <!-- Latest compiled and minified JavaScript -->
                            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
                            </script>
                        </body>
                        </html>
