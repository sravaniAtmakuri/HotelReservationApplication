package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.Breakfast_ReviewBean;
import java.util.ArrayList;

public final class BreakfastRating_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<head>\n");
      out.write("\t<title>HTML5 Bar Graph Example</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<div id=\"graphDiv1\"></div>\n");
      out.write("\t\n");
      out.write("\t<!--[if IE]><script src=\"excanvas.js\"></script><![endif]-->\n");
      out.write("\t<script src=\"html5-canvas-bar-graph.js\"></script>\n");
      out.write("\t<script>(function () {\n");
      out.write("\t\n");
      out.write("\t\tfunction createCanvas(divName) {\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tvar div = document.getElementById(divName);\n");
      out.write("\t\t\tvar canvas = document.createElement('canvas');\n");
      out.write("\t\t\tdiv.appendChild(canvas);\n");
      out.write("\t\t\tif (typeof G_vmlCanvasManager != 'undefined') {\n");
      out.write("\t\t\t\tcanvas = G_vmlCanvasManager.initElement(canvas);\n");
      out.write("\t\t\t}\t\n");
      out.write("\t\t\tvar ctx = canvas.getContext(\"2d\");\n");
      out.write("\t\t\treturn ctx;\n");
      out.write("\t\t}\n");
      out.write("                \n");
      out.write("                    \n");
      out.write("            ");
       ArrayList<Breakfast_ReviewBean> list1=(ArrayList<Breakfast_ReviewBean>)session.getAttribute("list");
                   ArrayList<String>Btype=new ArrayList<String>();
                    ArrayList<Integer>Rating=new ArrayList<Integer>();
                   for(int i=0;i<list1.size();i++){
                   list1.get(i).getBType();
                   Btype.add( list1.get(i).getBType());
                   Rating.add(list1.get(i).getRating());
                    } 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                \n");
      out.write("                     \n");
      out.write("                \n");
      out.write("\t\tvar ctx = createCanvas(\"graphDiv1\");\n");
      out.write("\t\t\n");
      out.write("\t\tvar graph = new BarGraph(ctx);\n");
      out.write("\t\tgraph.maxValue = 30;\n");
      out.write("\t\tgraph.margin = 2;\n");
      out.write("\t\tgraph.colors = [\"#49a0d8\", \"#d353a0\", \"#ffc527\", \"#df4c27\"];\n");
      out.write("              \n");
      out.write("\t\tgraph.xAxisLabelArr = [");
      out.print(Btype.get(0) );
      out.write(", \"East\", \"West\", \"South\"];\n");
      out.write("\t\tsetInterval(function () {\n");
      out.write("\t\t\tgraph.update([Math.random() * 30, Math.random() * 30, Math.random() * 30, Math.random() * 30]);\n");
      out.write("\t\t}, 1000);\n");
      out.write("            }\n");
      out.write("\t\t\n");
      out.write("\t}());</script>\n");
      out.write("</body>\n");
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
