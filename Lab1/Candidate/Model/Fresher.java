
package Candidate.Model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Fresher extends Candidate{
    private Date gt;
    private String gr;
    private String university;
    final static String DATE_FORMAT = "dd/MM/yyyy";

    public Fresher(Date gt, String gr, String university, String id, String finame, String laname, Date dob, String address, String phone, String email) {
        super(id, finame, laname, dob, address, phone, email);
        this.gt = gt;
        this.gr = gr;
        this.university = university;
    }

    public Fresher() {
        super();
    }

    public Date getGt() {
        return gt;
    }

    public void setGt(Date gt) {
        this.gt = gt;
    }

    public String getGr() {
        return gr;
    }

    public void setGr(String gr) {
        this.gr = gr;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() { 
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return super.toString()+ " -> Fresher " + "|Graduated date: " + sdf.format(this.getGt()) + "|Graduated rank: " + this.getGr() + "|University: " + this.getUniversity();
    }
    
}
