package Contacts.Controller;

import Contacts.Model.Contacts;
import Contacts.Model.ContactsList;
import Contacts.View.ContactsView;
import Contacts.View.Menu;


public class Management extends Menu {

    ContactsList list = new ContactsList();
    ContactsView view = new ContactsView(list);
    public Management(String title, String[] options) {
        super(title, options);
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 ->
                view.displayAll();                
            case 2 ->{
                Contacts b = view.create(list);
                list.add(b);                
            }                
            case 3 ->{          
                view.deleteByID();
            }                
            case 4 -> {               
                this.stop();
                System.out.println("\u001B[32mExited.\u001B[0m");
            }           
            default ->
                System.err.println("Invalid.");
        }
    }

    public static void main(String[] args) {
        new Management("\n====CONTACTS LIST MANAGEMENT====", new String[]{
            "Display all Contactss.",
            "Add new Contacts.",
            "Delete Contacts by ID. ",
            "Exit.",}).run();
    }  
}
