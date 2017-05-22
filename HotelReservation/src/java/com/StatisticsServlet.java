
package com;

import Service.Service;
import bean.Breakfast_ReviewBean;
import bean.RoomBean;
import bean.Room_ReviewBean;
import bean.Service_ReviewBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class StatisticsServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Service service=new Service();
        List<Breakfast_ReviewBean> list=new ArrayList<Breakfast_ReviewBean>();
         List<Service_ReviewBean> list1=new ArrayList<Service_ReviewBean>();
          List<RoomBean> list2=new ArrayList<RoomBean>();
           List<Room_ReviewBean> list3=new ArrayList<Room_ReviewBean>();
        HttpSession session=request.getSession();
        
      String option=request.getParameter("option");
      System.out.println("value selected is : "+option);
      String fromDate=request.getParameter("date");
      String toDate=request.getParameter("date1");
      
     
      if(option.equalsIgnoreCase("btype")){
       list=  service.getBrekfastStatistics(fromDate, toDate);
          
          System.out.println("List Size->"+list.size());
       session.setAttribute("blist",list);
        getServletConfig().getServletContext().getRequestDispatcher("/BreakfastRating.jsp").forward(request,response);
        }
      
       if(option.equalsIgnoreCase("stype")){
       list1=  service.getServiceStatistics(fromDate, toDate);
          
          System.out.println("List Size->"+list.size());
       session.setAttribute("slist",list1);
        getServletConfig().getServletContext().getRequestDispatcher("/ServiceRating.jsp").forward(request,response);
        }
       
        if(option.equalsIgnoreCase("top5")){
       list2=  service.gettop5Statistics(fromDate, toDate);
          
          System.out.println("List Size->"+list.size());
       session.setAttribute("tlist",list2);
        getServletConfig().getServletContext().getRequestDispatcher("/Top5Rating.jsp").forward(request,response);
        }
        
        if(option.equalsIgnoreCase("rtype")){
       list3=  service.getroomTypeStatistics(fromDate, toDate);
          
          System.out.println("List Size->"+list3.size());
       session.setAttribute("rlist",list3);
        getServletConfig().getServletContext().getRequestDispatcher("/RoomTypeRating.jsp").forward(request,response);
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
