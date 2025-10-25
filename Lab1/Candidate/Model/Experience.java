
package Candidate.Model;

import java.util.Date;


public class Experience extends Candidate{
    private double yoe;
    private String ps;

    public Experience(double yoe, String ps, String id, String finame, String laname, Date dob, String address, String phone, String email) {
        super(id, finame, laname, dob, address, phone, email);
        this.yoe = yoe;
        this.ps = ps;
    }

    public Experience() {
        super();
    }

    public double getYoe() {
        return yoe;
    }

    public void setYoe(double yoe) {
        this.yoe = yoe;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    @Override
    public String toString() {
        return super.toString() + " -> Experience " + "| Year of experience: " + this.getYoe() + "| Personal skills: " + this.getPs();
    }
    
    
}
