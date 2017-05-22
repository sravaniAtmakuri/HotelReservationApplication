
package com;

import Service.Service;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BreakfastServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] breakfastTypes= request.getParameterValues("Btype");
        List<String> quantities= new ArrayList<String>();
        List<String> BType=new ArrayList<String>();
        List<String> BPrice= new ArrayList<String>();
        
        System.out.println(""+breakfastTypes.length);
        for(String s: breakfastTypes){
            System.out.println(s+"\n");
             String ss[]=s.split(",");
             for(int i=0;i<ss.length;i=i+2){
                BType.add(ss[i]);
                BPrice.add(ss[i+1]);
            }
          
       
        }
        String[] quantity = request.getParameterValues("Quantity");
        for(String S: quantity){
            System.out.println(""+S);
            if(!(S.equalsIgnoreCase("0"))){
               quantities.add(S);
               
            }
        }
        System.out.println("Size of breakfastTypes--->"+BType.size());
        System.out.println("Size of prices -->"+BPrice.size());
       System.out.println("Size of quantites-->"+quantities.size());
       for(int i=0;i<BType.size();i++){
           System.out.println("breakfastTypes--->"+BType.get(i));
        System.out.println("prices -->"+BPrice.get(i));
       System.out.println("quantites-->"+quantities.get(i));
       }
         HttpSession session = request.getSession();
         String invoiceNo= (String)session.getAttribute("invoiceNo");
         String hotelID = (String) session.getAttribute("hotelID");
         Service service= new Service();
         
       int capacity= service.getMaximumOccupancyInRoom(invoiceNo);
       session.setAttribute("capacity", capacity);
       int totalQuantity = 0;
       for(int i=0;i<quantities.size();i++){
           int quanty= Integer.parseInt(quantities.get(i));
           totalQuantity= totalQuantity+quanty;
       }
        System.out.println("User entered quantity-->"+totalQuantity);
       
        if(totalQuantity > capacity){
                String message1="Please select  total quantity less than or equal to "+capacity;
                 response.sendRedirect("BreakfastReservation.jsp?hotelID="+hotelID+"&invoiceNo="+invoiceNo+"&message1="+message1);
            
        }else{
            session.setAttribute("BType", BType);
            session.setAttribute("quantities", quantities);
            session.setAttribute("BPrice", BPrice);
           service.addReservationBreakfast(invoiceNo,hotelID,BType,quantities);
              getServletConfig().getServletContext().getRequestDispatcher("/BreakfastConfirmation.jsp?invoiceNo="+invoiceNo).forward(request,response);
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
