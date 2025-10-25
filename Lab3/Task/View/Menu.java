package Task.View;

import java.util.ArrayList;

public abstract class Menu {
    
    private String title;
    private ArrayList<String> options;
    private boolean isStop;
    
    public Menu(String title, String[] options) {
        this.title = title;
        this.options = new ArrayList<>();
        for (String option : options) {
            this.options.add(option);
        }
        this.isStop = false;
    }
    
    public void display() {
        System.out.println(this.title);
        System.out.println("--------------------------------");
        for (int i = 0; i < this.options.size(); i++) {
            System.out.println("Enter " + (i + 1) + ". " + this.options.get(i));
        }
        System.out.println("--------------------------------");
    }
    
    public int getSelected() {
        this.display();
        return Validator.getIntNoLimit("Enter choice: ");
    }
    
    public abstract void execute(int choice);
    
    protected void stop() {
        this.isStop = true;
    }
    
    public void run() {
        while (!this.isStop) {
            int choice = getSelected();
            this.execute(choice);
        }
    }
}
