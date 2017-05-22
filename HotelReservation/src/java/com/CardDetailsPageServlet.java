
package com;

import Service.Service;
import bean.Credit_CardBean;
import bean.ReservationBean;
import bean.RoomBean;
import bean.Room_ReservationBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CardDetailsPageServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        boolean value; 
       HttpSession session=request.getSession();
        Service service =new Service();
        
     Credit_CardBean card=new Credit_CardBean();
    
     String Cnumber=request.getParameter("cardnumber");
     String CType=request.getParameter("cardType");
     String Name=request.getParameter("nameOnCard");
     String Baddress=request.getParameter("billingAddress");
     String CodeString=request.getParameter("securityCode");
     int code=Integer.parseInt(CodeString);
     String expDateMonth=request.getParameter("Month");
     String expDateYear=request.getParameter("Year");
     System.out.println("expdatemonth is: "+expDateMonth);
      ;
     
     String hotelID=request.getParameter("hotelID");
     String roomNo=request.getParameter("roomNo");
     String rommdescription=(String)session.getAttribute("description");
     System.out.println("hotelID is: "+hotelID+" room no is: "+roomNo+" roomdescription is: "+rommdescription);
     
     RoomBean room=new RoomBean();
     room.setHotelID(Integer.parseInt(hotelID));
     room.setRoomNo(roomNo);
     room.setDescription(rommdescription);
     
     
     
     card.setBaddress(Baddress);
     card.setCNumber(Cnumber);
     card.setCType(CType);
     card.setCode(code);
     card.setName(Name);
     card.setExpDate(expDateMonth+"/"+expDateYear);
     
     String emailID=(String)session.getAttribute("userName");
     
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String currentdate=(dtf.format(localDate)).toString();
        System.out.println("current date is: "+currentdate);
        
     ReservationBean reservation=new ReservationBean();
     reservation.setCNumber(Cnumber);
     reservation.setRDate(currentdate);
     
     Room_ReservationBean room_reservation=new Room_ReservationBean();
     String checkInDate=(String)session.getAttribute("date");
     String checkOutDate=(String)session.getAttribute("date1");
     
     room_reservation.setCheckInDate(checkInDate);
     room_reservation.setCheckOutDate(checkOutDate);
     room_reservation.setHotelID(Integer.parseInt(hotelID));
     room_reservation.setRoomNo(roomNo);
     
     
       request.setAttribute("RoomBean", room);
       request.setAttribute("Room_ReservationBean", room_reservation);
       request.setAttribute("ReservationBean", reservation);
       request.setAttribute("Credit_CardBean ", card);
       request.setAttribute("NoOfdays", session.getAttribute("NoOfDays"));
       request.setAttribute("totalamount", session.getAttribute("totalamount"));
        
       session.setAttribute("cardnumber", Cnumber);
        session.setAttribute("cardExp", (expDateMonth+"/"+expDateYear));
           
     value=service.checkCNumber(Cnumber);
    
     
     if(value==true){
         System.out.println("inside the if loop in servlet");
         int i= service.insertintoCreditCard(card);
        
     }     
     System.out.println("after the check number and after card insertion");
           int j=service.insertIntoReservation(reservation,emailID);
           if(j>0){
               System.out.println("inserted into Reservation Table");
              int k= service.insertIntoRoomReservation(room_reservation, reservation);
              if(k>0){
                   System.out.println("inserted into Room_Reservation Table");
              }
           }
           
          getServletConfig().getServletContext().getRequestDispatcher("/ConfirmationPage.jsp").forward(request,response);
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
