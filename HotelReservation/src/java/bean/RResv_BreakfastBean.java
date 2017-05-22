/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Archana
 */
public class RResv_BreakfastBean {
    private String Btype;
    private int HotelID;
    private String roomNo;
    private String checkInDate;
    private int NoofOrders;

    public String getBtype() {
        return Btype;
    }

    public void setBtype(String Btype) {
        this.Btype = Btype;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int HotelID) {
        this.HotelID = HotelID;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public int getNoofOrders() {
        return NoofOrders;
    }

    public void setNoofOrders(int NoofOrders) {
        this.NoofOrders = NoofOrders;
    }
}
