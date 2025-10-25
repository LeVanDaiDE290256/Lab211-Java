
package UML_Student_Teacher.Model;

import UML_Student_Teacher.View.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonList {

    public PersonList() {
        super();
    }
    ArrayList<Teacher> tc = new ArrayList<>();
    ArrayList<Student> st = new ArrayList<>();   
    ArrayList<Person> ps = new ArrayList<>();
    public void createTeacher(){
        int n = Validator.getInt("Enter number of Teacher: ", 0, Integer.MAX_VALUE);
        for( int i = 1; i <= n; i++ ){
            System.out.println("\nEnter infomation of Teacher number " + i + ": ");
            Teacher teacher = new Teacher();
            teacher.inputAll(this);
            tc.add(teacher);
            ps.add(teacher);
        }
    }
    public void createStudent(){
        int n = Validator.getInt("Enter number of Student: ", 0, Integer.MAX_VALUE);
        for( int i = 1; i <= n; i++ ){
            System.out.println("\nEnter infomation of Student number " + i + ": ");
            Student student = new Student();
            student.inputAll(this);
            st.add(student);
            ps.add(student);
        }

    }
    public void printTeacher(){   
        if(tc.isEmpty()){
            System.out.println("This is empty list.");
            return;
        }
        Collections.sort(tc, Comparator.comparing(Teacher::getYop).reversed());        
        tc.forEach(TC -> {
            System.out.print(TC.toString());
        });
        System.out.println("");
    }
    public void printStudent(){ 
        if(st.isEmpty()){
            System.out.println("This is empty list.");
            return;
        }
        Collections.sort(st, Comparator.comparing(Student::getYoa));        
        st.forEach(ST -> {
            System.out.print(ST.toString());
        });
        System.out.println("");
    }
    
    public void searchByName() {
        if (ps.isEmpty()) {
            System.out.println("This is empty list.");
            return;
        }

        String data = Validator.getString("Enter name to search: ");

        List<Person> re = ps.stream()
            .filter(p -> p.getFullname() != null &&
                         p.getFullname().toLowerCase().contains(data.toLowerCase()))
            .sorted(Comparator.comparing(Person::getYob).reversed())
            .collect(Collectors.toList()); // <- mutable

        if (re.isEmpty()) {
            System.out.println("No matching found.");
            return;
        }

        re.forEach(st -> System.out.print(st.toString()));
    }
            
    public boolean isDuplicateId(String id) {
        for (Person p : ps) {
            if (p.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    
}

