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
public class HotelBean {
       private int hotelId;
    private String street;
    private String state;
    private String zip;
    private String country;

    public int getHotelId() {
        return hotelId;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public void setHotelId(int Id) {
        hotelId = Id;
    }

    public void setStreet(String str) {
        street = str;
    }

    public void setState(String st) {
        state = st;
    }

    public void setZip(String zp) {
        zip = zp;
    }

    public void setCountry(String cou) {
        country = cou;
    }
 

   
}
