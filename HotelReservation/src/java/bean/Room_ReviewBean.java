
package bean;


public class Room_ReviewBean {
    private int Rating;
    private String Text;
    private int CID;
   private int HotelID;
   private String RoomNo;
   private String Rtype;

    public String getRtype() {
        return Rtype;
    }

    public void setRtype(String Rtype) {
        this.Rtype = Rtype;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public int getHotelID() {
        return HotelID;
    }

    public void setHotelID(int HOtelID) {
        this.HotelID = HOtelID;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String RoomNo) {
        this.RoomNo = RoomNo;
    }
    
}
