package UML_Student_Teacher.Controller;

import UML_Student_Teacher.Model.PersonList;
import UML_Student_Teacher.View.Menu;
import UML_Student_Teacher.View.Validator;

public class Management extends Menu {

    PersonList list = new PersonList();

    public Management(String title, String[] options) {
        super(title, options);
    }
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 ->{
                list.createTeacher();
                System.out.println("Created successfully.");
            }
            case 2 ->{               
                list.printTeacher();
            }                
            case 3 ->{          
                 list.createStudent();
                 System.out.println("Created successfully.");
            }                
            case 4 ->{
                 list.printStudent();              
            }        
            case 5 ->{
                 list.searchByName();
            }                      
            case 6 -> {               
                this.stop();
                System.out.println("Exited.");
            }           
            default ->
                System.err.println("Invalid.");
        }
    }

    public static void main(String[] args) {
        new Management("\n====PERSON LIST MANAGEMENT====", new String[]{
            "Create n teacher.",
            "Print teacher by year in profession descending.",
            "Create n student.",
            "Print Student by increasing year of admission.",
            "Search person by name.",      
            "Exit.",}).run();
    }  
}
