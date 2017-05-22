
package bean;

public class ReservationBean {
    private long invoiceNo;
    private int CID;
    private String CNumber;
    private String RDate;

    public long getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getCNumber() {
        return CNumber;
    }

    public void setCNumber(String CNumber) {
        this.CNumber = CNumber;
    }

    public String getRDate() {
        return RDate;
    }

    public void setRDate(String RDate) {
        this.RDate = RDate;
    }
    
}
