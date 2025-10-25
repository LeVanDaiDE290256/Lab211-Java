
package Candidate.Controller;

import Candidate.Model.Candidate;
import Candidate.Model.CandidateList;
import Candidate.View.CandidateView;
import Candidate.View.Menu;



public class Management extends Menu {

    CandidateList list = new CandidateList();
    CandidateView view = new CandidateView(list);
    public Management(String title, String[] options) {
        super(title, options);
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 ->
                view.displayAll();                
            case 2 ->{
                Candidate b = view.create(list);
                list.add(b);                
            }                
            case 3 ->{          
                view.searchByCandidate();
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
        new Management("\n====CANDIDATE LIST MANAGEMENT====", new String[]{
            "Display all Candidates.",
            "Add new Candidate.",
            "Search Candidate by ID. ",     
            "Exit.",}).run();
    }  
}
