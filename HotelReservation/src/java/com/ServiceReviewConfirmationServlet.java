
package com;

import Service.Service;
import bean.Service_ReviewBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServiceReviewConfirmationServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String message="";
        HttpSession session=request.getSession();
        String SType=(String)session.getAttribute("SType");
        String CIDString=(String) session.getAttribute("CID");
        String hotelIDString=(String) session.getAttribute("hotelID");
        int hotelID=Integer.parseInt(hotelIDString);
        int CID=Integer.parseInt(CIDString);
        String text=request.getParameter("descp");
        String rating=request.getParameter("rating");
        Service_ReviewBean review=new Service_ReviewBean();
        review.setCID(CID);
        review.setHotelID(hotelID);
        review.setRating(Integer.parseInt(rating));
        review.setText(text);
        review.setSType(SType);
        String checkInDate=(String)session.getAttribute("checkInDate");
        
        Service service=new Service();
        int i=service.insertIntoService_Review(review);
        if(i>0){
            System.out.println("inserted into service review table");
           message="Your review submitted successfully for "+SType+" Service  for "+checkInDate+"!!!";
        }
        
        getServletConfig().getServletContext().getRequestDispatcher("/ServiceReviewPage.jsp?message="+message).forward(request,response);


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
