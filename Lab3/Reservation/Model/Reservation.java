package Reservation.Model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Reservation {
    private String bookingID;
    private String customerName;
    private String phone;
    private String roomNumber;
    private Date date;
    private FlightInfomation flightInfomation;
    final static String DATE_FORMAT = "dd/MM/yyyy";

    public Reservation(String bookingID, String customerName, String phone, String roomNumber, Date date, FlightInfomation flightInfomation) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.phone = phone;
        this.roomNumber = roomNumber;
        this.date = date;
        this.flightInfomation = flightInfomation;
    }

    
    
    

    public Reservation() {
        super();
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public FlightInfomation getFlightInfomation() {
        return flightInfomation;
    }

    public void setFlightInfomation(FlightInfomation flightInfomation) {
        this.flightInfomation = flightInfomation;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    
    public static String center(Object o, int width) {
        String s = (o == null) ? "" : o.toString();        
        int padding = width - s.length();
        if (padding <= 0) {
            return s;
        }
        int left = padding / 2;
        int right = padding - left;
        return " ".repeat(left) + s + " ".repeat(right);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return  String.format("|%s|%s|%s|%s|%s|", //
            center(this.getBookingID(), 15),
            center(this.getCustomerName(), 20),
            center(this.getPhone(), 15),
            center(this.getRoomNumber(), 15),
            center(sdf.format(this.getDate()), 15) + flightInfomation.toString()
);        
    }
    
}
