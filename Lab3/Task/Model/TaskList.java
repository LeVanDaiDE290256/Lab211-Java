package Task.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class TaskList extends ArrayList<Task>{
    final static String DATE_FORMAT = "dd-MM-yyyy";

    public TaskList() {
        super();
    }

    public Task search(int data) {
        for (Task index : this) {
            if (index.getID() == data) {
                return index;
            }
        }
        return null;
    }

    public boolean isDuplicate(int data) {
        return this.search(data) != null;
    }
    
    

    public void addNew(Task b) {
        super.add(b);        
    }
    
    public ArrayList<Task> search(Predicate<Task> condition) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task b : this) {
            if (condition.test(b)) {
                result.add(b);
            }
        }
        return result;
    }
    
    public List<Task> displayAll() {
        return this;
    }
    
    public boolean deleteIf(Predicate<Task> condition) {
        boolean rm = this.removeIf(condition);
        if (rm) {            
        }
        return rm;        
    }
}
