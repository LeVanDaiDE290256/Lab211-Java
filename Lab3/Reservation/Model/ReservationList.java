package Reservation.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class ReservationList extends ArrayList<Reservation> {
    final static String DATE_FORMAT = "dd/MM/yyyy";

    public ReservationList() {
        addSampleData();
    }

    
    public Reservation search(String data) {
        for (Reservation index : this) {
            if (index.getBookingID().equalsIgnoreCase(data)) {
                return index;
            }
        }
        return null;
    }

    public boolean isDuplicate(String data) {
        return this.search(data) != null;
    }
    
    

    public void addNew(Reservation b) {
        super.add(b);        
    }
    
    public ArrayList<Reservation> search(Predicate<Reservation> condition) {
        ArrayList<Reservation> result = new ArrayList<>();
        for (Reservation b : this) {
            if (condition.test(b)) {
                result.add(b);
            }
        }
        return result;
    }
    
    public List<Reservation> displayAll() {
        return this;
    }
    public boolean update(String oldData, Reservation newData) {
        Reservation found = this.search(oldData);
        if (found == null) {
            return false;
        }
        found.setCustomerName(newData.getCustomerName() );
        found.setPhone(newData.getPhone());
        found.setRoomNumber(newData.getRoomNumber());
        found.setDate(newData.getDate());
        found.setFlightInfomation(newData.getFlightInfomation());
        return true;
    }
    public boolean deleteIf(Predicate<Reservation> condition) {
        boolean rm = this.removeIf(condition);
        if (rm) {            
        }
        return rm;        
    }
    public void sort() {
        Collections.sort(this, Comparator.comparing(r -> r.getFlightInfomation().getTimePickUp()));        
    }
    
    
    
    
    public void addSampleData() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            this.add(new Reservation("100001", "Alice", "012345678901", "1001",
                    sdf.parse("10/10/2025"),
                    new FlightInfomation(101, 1, sdf.parse("05/10/2025"))));

            this.add(new Reservation("100002", "Bob", "012345678902", "1002",
                    sdf.parse("15/10/2025"),
                    new FlightInfomation(102, 2, sdf.parse("12/10/2025"))));

            this.add(new Reservation("100003", "Charlie", "012345678903", "1003",
                    sdf.parse("20/10/2025"),
                    new FlightInfomation(103, 3, sdf.parse("18/10/2025"))));

            this.add(new Reservation("100004", "David", "012345678904", "1004",
                    sdf.parse("25/10/2025"),
                    new FlightInfomation(104, 4, sdf.parse("22/10/2025"))));

            this.add(new Reservation("100005", "Emma", "012345678905", "1005",
                    sdf.parse("30/10/2025"),
                    new FlightInfomation(105, 5, sdf.parse("28/10/2025"))));
        } catch (ParseException e) {
            System.err.println("Error creating sample data: " + e.getMessage());
        }
    }
}
