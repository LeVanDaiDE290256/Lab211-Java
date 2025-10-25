package Contacts.View;

import Contacts.Model.Contacts;
import Contacts.Model.ContactsList;
import java.util.List;
import java.util.function.Predicate;


public class ContactsView {
    private final ContactsList list;

    public ContactsView(ContactsList list) {
        this.list = list;
    }

    
    public Contacts create(ContactsList list) {
        System.out.println("===Enter infomation of Contacts===");
        int id = ID();
        System.out.println("ID of contact: " + ID());
        String title = Validator.getStringAlpha("Enter Fullname of Contacts: ");  
        String[] parts = title.split("\\s+");
        String fistname = parts[0].trim();
        System.out.println("Fist name of contact: " + fistname);
        String lastname;
        if(parts.length != 1){
            lastname = parts[1].trim();
        }
        else {
            lastname = " ";
        }
        System.out.println("Last name of contact: " + lastname);
        String group = Validator.getString("Enter group of Contacts: ");  
        String address = Validator.getString("Enter address of Contacts: ");  
        String phone = Validator.getStringPhone("Please input Phone flow\n" +
                                                "• 1234567890\n" +
                                                "• 123-456-7890\n" +
                                                "• 123-456-7890 x1234\n" +
                                                "• 123-456-7890 ext1234\n" +
                                                "• (123)-456-7890\n" +
                                                "• 123.456.7890\n" +
                                                "• 123 456 7890\n "
                + "Enter phone: ");  
        System.out.println("\u001B[32mAdded successfully.\u001B[0m");
        return new Contacts(id, title, fistname, lastname, group, address, phone);        
    }    
    public int ID(){
        int count = 1;
        for(Contacts c : list){
            count ++;
        }
        return count;
    }
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("\u001B[33mThis is empty list.\u001B[0m");
            return;
        }        
        printHeader("==== CONTACTS LIST MANAGEMENT ====");
        for (Contacts ds : list.displayAll()) {
            System.out.println(ds);
        }        
        count(list);
    }    
    
    private void printHeader(String title) {
        printCenteredTitle(title, 93);
        System.out.println("-".repeat(93));
        System.out.printf("|%-5s|%-20s|%-10s|%-10s|%-10s|%-15s|%-15s| \n",
                center("ID", 5),
                center("Full name", 20),
                center("First name", 10),
                center("Last name", 10),
                center("Group", 10),
                center("Address", 15),
                center("Phone", 15)
        );
        System.out.println("-".repeat(93));
    }

    public void count(List<Contacts> result) {
        System.out.println("-".repeat(93));
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
    public void deleteByID() {
        if (list.isEmpty()) {
            System.out.println("\u001B[33mThis is empty list.\u001B[0m");
            return;
        }        
        int data = Validator.getIntNoLimit("Enter ID of Contacts to delete: ");
        Predicate<Contacts> condition = b -> b.getId() == data;        
        boolean dl = list.deleteIf(condition);
        if (dl) {
            System.out.println("\u001B[32mDeleted successfully.\u001B[0m");
            int count = 1;
            for(Contacts resetID : list){
                resetID.setId(count);
                count ++;
            }
            System.out.println("\u001B[32mID of contacts have updated successfully.\u001B[0m");
        } else {
            System.out.println("\u001B[33mContacts not found.\u001B[0m");
        }  
        
    }
}
