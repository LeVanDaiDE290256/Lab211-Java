
package UML_Student_Teacher.Model;

import UML_Student_Teacher.View.Validator;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Student extends Person{
    private Date yoa;
    private double score;

    public Student() {
        super();
    }
    public Student(Date yoa, double score, String id, String fullname, String phone, Date yob, String major) {
        super(id, fullname, phone, yob, major);
        this.yoa = yoa;
        this.score = score;
    }

    public Date getYoa() {
        return yoa;
    }

    public void setYoa(Date yoa) {
        this.yoa = yoa;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    
    public void inputAll(PersonList plist) {
        this.id = Validator.getUniqueId("Enter ID (6 digits): ", plist); 
        this.fullname = Validator.getStringName("Enter name (alphabet & blank): ");
        this.phone = Validator.getStringPhone("Enter phone number (12 digits): ");
        this.yob = Validator.getDateBeforeToday("Enter date of birth (date before current year)");
        this.major = Validator.getStringMax30("Enter major (string no more than 30 characters): ");
        Date yoa = Validator.getYearOfAddmission("Enter year of admission (between birth year and current year)", this.getYob());
        this.setYoa(yoa);
        double score = Validator.getDouble("Enter Entrance English score (from 0 to 100): ", 0, 100);
        this.setScore(score);
    }
    
    
    final static String DATE_FORMAT = "yyyy";

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return  " | Student -> " +
                " | Year of admission: " + sdf.format(this.getYoa())+
                " | Entrance English score: " + this.getScore()+
                super.toString() ;
                
    }
    
    
}
