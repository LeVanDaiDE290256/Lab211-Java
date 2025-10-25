
package Candidate.View;

import Candidate.Model.Candidate;
import Candidate.Model.CandidateList;
import Candidate.Model.Experience;
import Candidate.Model.Fresher;
import Candidate.Model.Intern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;




public class CandidateView {
    private final CandidateList list;

    public CandidateView(CandidateList list) {
        this.list = list;
    }

    
    public Candidate create(CandidateList list) {
        System.out.println("===Enter infomation of Candidate===");

        String data;
        boolean isFound;
        do {
            data = Validator.getString("Enter ID of Candidate: ");
            isFound = list.isDuplicate(data);
            if (isFound) {
                  System.out.println("\u001B[33mCandidate is exist. Enter again.\u001B[0m");               
            }
        } while (isFound);            
        String fn = Validator.getStringAlpha("Enter first name of Candidate: ");        
        String name = Validator.getStringAlpha("Enter last name of Candidate: "); 
        Date dob = Validator.getDateBeforeToday("Date of birth of Candidate");
        String add = Validator.getString("Enter address of Candidate: ");        
        String phone = Validator.getString("Enter phone of Candidate: ");    
        String email = Validator.getString("Enter email of Candidate: ");    
        
        int num = Validator.getInt("==Enter type of Candidate==\n"
                + "1.Experience\n"
                + "2.Fresher\n"
                + "3.Intern\n"
                + "Enter choice: ", 1, 3);
         
        Candidate candidate = null;
        switch (num) {
            case 1:
                double expYear = Validator.getDouble("Enter year of experience: ", 0, 50);
                String proSkill = Validator.getString("Enter professional skill: ");
                candidate = new Experience(expYear, proSkill, data, fn, name, dob, add, phone, email);
                break;

            case 2:
                Date gradDate = Validator.getDate("Enter graduation date: ");
                String gradRank = Validator.getString("Enter graduation rank: ");
                String university = Validator.getString("Enter university: ");
                candidate = new Fresher(gradDate, gradRank, university, data, fn, name, dob, add, phone, email);
                break;

        case 3:
                String major = Validator.getString("Enter major: ");
                String semester = Validator.getString("Enter semester: ");
                String uni = Validator.getString("Enter university: ");
                candidate = new Intern(major, semester, uni, data, fn, name, dob, add, phone, email);
                break;
    }
        System.out.println("\u001B[32mAdded successfully.\u001B[0m");
        return candidate;
    }    
    
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("\u001B[33mThis is empty list.\u001B[0m");
            return;
        }        
        printHeader("==== CANDIDATE LIST MANAGEMENT ====");
        for (Candidate ds : list.displayAll()) {
            System.out.println(ds);
        }        
        count(list);
    }    
    
    private void printHeader(String title) {
        printCenteredTitle(title, 130);
        System.out.println("-".repeat(130));
        System.out.printf("|%-15s|%-20s|%-20s|%-15s|%-20s|%-12s|%-20s| \n",
                center("ID", 15),
                center("Last Name", 20),
                center("First Name", 20),
                center("Date of Birth", 15),
                center("Address", 20),
                center("Phone", 12),
                center("Email", 20)
        );
        System.out.println("-".repeat(130));
    }

    public void count(List<Candidate> result) {
        System.out.println("-".repeat(130));
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
    
    public void searchByCandidate() {
        if (list.isEmpty()) {
            System.out.println("\u001B[33mThis is empty list.\u001B[0m");
            return;
        }        
        String data = Validator.getString("Enter data of Candidate to search: ");
        Predicate<Candidate> condition = cb
                -> cb.getId().toLowerCase().contains(data.toLowerCase());
        ArrayList<Candidate> rs = list.search(condition);        
        if (rs.isEmpty()) {
            System.out.println("\u001B[33mNo matching Candidate found.\u001B[0m");
        } else {
            printHeader("==== Candidate need to search ==== ");
            for (Candidate cb : rs) {
                System.out.println(cb);                
            }            
            count(rs);
        }        
    }
}
