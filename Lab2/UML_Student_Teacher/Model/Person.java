
package UML_Student_Teacher.Model;

import UML_Student_Teacher.View.Validator;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Person {
    String id;
    String fullname; 
    String phone;
    Date yob;
    String major;

    public Person() {
        super();
    }

    public Person(String id, String fullname, String phone, Date yob, String major) {
        this.id = id;
        this.fullname = fullname;
        this.phone = phone;
        this.yob = yob;
        this.major = major;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getYob() {
        return yob;
    }

    public void setYob(Date yob) {
        this.yob = yob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    

//        String major = Validator.getStringMax30("Enter major (string no more than 30 characters): ");
//        this.setMajor(major);
//    }
    
    final static String DATE_FORMAT = "yyyy";            

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return  " | ID: "+ this.getId() +
                " | Full name: "+ this.getFullname() +
                " | Phone: "+ this.getPhone() +
                " | Year of birth: "+ sdf.format(this.getYob())  +
                " | Major: "+ this.getMajor() +"\n";
    }
}
