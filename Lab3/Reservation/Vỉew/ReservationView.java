package Reservation.Vỉew;

import Reservation.Model.FlightInfomation;
import Reservation.Model.Reservation;
import Reservation.Model.ReservationList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;


public class ReservationView {
    private final ReservationList list;

    public ReservationView(ReservationList list) {
        this.list = list;
    }
    public Reservation create(ReservationList list) {
        System.out.println("----- Enter infomation of Reservation -----");

        String data;
        boolean isFound;
        do {
            data = Validator.getStringID("Enter ID of Reservation [6 numbers]: ");
            isFound = list.isDuplicate(data);
            if (isFound) {
                  System.out.println("\u001B[33mReservation is exist. Enter again.\u001B[0m");               
            }
        } while (isFound);            
        String name = Validator.getStringAlpha("Enter customer name of Reservation: ");        
        String phone = Validator.getStringPhone("Enter phone number of Reservation [10 numbers]: ");        
        String roomNumber = Validator.getStringRoomNumber("Enter room number of Reservation [4 numbers]: ");
        Date date = Validator.getDateAfterToday("Enter date time Reservation [after today]");
        
        int flightNumber = Validator.getInt("Enter flight number of Reservation: ", 0, Integer.MAX_VALUE);
        int seatNumber = Validator.getInt("Enter seat number of Reservation: ", 0, Integer.MAX_VALUE);
        Date timePickUp;
        while(true){
            timePickUp = Validator.getTimePickUp("Enter time pick up of Reservation [after today & before booking date]");
            if(timePickUp.before(date)){
                break;
            }
            else {
                System.err.println("Time pick up must be after today and before booking date. Please enter again.");
            }
        }
        FlightInfomation flight = new FlightInfomation(flightNumber, seatNumber, timePickUp);
        System.out.println("\u001B[32mAdded successfully.\u001B[0m");
        return new Reservation(data, name, phone,roomNumber, timePickUp, flight);        
    }    
    
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("\u001B[33mThis is empty list.\u001B[0m");
            return;
        }        
        printHeader("====  RESERVATION LIST MANAGEMENT  ====");
        for (Reservation ds : list.displayAll()) {
            System.out.println(ds);
        }        
        count(list);
    }    
    
    private void printHeader(String title) {
        printCenteredTitle(title, 139);
        System.out.println("-".repeat(139));
        System.out.printf("|%-15s|%-20s|%-15s|%-15s|%-15s|%-10s|%-10s|%-15s| \n",
                center("Booking ID", 15),
                center("Customer name", 20),
                center("Phone number", 15),
                center("Room number", 15),
                center("Date time", 15),
                center("Flight number", 20),
                center("Seat number", 15),
                center("Time pick up", 15)
        );
        System.out.println("-".repeat(139));
    }

    public void count(List<Reservation> result) {
        System.out.println("-".repeat(139));
        System.out.println("Total found: " + result.size());
    }

    public static String center(String text, int width) {
        if (text.length() >= width) {
            return text;
        }
        int left = (width - text.length()) / 2;
        int right = width - text.length() - left;
        return " ".repeat(left) + text + " ".repeat(right);
    }

    public static void printCenteredTitle(String title, int width) {
        int padding = (width - title.length()) / 2;
        if (padding < 0) {
            padding = 0;
        }        
        String format = "%" + padding + "s%s%n";
        System.out.printf(format, "", title);
    }    
    
    public void update() {
        if (list.isEmpty()) {
            System.out.println("\u001B[33mThis is empty list.\u001B[0m");
            return;
        }
        String data = Validator.getStringID("Enter ID of Reservation to update [6 numbers]: ");
        Reservation cm = list.search(data);
        if (cm == null) {
            System.out.println("\u001B[33mReservation not found.\u001B[0m");
            return;
        }
        String name = Validator.getStringAlpha("Enter customer name of Reservation: ");        
        String phone = Validator.getStringPhone("Enter phone number of Reservation [10 numbers]: ");        
        String roomNumber = Validator.getStringRoomNumber("Enter room number of Reservation [4 numbers]: ");
        Date date = Validator.getDateAfterToday("Enter date time Reservation [after today]");
        
        int flightNumber = cm.getFlightInfomation().getFlightNumber();
        int seatNumber = cm.getFlightInfomation().getSeatNumber();
        Date timePickUp;
        while(true){
            timePickUp = Validator.getTimePickUp("Enter time pick up of Reservation [after today & before booking date]");
            if(timePickUp.before(date)){
                break;
            }
            else {
                System.err.println("Time pick up must be after today and before booking date. Please enter again.");
            }
        }
        FlightInfomation fi = new FlightInfomation(flightNumber, seatNumber, timePickUp);
        Reservation updated = new Reservation( data, name, phone, roomNumber, date, fi );
        boolean ok = list.update(data, updated);
        System.out.println("\u001B[32mUpdated successfully.\u001B[0m");
    }    
    public void deleteByID() {
        if (list.isEmpty()) {
            System.out.println("\u001B[33mThis is empty list.\u001B[0m");
            return;
        }        
        String data = Validator.getStringID("Enter ID of Reservation to update [6 numbers]: ");
        Predicate<Reservation> condition = b -> b.getBookingID().toLowerCase().contains(data.toLowerCase());        
        boolean dl = list.deleteIf(condition);
        if (dl) {
            System.out.println("\u001B[32mDeleted successfully.\u001B[0m");
        } else {
            System.out.println("\u001B[33mReservation not found.\u001B[0m");
        }        
    }
    public void sortBy() {
        if (list.isEmpty()) {
            System.out.println("\u001B[33mThis is empty list.\u001B[0m");
            return;
        }        
        list.sort();
        System.out.println("\u001B[32mSorted Reservation list by time pick up (ascending):\u001B[0m");
        displayAll();
        
    }
}
