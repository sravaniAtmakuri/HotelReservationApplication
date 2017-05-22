
package com;

import bean.RoomBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession ;

public class ListOfRoomsServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     System.out.println("In listOfRoomsServlet");
      HttpSession session=request.getSession();
     List<RoomBean> roombean=(List<RoomBean>) session.getAttribute("roomList");
       RoomBean bean=(RoomBean) session.getAttribute("roomBean");
             
     System.out.println("roombean values are: "+roombean.get(0).getRoomNo());
      System.out.println("bean values are new: "+bean.getRoomNo());
   
   
             
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
