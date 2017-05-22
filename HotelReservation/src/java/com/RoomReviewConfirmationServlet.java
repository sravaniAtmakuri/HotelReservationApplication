
package com;

import Service.Service;
import bean.Room_ReviewBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RoomReviewConfirmationServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message="";
        System.out.println("In  RoomReview servlet");
        HttpSession session=request.getSession();
        String RoomNo=(String)session.getAttribute("RoomNo");
        String HotelID=(String)session.getAttribute("hotelID");
        String CID=(String) session.getAttribute("CID");
        String desc=request.getParameter("descp");
        String RatingString=request.getParameter("rating");
        int Rating=Integer.parseInt(RatingString);
        Room_ReviewBean review =new Room_ReviewBean();
        review.setRating(Rating);
        review.setRoomNo(RoomNo);
        review.setText(desc);
        review.setHotelID(Integer.parseInt(HotelID));
        review.setCID(Integer.parseInt(CID));
        
        Service service=new Service();
       int j=service.insertIntoRoom_Review(review);
       
       if(j>0){
           System.out.println("Inserted into Room_Review Table");
             message="Your Room review submitted successfully!!!";
           
       }
         getServletConfig().getServletContext().getRequestDispatcher("/RoomReview.jsp?message="+message).forward(request,response);

        
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
