
package com;

import Service.Service;
import bean.Breakfast_ReviewBean;
import bean.Service_ReviewBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class BreakfastReviewConfirmationServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String message="";
        HttpSession session=request.getSession();
        String BType=(String)session.getAttribute("BType");
        String CIDString=(String) session.getAttribute("CID");
        String hotelIDString=(String) session.getAttribute("hotelID");
        String checkInDate=(String) session.getAttribute("checkInDate");
        int hotelID=Integer.parseInt(hotelIDString);
        int CID=Integer.parseInt(CIDString);
        String text=request.getParameter("descp");
        String rating=request.getParameter("rating");
        
        
        System.out.println(BType+"\n"+CIDString+"\n"+hotelID+"\n"+text+"\n"+rating);
        Breakfast_ReviewBean review=new Breakfast_ReviewBean();
        review.setCID(CID);
        review.setHotelID(hotelID);
        review.setRating(Integer.parseInt(rating));
        review.setText(text);
        review.setBType(BType);
        
        Service service=new Service();
       int i=service.insertIntoBreakfast_Review(review);
      
        if(i>0){
            System.out.println("inserted into Breakfast review table");
           message="Your review submitted successfully for "+BType+" Breakfast for "+checkInDate+"!!!";
        }
        
        getServletConfig().getServletContext().getRequestDispatcher("/BreakfastReviewPage.jsp?message="+message).forward(request,response);


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

