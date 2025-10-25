
package Candidate.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class CandidateList extends ArrayList<Candidate>{
    
    final static String DATE_FORMAT = "dd/MM/yyyy";

    public CandidateList() {
    }

    public Candidate search(String data) {
        for (Candidate index : this) {
            if (index.getId().equalsIgnoreCase(data)) {
                return index;
            }
        }
        return null;
    }

    public boolean isDuplicate(String data) {
        return this.search(data) != null;
    }
    
  

    public void addNew(Candidate b) {
        super.add(b);        
    }
    
    public ArrayList<Candidate> search(Predicate<Candidate> condition) {
        ArrayList<Candidate> result = new ArrayList<>();
        for (Candidate b : this) {
            if (condition.test(b)) {
                result.add(b);
            }
        }
        return result;
    }
    
    public List<Candidate> displayAll() {
        return this;
    }
        
}
