
package Candidate.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Candidate {
    private String id;
    private String finame;
    private String laname;
    private Date dob;
    private String address;
    private String phone;
    private String email;
    final static String DATE_FORMAT = "dd/MM/yyyy";

    public Candidate(String id, String finame, String laname, Date dob, String address, String phone, String email) {
        this.id = id;
        this.finame = finame;
        this.laname = laname;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        
    }

    public Candidate() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFiname() {
        return finame;
    }

    public void setFiname(String finame) {
        this.finame = finame;
    }

    public String getLaname() {
        return laname;
    }

    public void setLaname(String laname) {
        this.laname = laname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    
    public static String center(Object o, int width) {
        String s = (o == null) ? "" : o.toString();        
        int padding = width - s.length();
        if (padding <= 0) {
            return s;
        }
        int left = padding / 2;
        int right = padding - left;
        return " ".repeat(left) + s + " ".repeat(right);
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);       
        return String.format("|%s|%s|%s|%s|%s|%s|%s|", 
            center(this.getId(), 15),
            center(this.getFiname(), 20),
            center(this.getLaname(), 20),        
            center(sdf.format(this.getDob()), 15),         
            center(this.getAddress(), 20),
            center(this.getPhone(), 12),
            center(this.getEmail(), 20)
            

            
     );        
    }
    
    
}
