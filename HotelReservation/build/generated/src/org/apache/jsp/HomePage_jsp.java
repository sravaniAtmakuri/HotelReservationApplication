package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<title>Hulton Hotel Welcome Page</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".carousel{\n");
      out.write("    background: #2f4357;\n");
      out.write("    margin-top: 20px;\n");
      out.write("}\n");
      out.write(".carousel .item img{\n");
      out.write("    margin: 0 auto; /* Align slide image horizontally center */\n");
      out.write("}\n");
      out.write(".bs-example{\n");
      out.write("\tmargin: 20px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <nav class= \"navbar navbar-inverse navbar-fixed-top\" id=\"my-navbar\">\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbar-collapse\">\n");
      out.write("\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t <h4 class=\"navbar-text\">WELCOME TO HULTON HOTEL</h4> \n");
      out.write("        </ul>\n");
      out.write("             <ul class=\"nav navbar-nav \">\n");
      out.write("         <li><a href=\"loginPage.jsp\">SIGN IN</a>\n");
      out.write("             <li><a href=\"StatisticsPage.jsp\">STATISTICS</a>\n");
      out.write("             </ul>\n");
      out.write("  \t\t\t\n");
      out.write("  \t\t</nav> \n");
      out.write("\n");
      out.write("  \t\t\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("<div class=\"container shadow\" style=\"background-color:window;min-width:950px;width:100%\">\n");
      out.write("  <br>\n");
      out.write("  <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("    <!-- Indicators -->\n");
      out.write("    <ol class=\"carousel-indicators\">\n");
      out.write("      <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("      <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\n");
      out.write("      <li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\n");
      out.write("      <li data-target=\"#myCarousel\" data-slide-to=\"3\"></li>\n");
      out.write("       <li data-target=\"#myCarousel\" data-slide-to=\"4\"></li>\n");
      out.write("        <li data-target=\"#myCarousel\" data-slide-to=\"5\"></li>\n");
      out.write("    </ol>\n");
      out.write("\n");
      out.write("    <!-- Wrapper for slides -->\n");
      out.write("    <div class=\"carousel-inner\" role=\"listbox\">\n");
      out.write("\n");
      out.write("      <div class=\"item active\">\n");
      out.write("        <img src=\"images/Hotel.jpg\" style=\"width:100%;height:600px\">\n");
      out.write("        <div class=\"carousel-caption\" style=\"text-align:left\">\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"item\">\n");
      out.write("        <img src=\"images/Hotel2.jpg\" style=\"width:100%;height:600px\">\n");
      out.write("        <div class=\"carousel-caption\">\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("        <div class=\"item\">\n");
      out.write("        <img src=\"images/HotelPool.jpg\" style=\"width:100%;height:600px\">\n");
      out.write("        <div class=\"carousel-caption\">\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    \n");
      out.write("      <div class=\"item\">\n");
      out.write("        <img src=\"images/AccessRoom.jpg\" style=\"width:100%;height:600px\">\n");
      out.write("        <div class=\"carousel-caption\">\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"item\">\n");
      out.write("        <img src=\"images/DeluxeRoom.jpg\" style=\"width:100%;height:600px \">\n");
      out.write("        <div class=\"carousel-caption\" style=\"text-align:right\">\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("         <div class=\"item\">\n");
      out.write("        <img src=\"images/gym.jpg\" style=\"width:100%;height:600px \">\n");
      out.write("        <div class=\"carousel-caption\" style=\"text-align:right\">\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("  \n");
      out.write("    <!--</div>-->\n");
      out.write("\n");
      out.write("    <!-- Left and right controls -->\n");
      out.write("    <a class=\"left carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"prev\">\n");
      out.write("      <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n");
      out.write("      <span class=\"sr-only\">Previous</span>\n");
      out.write("    </a>\n");
      out.write("    <a class=\"right carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"next\">\n");
      out.write("      <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n");
      out.write("      <span class=\"sr-only\">Next</span>\n");
      out.write("    </a>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write(" <script language=\"JavaScript\" type=\"text/javascript\"></script>\n");
      out.write("</html>                                \t\t");
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
