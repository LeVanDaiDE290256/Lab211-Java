package Contacts.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class ContactsList extends ArrayList<Contacts>{
    public ContactsList() {
        super();
    }



    
    public Contacts search(int data) {
        for (Contacts index : this) {
            if (index.getId() == data ) {
                return index;
            }
        }
        return null;
    }

    public boolean isDuplicate(int data) {
        return this.search(data) != null;
    }
    

    public void addNew(Contacts b) {
        super.add(b);        
    }
    
    public ArrayList<Contacts> search(Predicate<Contacts> condition) {
        ArrayList<Contacts> result = new ArrayList<>();
        for (Contacts b : this) {
            if (condition.test(b)) {
                result.add(b);
            }
        }
        return result;
    }
    
    public List<Contacts> displayAll() {
        return this;
    }
    
    public boolean deleteIf(Predicate<Contacts> condition) {
        boolean rm = this.removeIf(condition);
        if (rm) {            
        }
        return rm;        
    }
    
}
