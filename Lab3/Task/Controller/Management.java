package Task.Controller;

import Task.Model.Task;
import Task.Model.TaskList;
import Task.View.Menu;
import Task.View.TaskView;


public class Management extends Menu {

    TaskList list = new TaskList();
    TaskView view = new TaskView(list);
    public Management(String title, String[] options) {
        super(title, options);
    }
    
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 ->
                view.displayAll();                
            case 2 ->{
                Task b = view.create(list);
                list.add(b);                
            }                
            case 3 ->{          
                view.deleteBy();
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
        new Management("\n====TASK LIST MANAGEMENT====", new String[]{
            "Display all Tasks.",
            "Add new Task.",
            "Delete Task by ID ",
            "Exit.",}).run();
    }  
}
