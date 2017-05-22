package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.Breakfast_ReviewBean;
import bean.Service_ReviewBean;
import bean.Room_ReservationBean;
import java.util.Enumeration;
import java.util.List;
import bean.RoomBean;
import Service.Service;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public final class BreakfastReviewConfirmation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

  
    Service service = new Service();
    String userName=(String)session.getAttribute("userName");
    List<Breakfast_ReviewBean>list=service.getBreakfastDetailswithUserName(userName);
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
String BType=request.getParameter("BType");
String hotelID=request.getParameter("hotelID");
String CID=request.getParameter("CID");
String checkInDate=request.getParameter("checkInDate");
     
session.setAttribute("BType", BType);
session.setAttribute("hotelID", hotelID);
session.setAttribute("CID", CID);
session.setAttribute("checkInDate", checkInDate);

      
      
      
    
     

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("            <title>Reservation Details Page</title>\n");
      out.write("            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("                <!-- Latest compiled and minified CSS -->\n");
      out.write("                <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("                    <!-- Optional theme -->\n");
      out.write("                    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("                        </head>\n");
      out.write("                        <style>\n");
      out.write("                            table {\n");
      out.write("                                margin-left: auto;\n");
      out.write("                                margin-right: auto;\n");
      out.write("                                border:none;\n");
      out.write("                            }\n");
      out.write("                            tr {\n");
      out.write("                                \n");
      out.write("                                text-align: center;\n");
      out.write("                            }\n");
      out.write("                            .modal-dialog1{\n");
      out.write("   position: absolute;\n");
      out.write("   left: 70%;\n");
      out.write("   /* now you must set a margin left under zero - value is a half width your window */\n");
      out.write("   margin-left: -550px;\n");
      out.write("   alignment-adjust:auto;\n");
      out.write("   /* this same situation is with height - example */\n");
      out.write("   height: 1050px;\n");
      out.write("   top: 30%;\n");
      out.write("   width: 45%;\n");
      out.write("   margin-top: -0px;\n");
      out.write("   \n");
      out.write("} \n");
      out.write("                        </style>\n");
      out.write("                        <body>\n");
      out.write("                            <nav class=\"navbar navbar-inverse navbar-fixed-top\" id=\"my-navbar\">\n");
      out.write("                                       <div class=\"container\">\n");
      out.write("\t<div class=\"navbar-header\">\n");
      out.write("\t\t\n");
      out.write("\t</div><!--navbar header-->\n");
      out.write("\t\n");
      out.write("\t<div class=\"collapse navbar-collapse\" id=\"navbar-collapse\">\n");
      out.write("\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t <h4 class=\"navbar-text\">Logged in as &nbsp;");
      out.print(session.getAttribute("userName") );
      out.write("</h4> \n");
      out.write("        </ul>\n");
      out.write("             <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("               <li><a href=\"loginPage.jsp\">Service Review</a>\n");
      out.write("               <li><a href=\"loginPage.jsp\">BreakFast Review</a>\n");
      out.write("               <li><a href=\"loginPage.jsp\">Room Review</a>\n");
      out.write("               <li><a href=\"loginPage.jsp\">LOGOUT</a>\n");
      out.write("             </ul>\n");
      out.write("  \t\t\t\n");
      out.write("  \t\t</nav> \n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div> <!-- container-->\n");
      out.write("\n");
      out.write("                            </nav> <!-- black nav bar-->\n");
      out.write("                            <!--jumbotron-->\n");
      out.write("                            <div class=\"jumbotron\" style=\"padding-bottom:0px; margin-bottom:0px\">\n");
      out.write("                                <div class=\"container text-center\">\n");
      out.write("                                    <h1>Breakfast  Review</h1>\n");
      out.write("                                    <!--<p>Using Data Mining</p>-->\n");
      out.write("                                </div>\n");
      out.write("                            </div><!-- End jumbotron-->\n");
      out.write("\n");
      out.write("    <div class=\"modal-dialog1\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("        <div class=\"modal-header\">\n");
      out.write("            <h1 class=\"text-center\">Breakfast Information</h1>\n");
      out.write("        </div>\n");
      out.write("         <form class=\"form-horizontal\" name=\"BreakfastReservation\" id=\"ServiceReservation\" action=\"BreakfastReviewConfirmationServlet\" method=\"get\" onsubmit=\"\">\n");
      out.write("             <div class=\"modal-body\" align=\"left\" >\n");
      out.write("                 <div class=\"form-inline\">\n");
      out.write("                               \n");
      out.write("                     <table width=\"150%\">\n");
      out.write("                         <tr>\n");
      out.write("                             <td style=\"color: #000\" width=\"15%\" align=\"left\"> Breakfast Type </td>\n");
      out.write("                             <td style=\"color: #000\" width=\"100%\" align=\"left\">");
      out.print(BType);
      out.write("</td>\n");
      out.write("                         </tr>\n");
      out.write("                         <tr><td>&nbsp;</td>\n");
      out.write("                             <td>&nbsp;</td></tr>\n");
      out.write("                         <tr>\n");
      out.write("                             <td style=\"color: #000\" width=\"15%\" align=\"left\"> Check-in Date </td>\n");
      out.write("                             <td style=\"color: #000\" width=\"100%\" align=\"left\">");
      out.print(checkInDate);
      out.write("</td>\n");
      out.write("                         </tr>\n");
      out.write("                          <tr><td>&nbsp;</td>\n");
      out.write("                              <td>&nbsp;</td></tr>\n");
      out.write("                       \n");
      out.write("                          <tr>\n");
      out.write("                             <td style=\"color: #000\" width=\"15%\" align=\"left\"> Rating</td>\n");
      out.write("                             <td style=\"color: #000\" width=\"90%\" align=\"left\">\n");
      out.write("                                 <!--<input type=\"text\" name=\"rating\" id=\"rating\"></input>-->\n");
      out.write("                                  <select class=\"form-control\" id=\"rating\" name=\"rating\">\n");
      out.write("                                      <option>1</option>\n");
      out.write("                                        <option>2</option>\n");
      out.write("                                    <option>3</option>\n");
      out.write("                                    <option>4</option>\n");
      out.write("                                      <option>5</option>\n");
      out.write("                                        <option>6</option>\n");
      out.write("                                    <option>7</option>\n");
      out.write("                                    <option>8</option>\n");
      out.write("                                      <option>9</option>\n");
      out.write("                                        <option>10</option>\n");
      out.write("                                   </select>\n");
      out.write("                             </td>\n");
      out.write("<!--                             <td style=\"color: #000\" width=\"50%\" align=\"left\"> 10 : Excellent<br/>\n");
      out.write("                                   5 : Average<br/>\n");
      out.write("                                   1 : Very Bad</td>-->\n");
      out.write("                         </tr>\n");
      out.write("                          <tr><td>&nbsp;</td>\n");
      out.write("                              <td>&nbsp;</td></tr>\n");
      out.write("                          \n");
      out.write("                          \n");
      out.write("                         <tr>\n");
      out.write("                             <td style=\"color: #000\" width=\"15%\" align=\"left\"> Comments</td>\n");
      out.write("                             <td style=\"color: #000\" width=\"100%\" align=\"left\"><textarea  id=\"descp\" name=\"descp\" maxlength=\"100\"  row=\"50\" style=\"min-width: 50%\" cols=\"4\"></textarea></td>\n");
      out.write("                                                                                        \n");
      out.write("                                 <!--<input type=\"text\" name=\"descp\" class=\"input-lg\"id=\"descp\"></input></td>-->\n");
      out.write("                         </tr>\n");
      out.write("                          <tr><td>&nbsp;</td>\n");
      out.write("                              <td>&nbsp;</td></tr>\n");
      out.write("                         \n");
      out.write("                         <tr><td>&nbsp;</td>\n");
      out.write("                              <td>&nbsp;</td></tr>\n");
      out.write("                          <tr>\n");
      out.write("                              <td style=\"color: #000\" width=\"30%\" align=\"center\"> \n");
      out.write("                                  <!--<input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Submit\"></input>--> \n");
      out.write("                                <input type=\"submit\" class=\"btn btn-block btn-lg btn-primary\" name=\"submit\" id=\"submit\" value=\"Submit\"/></td>\n");
      out.write("                          </tr>\n");
      out.write("                     </table>\n");
      out.write("                         \n");
      out.write("                     \n");
      out.write("                                        \n");
      out.write("                                  \n");
      out.write("                            </form>\n");
      out.write("</div>\n");
      out.write("             </div>         \n");
      out.write("                            <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\n");
      out.write("                            <!-- Latest compiled and minified JavaScript -->\n");
      out.write("                            <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\">\n");
      out.write("                            </script>\n");
      out.write("                        </body>\n");
      out.write("                        </html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
