
package com;

import Service.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServiceReservationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        String[] serviceType= request.getParameterValues("Soption");
        List<String> SType=new ArrayList<String>();
        ArrayList SPrice=new ArrayList<String>(); 
       
        String[] dummy;
        String InvoiceNoString=(String)session.getAttribute("InvoiceNo");
        Long InvoiceNo=Long.parseLong(InvoiceNoString);
        String hotelIDString=(String)session.getAttribute("hotelID");
        int HotelID=Integer.parseInt(hotelIDString);
        
   
    for (String s: serviceType){
       dummy= s.split(",");
      for(int i=0;i<dummy.length;i=i+2){
          SType.add(dummy[i]);
          SPrice.add(dummy[i+1]);
          
      }
       System.out.println("values are : "+s);
       System.out.println("values are : "+SType+"\t"+SPrice);
       
    }
    Service service=new Service();
    service.insertIntoReservation_Service(SType, InvoiceNo, HotelID);
     session.setAttribute("Stypes", SType);
        session.setAttribute("Sprices", SPrice);
           getServletConfig().getServletContext().getRequestDispatcher("/ServiceConfirmation.jsp?InvoiceNo="+InvoiceNo).forward(request,response);

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
