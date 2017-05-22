<%@page import="java.util.Enumeration"%>
<%@page import="bean.BreakfastBean"%>
<%@page import="bean.ServiceBean"%>
<%@page import="bean.Room_ReservationBean"%>
<!DOCTYPE html>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.util.List"%>
<%@page import="Service.Service" %>
<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.http.HttpServlet" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.util.ArrayList" %>

<% 
        Service service = new Service();
   // String location=request.getParameter("location");
   
    String userName = (String)session.getAttribute("userName");
   
 
 //    List<RoomReservationBean> list = (List<RoomReservationBean>)session.getAttribute("list");
        String id= request.getParameter("hotelID");
        if( id == null){
       
       
            id=(String) session.getAttribute("hotelID");
        }
      int hotelID = Integer.parseInt(id);
     
     List<BreakfastBean> breakfastList = service.getBreakfastDetails(hotelID);
  //   List<ServiceBean> serviceList = service.getServiceDetails(hotelID);
  
String str = request.getRequestURL() + "?";
    Enumeration<String> paramNames = request.getParameterNames();

    while (paramNames.hasMoreElements()) {
        String paramName = paramNames.nextElement();
        System.out.println("" + paramName);
        String[] paramValues = request.getParameterValues(paramName);
        //   System.out.println(""+pa2ramValues.length);
        for (int i = 0; i < paramValues.length; i++) {
            String paramValue = paramValues[i];
            System.out.println("" + paramValue);
            str = str + paramName + "=" + paramValue;
        }
        str = str + "&";
    }
    System.out.println(str.substring(0, str.length() - 1) + "\t");
    System.out.println(request.getParameter("hotelID"));
    System.out.println(request.getParameter("invoiceNo"));
    
   session.setAttribute("hotelID", request.getParameter("hotelID"));
   session.setAttribute("invoiceNo", request.getParameter("invoiceNo"));
   session.setAttribute("message1", request.getParameter("message1"));
  //int capacity= (int)session.getAttribute("capacity");
%>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title> Hulton Hotel Reservation</title>
        <meta name="description" content="Smart Health App">


        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
        <style>	
/*            .modal-dialog{
                position: absolute;
                left: 50%;
                 now you must set a margin left under zero - value is a half width your window 
                margin-left: -550px;
                 this same situation is with height - example 
                height: 450px;
                top: 50%;
                width: 40%;
                margin-top: -100px;
            } */
           
        </style>
        
    </head>

    
       <script language="javascript" type="text/javascript">

  
 
    </script>	
    <body>
 <nav class= "navbar navbar-inverse navbar-fixed-top" id="my-navbar">
            <div class="container">
                <div class="navbar-header">

                </div><!--navbar header-->

                <div class="collapse navbar-collapse" id="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <h4 class="navbar-text">Logged in as &nbsp;<%=session.getAttribute("userName")%></h4> 
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                         <li><a href="SearchLocation.jsp">Search Hotels</a>
                         <li><a href="ReservationDetails.jsp">Reservation Details</a>
                        <li><a href="loginPage.jsp">LOGOUT</a>
                           
                    </ul>

                    </nav> 



                    <div class="jumbotron">
                       &nbsp;
                    </div>


                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="text-center">Breakfast details</h1>
                            </div>
                            <form  action="BreakfastServlet" method="post" id="ServiceReservePage" onsubmit=" return myFunction(this)">
                                <!--<form class="form-horizontal" id="patientReg" method="post" action="" onsubmit="">-->
                                <!--  <form  action="PatientRegistration" method="post">  -->
                                
                                 <p style="color: red">
                                    <%
                                        String message1=(String)session.getAttribute("message1");
                                        if(message1!=null)
                                        {
                                             out.println(message1); 
                                      }
                                    %>
                                </p>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <table style="width:80%">
                                            <tr>
                                             <font size="5" >Breakfast provided by Hotel</font>
                                            </tr>
                                             <tr class="blank_row"><td>&nbsp;</td></tr>
                                            <tr>
                                            <th>Breakfast Type </th>
                                            <th> Description</th>
                                            <th>Quantity</th>
                                            <th> Price</th>
                                            <th>&nbsp;</th>
                                            </tr>
                                             <tr class="blank_row"><td>&nbsp;</td></tr>
                                            
                                             <%
                                            for (int i = 0; i < breakfastList.size(); i++) {
                                              
                                                BreakfastBean bean = breakfastList.get(i);
                                                
                                                
                                                 %>
                                            
                                                 <tr>
                                                     <td  width="5%" align="left"> <%=breakfastList.get(i).getBType()%></td>
                                                <td  width="20%" align="left"><%=breakfastList.get(i).getDescription()%></td>
                                                <td  width=5%" align="left">
                                                    <div class="form-inline">
                                                 <select class="form-control" id="Quantity"  name="Quantity" >
                                           <option value="0">0</option>
                                           <option value="1">1</option>
                                           <option value="2">2</option>
                                           <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                           
                                        </select> 
                                           
                                                </td>
                                                <td width="5%" align="left"><b>$ </b><%=breakfastList.get(i).getBPrice()%></td> 
                                                
                                                  
                                                <td width="1%" align="left">   <input type="checkbox" id="Btype" name="Btype" value="<%=breakfastList.get(i).getBType()%>,<%=breakfastList.get(i).getBPrice()%>"> </td>
                                            </tr>
                                            <tr class="blank_row"><td>&nbsp;</td></tr>
                                             
                                                
                                        <%}%>
                                        </table>
                                     
                                    </div>
                            
                                    <div class="form-group">

                                        <input type="submit" class="btn btn-block btn-lg btn-primary" value="Reserve"/>

                                    </div>
                                </div>
                            </form>
                                      

                        </div>
                    </div>
                        <script src="https://code.jquery.com/jquery-3.1.1.js"></script>

                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
                        </body>	
                        </html> 