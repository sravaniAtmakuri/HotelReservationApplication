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
public class RoomBean {
     private String roomNo;
    private int hotelID;
    private String roomType;
    private double price;
    private String description;
    private int floor;
    private int capacity;
    private double discountedPrice;
    private String availability;
    private String CName;
    private int CID;

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
    

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public int getHotelID() {
        return hotelID;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getFloor() {
        return floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
   
    
    
}
