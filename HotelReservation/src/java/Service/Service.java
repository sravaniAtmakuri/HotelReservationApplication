
package Service;

import bean.BreakfastBean;
import bean.Breakfast_ReviewBean;
import bean.Credit_CardBean;
import bean.CustomerBean;
import bean.HotelBean;
import bean.LoginBean;
import bean.RResv_BreakfastBean;
import bean.Reserv_ServiceBean;
import bean.ReservationBean;
import bean.RoomBean;
import bean.Room_ReservationBean;
import bean.Room_ReviewBean;
import bean.ServiceBean;
import bean.Service_ReviewBean;
import connectDB.connectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Service {
     public boolean login(String userName, String password)
    {
       
        boolean flag=false;
        try
        {
            Connection con=connectDB.connectToDB();
            Statement stmt=con.createStatement();
            String query="select * from HotelLogin";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                String name=rs.getString("UserName");
                String pass=rs.getString("password");
                
                if(userName.equals(name) && password.equals(pass))
                {
                    
                    flag=true;
                    break;
                }
            }
        }
        catch(Exception e)
        {
                System.out.println("Exception in login - " + e);
        }
        return flag;
    }
    
    public int insertCustomer(CustomerBean customer){
         int j=0;
         int i=0;
         
        try{
           System.out.println("inside the service method in insertCustomer!!!");
            Connection con=connectDB.connectToDB();
            Statement st=con.createStatement();
            String query="insert into Customer(CName,Address,Phone_No,Email) Values('"+customer.getName()+"','"+customer.getAddress()+"','"+customer.getPhonenumber()+"','"+customer.getEmail()+"')";
            System.out.println("Query value is:"+ query);
            j=st.executeUpdate(query);
            System.out.println("value of j after inserting the values into customer table is: "+j);
            
        } catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
        if(j>0){
            i++;
           }else{
            System.out.println("Not inserted into the Customer Table!!!");
        }
       
        return i; 
    }
    public void insertIntoLogin(LoginBean login){
        int j=0;
        try{
            Connection con=connectDB.connectToDB();
            Statement st=con.createStatement();
            String Query="INSERT INTO HotelLogin(UserName,password) VALUES('"+login.getUsername()+"','"+login.getPassword()+"')";
            j=st.executeUpdate(Query);
            
        } catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public boolean forgotPassword(String username,String password){
        int i=0;
        boolean value=false;
        try{
            Connection con=connectDB.connectToDB();
            Statement st=con.createStatement();
            String Query="Select * from HotelLogin WHERE UserName='"+username+"'";
            System.out.println("Inside forgot password method, and query is: "+Query);
            ResultSet rs=st.executeQuery(Query);
            while(rs.next()){
                String Query1="Update HotelLogin SET password='"+password+"' where UserName='"+username+"'";
               i= st.executeUpdate(Query1);
               if(i>0){
                   value= true;
               }
            }
        } catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
        return value;
    }
    public List<HotelBean> findLocation(String location){
        boolean isPresent = false;
        String street, city, zipcode;
        HotelBean ht = null;
        List<HotelBean> list = new ArrayList<HotelBean>();
                
         try {
             Connection conn = connectDB.connectToDB();
             Statement stmt = conn.createStatement();
             String searchQuery = "select * from Hotel where state='"+location+"'";
             System.out.println("Search Location "+searchQuery);
             ResultSet rs = stmt.executeQuery(searchQuery);
             if( rs != null){
                 while(rs.next()){
                     ht=new HotelBean();
                     street = rs.getString("Street");
                     city = rs.getString("State");
                     zipcode = rs.getString("zip");
                    ht.setStreet(street);
                    ht.setState(city);
                    ht.setZip(zipcode);
                    list.add(ht);
                     System.out.println(street+"\t"+city+"\t"+zipcode);
                 }
                 isPresent = true;
             }else{
                 System.out.println("Hotel is not found in this location");
             }
           //  conn.close();
         } catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        return list;
    }
    
    public List<RoomBean> findRoomsDetails(String location, String street,String checkInDate, String checkOutDate){
        String roomType,description;
        int hotelID=0,capacity=0;
        double price;
        
        
        RoomBean room = null;
        List<RoomBean> list = new ArrayList<RoomBean>();
        List<RoomBean> newlist = new ArrayList<RoomBean>();
         List<RoomBean> availabilityList = new ArrayList<RoomBean>();
        Service service=new Service();
                
         try {
             Connection conn = connectDB.connectToDB();
             Statement stmt = conn.createStatement();
             String searchHotel = "select * from Hotel where state='"+location+"' AND street='"+street+"'";
             System.out.println("Search Location "+searchHotel);
             ResultSet rs = stmt.executeQuery(searchHotel);
             if( rs != null){
                 while(rs.next()){
                 hotelID = rs.getInt("HotelID");                     }
                 System.out.println(hotelID);
             }else{
                 System.out.println("Hotel is not found in this location");
             }
             
             Statement stmt1 = conn.createStatement();
             String searchRoom = "select * from Room where HotelID="+hotelID; 
             
              
        
             System.out.println("Search Room "+searchRoom);
             ResultSet rs1 = stmt1.executeQuery(searchRoom);
             if(rs1 !=null){
                 while(rs1.next()){
                     room = new RoomBean();
                     roomType = rs1.getString("RType");
                     description = rs1.getString("Description");
                     price = rs1.getDouble("Price");
                     capacity = rs1.getInt("Capacity");
                     room.setHotelID(rs1.getInt("HotelID"));
                     room.setRoomNo(rs1.getString("RoomNo"));
                     room.setFloor(rs1.getInt("Floor"));
                     room.setRoomType(roomType);
                     room.setDescription(description);
                     room.setPrice(price);
                     room.setCapacity(capacity);
                     System.out.println(roomType+"\t"+description+"\t"+price+"\t"+capacity);
                     list.add(room);
                 }
                 
                 if(list.size()>0){
                    availabilityList=service.checkAvailabilityOfRooms(list, checkInDate, checkOutDate, hotelID);
                    newlist= service.discounted_room(list, checkInDate, checkOutDate);
                     
                 }
             }else{
                 System.out.println("Rooms is not found in this location");
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        System.out.println("ending the method find rooms");
        return list;
    }
    public List<RoomBean> discounted_room(List<RoomBean> l,String CheckIndate, String checkOutDate){
        try {
        Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        for(int i=0;i<l.size();i++){
             
             
            String Query="SELECT Discount FROM Discounted_Room WHERE HotelID="+l.get(i).getHotelID()+" AND RoomNo="+l.get(i).getRoomNo()+" AND StartDate<='"+CheckIndate+"' AND EndDate>='"+checkOutDate+"'";
            System.out.println("Query is: "+Query);
            ResultSet rs=stmt.executeQuery(Query);
            if(rs.next()){
                System.out.println("Inside the if loop:in discounted_room method");
                l.get(i).setDiscountedPrice(l.get(i).getPrice()-(l.get(i).getPrice()*(rs.getDouble("Discount")/100)));
                System.out.println(l.get(i).getDiscountedPrice());
            }
        }   
        }catch(Exception e){
            
        }
        return l;
    }
    public boolean checkCNumber(String cnumber){
        boolean value=true;
         try {
        System.out.println("In checkCNumber");       
        Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        String Query="SELECT CNumber FROM Credit_Card where CNumber="+cnumber+"";
         System.out.println("Query is: "+Query);
        ResultSet rs=stmt.executeQuery(Query);
        if(rs.next()){
            System.out.println("in if checkCNumber");
            value=false;
        }else{
            System.out.println("in else checkCNumber");
            value=true;
        }
       
        
    }    catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
         return value;
}
    
   
    
    
    
    
    public int insertintoCreditCard(Credit_CardBean card){
    int j=0;    
    
        try {
        System.out.println("In insertintoCreditCard");       
        Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        String Query="Insert Into Credit_Card values('"+card.getCNumber()+"','"+card.getCType()+"','"+card.getName()+"','"+card.getBaddress()+"',"+card.getCode()+",'"+card.getExpDate()+"')";
           j=stmt.executeUpdate(Query);
    }    catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
        return j;
}
    public int insertIntoReservation(ReservationBean reservation,String emailID){
        System.out.println("Inside the insertIntoReservation");
        int CID=0;
        int value=0;
         try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        String Query="select CID from Customer where Email='"+emailID+"'";
        System.out.println("Inside the insertIntoReservation Query is :"+Query);
        ResultSet rs=stmt.executeQuery(Query);
        if(rs.next()){
            CID=rs.getInt("CID");
             System.out.println("Inside the insertIntoReservation inside the if in email retrieving");
              }
        reservation.setCID(CID);
        String Query2="Insert Into Reservation(CID,CNumber,RDate) VALUES("+reservation.getCID()+",'"+reservation.getCNumber()+"','"+reservation.getRDate()+"')";
           System.out.println("Inside the insertIntoReservation Query is :"+Query2);
         value=stmt.executeUpdate(Query2);
       
        
        
    }    catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
     return value;
}
    public int insertIntoRoomReservation(Room_ReservationBean room,ReservationBean reservation){
        long invoiceNo;
        int j=0;
       try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        String Query="Select InvoiceNo from Reservation where CID="+reservation.getCID()+" AND CNumber='"+reservation.getCNumber()+"'AND RDate='"+reservation.getRDate()+"'";
        System.out.println("Query is: "+Query);
        ResultSet rs=stmt.executeQuery(Query);
        if(rs.next()){
            System.out.println("inside the insertintoroomreservation in if loop");
            invoiceNo=rs.getLong("InvoiceNo");
            room.setInvoiceNo(invoiceNo);
        }
        String Query1="Insert into Room_Reservation values('"+room.getCheckInDate()+"',"+room.getHotelID()+","+room.getInvoiceNo()+",'"+room.getRoomNo()+"','"+room.getCheckOutDate()+"')";
        System.out.println("Query1 is: "+Query1);
        j=stmt.executeUpdate(Query1);
        
        
        
    }    catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
       return j;
}
 public List<RoomBean> checkAvailabilityOfRooms(List<RoomBean> l,String CheckIndate, String checkOutDate,int hotelID){
  try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        for(int i=0;i<l.size();i++){
        String Query="select RoomNo from Room_Reservation where HotelID="+hotelID+" AND CheckInDate<'"+checkOutDate+"' AND CheckoutDate>'"+CheckIndate+"'";
        System.out.println("availability query is: "+Query);
         ResultSet rs=stmt.executeQuery(Query);
         if(rs!=null){
         while(rs.next()){
             System.out.println("inside while loop checking avaialbility!!!!!");
            if(l.get(i).getRoomNo().equals(rs.getString("RoomNo"))){
                 System.out.println("inside while loop checking avaialbility and matchiing room number!!!!!");
                l.get(i).setAvailability("unavailable");
                
            }
         }
         }
        }
}        catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
    return l;
}
 public  List<Room_ReservationBean>  getRoomReservationDetails(String username){
     Room_ReservationBean room_Reservation=null;
     List<Room_ReservationBean> list=new ArrayList<Room_ReservationBean>();
     int CID=0;
     try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query="select CID from Customer where Email='"+username+"'";
        ResultSet rs=stmt.executeQuery(Query);
        if(rs.next()){
           CID=rs.getInt("CID");
        }
      String Query1="select * from Room_Reservation natural join Reservation where CID="+CID;
      ResultSet rs1=stmt.executeQuery(Query1);
      while(rs1.next()){
           room_Reservation = new Room_ReservationBean();
          room_Reservation.setCID(CID);
          room_Reservation.setCheckInDate(rs1.getString("CheckInDate"));
          room_Reservation.setCheckOutDate(rs1.getString("CheckoutDate"));
          room_Reservation.setHotelID(rs1.getInt("HotelID"));
          room_Reservation.setRoomNo(rs1.getString("RoomNo"));
          room_Reservation.setInvoiceNo(rs1.getLong("InvoiceNo"));
          room_Reservation.setCnumber(rs1.getString("CNumber"));
          list.add(room_Reservation);
      }
 
}        catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
     return list;
 }
 public List<ServiceBean> retrieveServiceDetails(int HotelID){
     ServiceBean service;
     List<ServiceBean> servicelist= new ArrayList<ServiceBean>();
      try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query="select * from Service where HotelID="+HotelID;
        ResultSet rs=stmt.executeQuery(Query);
        while(rs.next()){
            service=new ServiceBean();
            service.setHotelID(HotelID);
            service.setSPrice(rs.getInt("SPrice"));
            service.setSType(rs.getString("SType"));
            servicelist.add(service);
        }
     
 }       catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
      return servicelist;
}
  public List<BreakfastBean> retrieveBreakfastDetails(int HotelID){
     BreakfastBean breakfast;
     List<BreakfastBean> breakfastlist= new ArrayList<BreakfastBean>();
      try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query="select * from Breakfast where HotelID="+HotelID;
        ResultSet rs=stmt.executeQuery(Query);
        while(rs.next()){
            breakfast=new BreakfastBean();
            breakfast.setHotelID(HotelID);
            breakfast.setBPrice(rs.getInt("BPrice"));
            breakfast.setBType(rs.getString("BType"));
            breakfast.setDescription(rs.getString("Description"));
            breakfastlist.add(breakfast);
        }
     
 }       catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
      return breakfastlist;
}
  public void insertIntoReservation_Service(List<String> stypes,Long InvoiceNumber, int HotelID){
      System.out.println("inside the method");
      Reserv_ServiceBean bean=new Reserv_ServiceBean ();
       try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query="select * from Room_Reservation where InvoiceNo="+InvoiceNumber;
        ResultSet rs=stmt.executeQuery(Query);
        if(rs.next()){
           bean.setCheckInDate(rs.getString("CheckInDate"));
           bean.setRoomNo(rs.getString("RoomNo"));
           bean.setHotelID(rs.getInt("HotelID"));
        }
        for(String type:stypes){
      String Query1="insert into RRESV_SERVICE values('"+type+"',"+bean.getHotelID()+",'"+bean.getRoomNo()+"','"+bean.getCheckInDate()+"')";
      System.out.println("Query1 is :"+Query1);
       stmt.executeUpdate(Query1);
              }
  }      catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
}
  public List<Service_ReviewBean> getServiceDetailswithUserName(String UserName){
      Service_ReviewBean servicereview=null;
      List<Service_ReviewBean> list=new ArrayList<Service_ReviewBean>();
      int CID=0;
  
    try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query=  "select CID from Customer where Email='"+UserName+"'";
        ResultSet rs=stmt.executeQuery(Query);
        if(rs.next()){
            CID=rs.getInt("CID");
          }
        
       String Query1="SELECT * FROM RRESV_SERVICE WHERE (CheckInDate,HotelID,RoomNo) IN(select CheckInDate,HotelID,RoomNo from Room_Reservation where InvoiceNo IN(select InvoiceNo from Reservation where CID="+CID+"))"; 
       ResultSet rs1=stmt.executeQuery(Query1);
        while(rs1.next()){
            servicereview=new Service_ReviewBean();
            servicereview.setCID(CID);
            servicereview.setCheckInDate(rs1.getString("CheckInDate"));
            servicereview.setHotelID(rs1.getInt("HotelID"));
            servicereview.setRoomNo(rs1.getString("RoomNo"));
            servicereview.setSType(rs1.getString("SType"));
            list.add(servicereview);
        }
        
  }      catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
    return list;
}
  public int insertIntoService_Review(Service_ReviewBean review){
      int j=0;
      try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query= "insert into Service_Review(Rating,Text,HotelID,CID,SType)values("+review.getRating()+",'"+review.getText()+"',"+review.getHotelID()+","+review.getCID()+",'"+review.getSType()+"')";
        System.out.println("Query is :"+Query);
       j= stmt.executeUpdate(Query);
      
  }      catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
       return j;
}
 public int insertIntoRoom_Review(Room_ReviewBean review){
     int j=0;
      try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query= "insert into Room_Review(Rating,Text,CID,HotelID,RoomNo)values("+review.getRating()+",'"+review.getText()+"',"+review.getCID()+","+review.getHotelID()+",'"+review.getRoomNo()+"')";
        System.out.println("Query is :"+Query);
       j= stmt.executeUpdate(Query);
      
  }      catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
       return j;
     
     
 }
 
  public int getMaximumOccupancyInRoom(String invoiceNo){
        int capacity=0;
        int invoiceNum=Integer.parseInt(invoiceNo);
        Connection conn = connectDB.connectToDB();
         try {
             Statement stmt = conn.createStatement();
             String selectMax ="Select Capacity from Room_Reservation Natural Join Room where InvoiceNo="+invoiceNum;
             
              ResultSet rs= stmt.executeQuery(selectMax);
             
                 while(rs.next()){
                     capacity = rs.getInt("Capacity");
                 }
                                 
             System.out.println("Maximum Occupancy-->"+capacity);
             
             
             conn.close();
         } catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
          
        
        
        return capacity;
    }
  
   public void addReservationBreakfast(String invoiceNo, String ID, List<String> BType, List<String> quantities) {
        RResv_BreakfastBean breakfastBean= new RResv_BreakfastBean();
        Connection conn = connectDB.connectToDB();
         try {
        int hotelID= Integer.parseInt(ID);
        int invoiceNum= Integer.parseInt(invoiceNo);
             Statement stmt, stmt2;
             stmt = conn.createStatement();
                       
             String selectRoomResv = "select * from Room_Reservation where InvoiceNo="+invoiceNum;
             ResultSet rs= stmt.executeQuery(selectRoomResv);
             
                 while(rs.next()){
                     breakfastBean.setRoomNo(rs.getString("RoomNo"));
                     breakfastBean.setCheckInDate(rs.getString("CheckInDate"));
                     breakfastBean.setHotelID(rs.getInt("HotelID"));
                     
                 }
                 
                 
                 for(int i=0;i<BType.size();i++){
                     stmt2=conn.createStatement();
                     String insertstmt="insert into RRESV_BREAKFAST values('"+BType.get(i)+"',"+hotelID+",'"+breakfastBean.getRoomNo()+"','"+breakfastBean.getCheckInDate()+"',"+quantities.get(i)+")";
                     System.out.println(insertstmt+"\n\n");
                      stmt2.executeUpdate(insertstmt);
                 }
                 conn.close();
         } catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
   
     public List<Breakfast_ReviewBean> getBreakfastDetailswithUserName(String UserName){
     Breakfast_ReviewBean breakfastreview=null;
      List<Breakfast_ReviewBean> list=new ArrayList<Breakfast_ReviewBean>();
      int CID=0;
  
    try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query=  "select CID from Customer where Email='"+UserName+"'";
        ResultSet rs=stmt.executeQuery(Query);
        if(rs.next()){
            CID=rs.getInt("CID");
          }
        
       String Query1="SELECT * FROM RRESV_BREAKFAST WHERE (CheckInDate,HotelID,RoomNo) IN(select CheckInDate,HotelID,RoomNo from Room_Reservation where InvoiceNo IN(select InvoiceNo from Reservation where CID="+CID+"))"; 
       ResultSet rs1=stmt.executeQuery(Query1);
        while(rs1.next()){
            breakfastreview=new Breakfast_ReviewBean();
            breakfastreview.setCID(CID);
            breakfastreview.setCheckInDate(rs1.getString("CheckInDate"));
            breakfastreview.setHotelID(rs1.getInt("HotelID"));
            breakfastreview.setRoomNo(rs1.getString("RoomNo"));
            breakfastreview.setBType(rs1.getString("BType"));
            list.add(breakfastreview);
        }
        
  }      catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
    return list;
}
     
     public List<BreakfastBean> getBreakfastDetails(int hotelID){
        
         Connection conn = connectDB.connectToDB();
         BreakfastBean bb=null;
         List<BreakfastBean> breakfastList = new ArrayList<BreakfastBean>();
         try {
             Statement stmt = conn.createStatement();
             String select_Breakfast = "select * from Breakfast where HotelId="+hotelID;
             ResultSet rs= stmt.executeQuery(select_Breakfast);
             
             if(rs!=null){
                 while(rs.next()){
                     bb=new BreakfastBean();
                     bb.setBType(rs.getString("BType"));
                     bb.setHotelID(rs.getInt("HotelID"));
                     bb.setDescription(rs.getString("Description"));
                    bb.setBPrice(rs.getInt("BPrice"));
                    breakfastList.add(bb);
                 }
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return breakfastList;
        
    }
 
      public int insertIntoBreakfast_Review(Breakfast_ReviewBean review){
      int j=0;
      try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query= "insert into Breakfast_Review(Rating,Text,HotelID,CID,BType)values("+review.getRating()+",'"+review.getText()+"',"+review.getHotelID()+","+review.getCID()+",'"+review.getBType()+"')";
        System.out.println("Query is :"+Query);
      j= stmt.executeUpdate(Query);
      
  }      catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
       return j;
}
      public  ArrayList< Breakfast_ReviewBean> getBrekfastStatistics(String fromDate, String toDate){
          Breakfast_ReviewBean bean=null;
          ArrayList< Breakfast_ReviewBean> list=new ArrayList< Breakfast_ReviewBean>();
         try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query=  "select Max(Rating) AS Max_Rating, BType from Breakfast_Review Natural Join RRESV_BREAKFAST where CheckInDate BETWEEN '"+fromDate+"' and '"+toDate+"' Group by Btype order by Max_Rating desc"; 
        System.out.println("Query is: "+Query); 
        ResultSet rs=stmt.executeQuery(Query);
        while(rs.next()){
         bean=new  Breakfast_ReviewBean();
         bean.setBType(rs.getString("BType"));
         bean.setRating(rs.getInt("Max_Rating"));
          list.add(bean);
        }
      }  catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
      return list;
      
      
}
        public  ArrayList< Service_ReviewBean> getServiceStatistics(String fromDate, String toDate){
          Service_ReviewBean bean=null;
          ArrayList< Service_ReviewBean> list=new ArrayList< Service_ReviewBean>();
         try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query=  "select Max(Rating) AS Max_Rating, SType from Service_Review Natural Join RRESV_SERVICE where CheckInDate BETWEEN '"+fromDate+"' and '"+toDate+"' Group by Stype order by Max_Rating desc"; 
        System.out.println("Query is: "+Query); 
        ResultSet rs=stmt.executeQuery(Query);
        while(rs.next()){
         bean=new  Service_ReviewBean();
         bean.setSType(rs.getString("SType"));
         bean.setRating(rs.getInt("Max_Rating"));
          list.add(bean);
        }
      }  catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
      return list;
      
      
}
        public  ArrayList< RoomBean> gettop5Statistics(String fromDate, String toDate){
          RoomBean bean=null;
          ArrayList< RoomBean> list=new ArrayList< RoomBean>();
         try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query=  "SELECT sum(R.Price) AS Max_Amount, C.CName AS CustomerName\n" +
"FROM Reservation RE\n" +
"Inner join Room_Reservation RR on RE.InvoiceNo=RR.InvoiceNo\n" +
"Inner join Room R on RR.RoomNo=R.RoomNo and RR.HotelID = R.HotelID\n" +
"Inner join Customer C on C.CID=RE.CID\n" +
"where RR.CheckInDate Between '"+fromDate+"' AND '"+toDate+"'\n" +
"Group by RE.CID,C.CName ORDER BY Max_Amount DESC"; 
        System.out.println("Query is: "+Query); 
        ResultSet rs=stmt.executeQuery(Query);
        while(rs.next()){
         bean=new  RoomBean();
         bean.setCName(rs.getString("CustomerName"));
         bean.setPrice(rs.getInt("Max_Amount"));
          list.add(bean);
        }
      }  catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
      return list;
      
      
}
        public  ArrayList< Room_ReviewBean> getroomTypeStatistics(String fromDate, String toDate){
          Room_ReviewBean bean=null;
          ArrayList< Room_ReviewBean> list=new ArrayList< Room_ReviewBean>();
         try {
         Connection conn = connectDB.connectToDB();
        Statement stmt = conn.createStatement();
        
        String Query=  "Select max(Max_Rating) as MAX_RATING, T.HotelID,T.Room_Type as ROOM_TYPE \n" +
"from (SELECT Distinct(R.HotelID), Max(RR.Rating) as Max_Rating, R.Rtype As Room_Type From Room_Review as RR Inner Join Room R on R.RoomNo=RR.RoomNo and R.HotelID=RR.HotelID Inner Join Room_Reservation RE on RE.RoomNo=RR.RoomNo and RE.HotelID=RR.HotelID Where RE.CheckInDate Between '"+fromDate+"' and '"+toDate+"' Group by R.Rtype, R.HotelID Order by Max_Rating desc) T \n" +
"group by T.HotelID order by MAX_RATING DESC";
        System.out.println("Query is: "+Query); 
        ResultSet rs=stmt.executeQuery(Query);
        while(rs.next()){
         bean=new  Room_ReviewBean();
         bean.setRtype(rs.getString("Room_Type"));
         bean.setHotelID(rs.getInt("HotelID"));
         bean.setRating(rs.getInt("Max_Rating"));
          list.add(bean);
        }
      }  catch (SQLException ex) {
             Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
         }
      return list;
      
      
}
}