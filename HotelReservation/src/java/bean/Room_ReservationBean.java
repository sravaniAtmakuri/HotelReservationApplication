
package bean;

public class Room_ReservationBean {
    private String CheckInDate;
    private String CheckOutDate;
    private int HotelID;
    private long InvoiceNo;
    private String RoomNo;
    private int CID;
    private String Cnumber;

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getCnumber() {
        return Cnumber;
    }

    public void setCnumber(String Cnumber) {
        this.Cnumber = Cnumber;
    }

    public String getCheckInDate() {
        return CheckInDate;
    }

    public void setCheckInDate(String CheckInDate) {
        this.CheckInDate = CheckInDate;
    }

    public String getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(String CheckOutDate) {
        this.CheckOutDate = CheckOutDate;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int HotelID) {
        this.HotelID = HotelID;
    }

    public long getInvoiceNo() {
        return InvoiceNo;
    }

    public void setInvoiceNo(long InvoiceNo) {
        this.InvoiceNo = InvoiceNo;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String RoomNo) {
        this.RoomNo = RoomNo;
    }
    
}
