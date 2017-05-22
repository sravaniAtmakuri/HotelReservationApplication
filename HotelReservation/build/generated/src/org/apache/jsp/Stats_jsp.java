package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Stats_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Hulton Hotel Statistics</title>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validate(form)\n");
      out.write("            {\n");
      out.write("                \n");
      out.write("                var op = document.querySelector('input[name = \"option\"]:checked').value;\n");
      out.write("                var start = document.getElementById(\"start\");\n");
      out.write("                var end = document.getElementById(\"end\");\n");
      out.write("                \n");
      out.write("                if(start.value >= end.value)\n");
      out.write("                {\n");
      out.write("                    alert(\"Start date cannot be after end date!\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                           \n");
      out.write("   \n");
      out.write("                if ((op !== \"op1\") && (op !== \"op2\") && (op !== \"op3\") && (op !== \"op4\"))\n");
      out.write("                {\n");
      out.write("                    alert(\"You need to select at least one option\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    \n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <h1>Hulton Hotel Statistics</h1>\n");
      out.write("        <br>\n");
      out.write("        <form method=\"get\" action=\"Result1.jsp\" onsubmit=\"return validate(this)\" >\n");
      out.write("            Start Date &nbsp; &nbsp; \n");
      out.write("            <input \n");
      out.write("                type=\"date\" name=\"start_date\" id=\"start\" required />\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            End Date  &nbsp; &nbsp; &nbsp; \n");
      out.write("            <input type=\"date\" name=\"end_date\" id=\"end\" required />\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <table>\n");
      out.write("            <input  id=\"rated_room\" type=\"radio\" name=\"option\" value=\"op1\"/>\n");
      out.write("            <label  for=\"rated_room\"> Compute the highest rated room type for each hotel </label>\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <input  id=\"topcust\" type=\"radio\" name=\"option\" value=\"op2\" />\n");
      out.write("            <label  for=\"topcust\"> Compute the top 5 customer </label>\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <input id=\"rated_bkfst\" type=\"radio\" name=\"option\" value=\"op3\" />\n");
      out.write("            <label  for=\"rated_bkfst\"> Compute the highest rated breakfast type across all hotels </label>\n");
      out.write("            <br>\n");
      out.write("            \n");
      out.write("            <input id=\"rated_service\" type=\"radio\" name=\"option\" value=\"op4\" />\n");
      out.write("            <label  for=\"rated_service\"> Compute the highest rated service type across all hotels </label>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"submit\" name=\"submit\" value=\"Submit\" id=\"submit\" />\n");
      out.write("           \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
