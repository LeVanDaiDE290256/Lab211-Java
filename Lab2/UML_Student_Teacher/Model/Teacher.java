
package UML_Student_Teacher.Model;

import UML_Student_Teacher.View.Validator;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Teacher extends  Person{
    private double yop;

    public Teacher(double yop, String id, String fullname, String phone, Date yob, String major) {
        super(id, fullname, phone, yob, major);
        this.yop = yop;
    }

    

    public Teacher() {
        super();
    }

    public double getYop() {
        return yop;
    }

    public void setYop(double yop) {
        this.yop = yop;
    }
    
    public double getAge() {        
        Date today = new Date();
        long diff = today.getTime() - this.getYob().getTime();
        return diff / (1000.0 * 60 * 60 * 24 * 365);
    }
    
    public void inputAll(PersonList plist) {
        this.id = Validator.getUniqueId("Enter ID (6 digits): ", plist);
        this.fullname = Validator.getStringName("Enter name (alphabet & blank): ");
        this.phone = Validator.getStringPhone("Enter phone number (12 digits): ");
        this.yob = Validator.getDateBeforeToday("Enter date of birth (date before current year)");
        this.major = Validator.getStringMax30("Enter major (string no more than 30 characters): "); 
        double year = Validator.getYearInProfession("Enter number of year in the profession: ", 0, getAge());
        this.setYop(year);
    }
    @Override
    public String toString() {
        return  
                " | Teacher -> " + 
                " | Year in the profession: " + this.getYop() +
                super.toString();
    }
    
}
