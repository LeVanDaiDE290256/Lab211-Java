package Task.View;

import Task.Model.Task;
import Task.Model.TaskList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;


public class TaskView {
    private final TaskList list;

    public TaskView(TaskList list) {
        this.list = list;
    }

    
    public Task create(TaskList list) {
        System.out.println("---------Add Task---------");

        int ID = ID();
        System.out.println("Task ID: " + ID());
        String Name = Validator.getString("Requirement Name: ");        
        String Type = Validator.getStringTypeTask("Task type (1-4): ");
        switch(Type){
            case "1" ->{
                Type = "Code";
            }
            case "2" ->{
                Type = "Test";
            }
            case "3" ->{
                Type = "Design";
            }
            default -> Type = "Review";
        }
        Date date = Validator.getDate("Date "); 
        double from, to;
        while(true){
                from = Validator.getTime("From (8.0 - 17.5): ");
                to = Validator.getTime("To (8.0 - 17.5): ");
                if(from < to){
                    break;
                }else{
                    System.err.println("Plan From must be less than Plan To. Enter again: ");
                }
        }
        double time = to - from;
        String assign = Validator.getString("Assigne: ");   
        String reviewer = Validator.getString("Reviewer: ");   
        System.out.println("\u001B[32mAdded successfully.\u001B[0m");
        return new Task(ID, Name, Type, date, time, assign, reviewer);        
    }    
        public int ID(){
            int count = 1;
            for(Task c : list){
                count ++;
            }
            return count;
        }
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("\u001B[33mThis is empty list.\u001B[0m");
            return;
        }        
        printHeader("==== TASK LIST MANAGEMENT ====");
        for (Task ds : list.displayAll()) {
            System.out.println(ds);
        }        
        count(list);
    }    
    
    private void printHeader(String title) {
        printCenteredTitle(title, 103);
        System.out.println("-".repeat(103));
        System.out.printf("|%-5s|%-20s|%-15s|%-15s|%-10s|%-15s|%-15s| \n",
                center("ID", 5),
                center("Name", 20),
                center("Task Type", 15),
                center("Date", 15),
                center("Time", 10),
                center("Assignee", 15),
                center("Reviewer", 15)
        );
        System.out.println("-".repeat(103));
    }

    public void count(List<Task> result) {
        System.out.println("-".repeat(103));
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
    public void deleteBy() {
        if (list.isEmpty()) {
            System.out.println("\u001B[33mThis is empty list.\u001B[0m");
            return;
        }        
        int data = Validator.getIntNoLimit("Enter ID of Task to delete: ");
        Predicate<Task> condition = b -> b.getID() == data;        
        boolean dl = list.deleteIf(condition);
        if (dl) {
            int count = 1;
            for(Task resetID : list){
                resetID.setID(count);
                count ++;
            }
            System.out.println("\u001B[32mID of contacts have updated successfully.\u001B[0m");
            System.out.println("\u001B[32mDeleted successfully.\u001B[0m");
        } else {
            System.out.println("\u001B[33mTask not found.\u001B[0m");
        }  
        
    }
}
