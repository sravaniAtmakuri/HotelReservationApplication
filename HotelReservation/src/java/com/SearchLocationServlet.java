
package com;

import Service.Service;
import bean.HotelBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchLocationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<HotelBean> list = new ArrayList<HotelBean>();
        System.out.println("inside the SearchLocationServlet!!");
        HttpSession session = request.getSession();

        String location = request.getParameter("Location");
        String indate = request.getParameter("date");
        String outdate=request.getParameter("date1");
        
        
        System.out.println(location + "\t" + indate);

        session.setAttribute("Location", location);
        Service service = new Service();
        list = service.findLocation(location);
        
        if(list.size()>0){
            System.out.println("inside if Searchlocation\t"+request.getParameter("Location"));
             request.setAttribute("ListofHotels", list);
            request.setAttribute("Location", request.getParameter("Location"));
            session.setAttribute("date", request.getParameter("date"));
            session.setAttribute("date1", request.getParameter("date1"));
            
            getServletConfig().getServletContext().getRequestDispatcher("/ListofHotels.jsp").forward(request,response);
//       getServletConfig().getServletContext().getRequestDispatcher("/List.jsp").forward(request,response);

        } else {
            System.out.println("inside else in LoginServlet");
            String message = "Location not found";
            response.sendRedirect("SearchLocation.jsp?message1=" + message);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
