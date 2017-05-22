/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import Service.Service;
import bean.HotelBean;
import bean.RoomBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ListofHotelsServlet extends HttpServlet {
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         List<RoomBean> roomList = new ArrayList<RoomBean>();
        System.out.println("inside the ListofHotels!!");
        HttpSession session = request.getSession();
        String location = (String) session.getAttribute("Location");
         System.out.println(session.getAttribute("Location")+"\t"+location);
         String street = (String) session.getAttribute("messageStreet");
         String checkInDate=(String) session.getAttribute("checkInDate");
          String checkOutDate=(String) session.getAttribute("checkOutDate");
         System.out.println("checkInDate value is:"+checkInDate);
         System.out.println("checkOutDate value is:"+checkOutDate);
         System.out.println(""+street);
          Service service = new Service();
        roomList = service.findRoomsDetails(location,street,checkInDate,checkOutDate);
        
        if(roomList.size()>0){
            System.out.println("inside if ListofHotels Servlet");
        
            request.setAttribute("ListofRooms", roomList); //categorylist is an arraylist      contains object of class category  
            System.out.println(roomList.size());
            getServletConfig().getServletContext().getRequestDispatcher("/ListofRooms.jsp").forward(request,response);

        } else {
            System.out.println("inside else in ListofHotelsServlet");
            String message = "Rooms not found";
            response.sendRedirect("ListofHotels.jsp?message1=" + message);
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
