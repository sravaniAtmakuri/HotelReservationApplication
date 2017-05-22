package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;

public final class StatisticsPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<title> Hulton Hotel Reservation</title>\n");
      out.write("\t<meta name=\"description\" content=\"Smart Health App\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("<!-- Optional theme -->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\">\n");
      out.write("\t\n");
      out.write("</head>\n");
      out.write("\t\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    function myFunction(form) {\n");
      out.write("           if (form.Location.value==\"\") {\n");
      out.write("           alert(\"Please enter Location!\");\n");
      out.write("           form.Location.focus();\n");
      out.write("           return false;\n");
      out.write("        }\n");
      out.write("           if(form.checkIndate.value==\"\"){\n");
      out.write("            alert(\"Please enter CheckIn Date!\");\n");
      out.write("            form.checkIndate.focus();  \n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("        if(form.checkOutdate.value==\"\"){\n");
      out.write("            alert(\"Please enter CheckOut Date!\");\n");
      out.write("            form.checkOutdate.focus();  \n");
      out.write("            return false;\n");
      out.write("        }\n");
      out.write("        else {\n");
      out.write("          //  alert(\"Login Successfull!!!\");\n");
      out.write("            document.getElementById(\"SearchLocation\").submit();\n");
      out.write("            return true;\n");
      out.write("        }\n");
      out.write("    \n");
      out.write("    }\n");
      out.write("</script>\t\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("  \t\t<nav class= \"navbar navbar-inverse navbar-fixed-top\" id=\"my-navbar\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("\t<div class=\"navbar-header\">\n");
      out.write("\t\t\n");
      out.write("\t</div><!--navbar header-->\n");
      out.write("\t\n");
      out.write("\t<div class=\"collapse navbar-collapse\" id=\"navbar-collapse\">\n");
      out.write("\t\n");
      out.write("             <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("         <li><a href=\"HomePage.jsp\">HomePage</a>\n");
      out.write("          \n");
      out.write("             </ul>\n");
      out.write("  \t\t\t\n");
      out.write("  \t\t</nav> \n");
      out.write("\n");
      out.write("  \t\t\n");
      out.write("                    <div class=\"jumbotron\">\n");
      out.write("\t\t\t<div class=\"container text-center\" style=\"max-height: 100px\">\n");
      out.write("                            <h1> HULTON HOTEL STATISTICS </h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t     </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" <div class=\"modal-dialog modal-lg\" >\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("        <div class=\"modal-header\">\n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("         <form  action=\"StatisticsServlet\" method=\"post\" id=\"loginPage\" onsubmit=\" \">\n");
      out.write("             <p style=\"color: red\">\n");
      out.write("                                    ");

                                        String message1=request.getParameter("message1");
                                        if(message1!=null)
                                        {
      out.write("\n");
      out.write("                                   ");
 out.println(request.getParameter("message1")); 
      out.write("\n");
      out.write("                                     ");
 }
                                    
      out.write("\n");
      out.write("                                </p>\n");
      out.write("                                <p style=\"color: green\">\n");
      out.write("                                    ");

                                        String message2=request.getParameter("message2");
                                        if(message2!=null)
                                        {
      out.write("\n");
      out.write("                                        ");
      out.print(message2);
      out.write("\n");
      out.write("                                     ");
 }
                                    
      out.write("\n");
      out.write("                                </p>\n");
      out.write("         <div   class=\"modal-body  modal-dialog modal-lg form-inline\">\n");
      out.write("             \n");
      out.write("                 <div class=\"form-group\" class=\"input-group-addon\">\n");
      out.write("                 <h3> Start Date</h3>\n");
      out.write("                 <i class=\"fa fa-calendar\">\n");
      out.write("                 </i>   \n");
      out.write("                 <input class=\"form-control input-lg\" id=\"date\" required=\"required\" name=\"date\" placeholder=\"YYYY-MM-DD\" type=\"date\"/>              \n");
      out.write("             </div>\n");
      out.write("             <div class=\"form-group\" class=\"input-group-addon\">\n");
      out.write("                 <h3> End Date</h3>\n");
      out.write("                 <i class=\"fa fa-calendar\">\n");
      out.write("                 </i>   \n");
      out.write("                 <input class=\"form-control input-lg\" id=\"date1\" required=\"required\" name=\"date1\" placeholder=\"YYYY-MM-DD\" type=\"date1\"/>              \n");
      out.write("                               \n");
      out.write("             </div>\n");
      out.write("            <hr/>\n");
      out.write("             <div class=\"form-group\" class=\"input-group-addon\">\n");
      out.write("                  <input  id=\"option\" type=\"radio\" name=\"option\" value=\"rtype\"/>\n");
      out.write("            <label  for=\"rated_room\"> Compute the highest rated room type for each hotel </label>\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <input  id=\"option\" type=\"radio\" name=\"option\" value=\"top5\" />\n");
      out.write("            <label  for=\"topcust\"> Compute the top 5 customer </label>\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <input id=\"option\" type=\"radio\" name=\"option\" value=\"btype\" />\n");
      out.write("            <label  for=\"rated_bkfst\"> Compute the highest rated breakfast type across all hotels </label>\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <input id=\"option\" type=\"radio\" name=\"option\" value=\"stype\" />\n");
      out.write("            <label  for=\"rated_service\"> Compute the highest rated service type across all hotels </label>\n");
      out.write("            <br>\n");
      out.write("            <br>         \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("             <div class=\"form-group\" class=\"input-group-addon \">\n");
      out.write("                \n");
      out.write("                 \n");
      out.write("                 <input type=\"submit\" class=\"btn btn-block btn-lg btn-primary\" value=\"Submit\"/>\n");
      out.write("                 <!--<span class=\"pull-right\"><a href=\"RegistrationPage.jsp\">Register</a></span><span><a href=\"ForgotPassswordPage.jsp\">Forgot Password</a></span>-->\n");
      out.write("\n");
      out.write("             </div>\n");
      out.write("         </div>\n");
      out.write("       </form>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write(" </div>\n");
      out.write("\n");
      out.write("  \t\t\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.1.1.js\"> </script>\n");
      out.write("  \n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"> </script>\n");
      out.write("  <!-- Include Date Range Picker -->\n");
      out.write("<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css\"/>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function(){\n");
      out.write("        var date_input=$('input[name=\"date\"]'); //our date input has the name \"date\"\n");
      out.write("        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : \"body\";\n");
      out.write("        date_input.datepicker({\n");
      out.write("            format: 'yyyy-mm-dd',\n");
      out.write("            container: container,\n");
      out.write("            todayHighlight: true,\n");
      out.write("            autoclose: true,\n");
      out.write("            onSelect: function(){\n");
      out.write("                  var date = $(this).datepicker('getDate');\n");
      out.write("                  document.getElementById(\"date\").value=date;\n");
      out.write("              }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("</script>\n");
      out.write("\n");
      out.write(" <script src=\"https://code.jquery.com/jquery-3.1.1.js\"> </script>\n");
      out.write("  \n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"> </script>\n");
      out.write("  <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-1.11.3.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- Include Date Range Picker -->\n");
      out.write("<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css\"/>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function(){\n");
      out.write("        var date_input=$('input[name=\"date1\"]'); //our date input has the name \"date\"\n");
      out.write("        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : \"body\";\n");
      out.write("        date_input.datepicker({\n");
      out.write("            format: 'yyyy-mm-dd',\n");
      out.write("            container: container,\n");
      out.write("            todayHighlight: true,\n");
      out.write("            autoclose: true,\n");
      out.write("            onSelect: function(){\n");
      out.write("                  var date = $(this).datepicker('getDate');\n");
      out.write("                  document.getElementById(\"date1\").value=date;\n");
      out.write("              }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("</script>\n");
      out.write("</body>\t\n");
      out.write("</html> ");
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
