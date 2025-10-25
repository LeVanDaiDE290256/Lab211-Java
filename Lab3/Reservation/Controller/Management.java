package Reservation.Controller;

import Reservation.Model.Reservation;
import Reservation.Model.ReservationList;
import Reservation.Vỉew.Menu;
import Reservation.Vỉew.ReservationView;


public class Management extends Menu {

    ReservationList list = new ReservationList();
    ReservationView view = new ReservationView(list);
    public Management(String title, String[] options) {
        super(title, options);
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 ->
                view.displayAll();                
            case 2 ->{
                Reservation b = view.create(list);
                list.add(b);                
            }                
            case 3 ->{          
                view.deleteByID();
            }                
            case 4 ->{
                  view.update();
            }        
            case 5 ->{
                  view.sortBy();
            }                      
            case 6 -> {               
                this.stop();
                System.out.println("\u001B[32mExited.\u001B[0m");
            }           
            default ->
                System.err.println("Invalid.");
        }
    }

    public static void main(String[] args) {
        new Management("\n====RESERVATION LIST MANAGEMENT====", new String[]{
            "Display all Reservations.",
            "Add new Reservation.",
            "Delete Reservation by Booking ID",
            "Update Reservation by Booking ID",
            "Display sorted by time pick up.",
            "Exit.",}).run();
    }  
}
