package Reservation.Model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class FlightInfomation {
    private int flightNumber;
    private int seatNumber;
    private Date timePickUp;
    
    final static String DATE_FORMAT = "dd/MM/yyyy";
    

    public FlightInfomation() {
    }

    public FlightInfomation(int flightNumber, int seatNumber, Date timePickUp) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getTimePickUp() {
        return timePickUp;
    }

    public void setTimePickUp(Date timePickUp) {
        this.timePickUp = timePickUp;
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
        return String.format("|%s|%s|%s", //
            center(this.getFlightNumber(), 20),
            center(this.getSeatNumber(), 15),
            center(sdf.format(this.getTimePickUp()), 15)
);        
    }
    
}
