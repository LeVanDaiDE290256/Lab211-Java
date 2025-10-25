
package Candidate.Model;

import java.util.Date;


public class Intern extends Candidate{
    private String mj;
    private String semester;
    private String uname;

    public Intern(String mj, String semester, String uname, String id, String finame, String laname, Date dob, String address, String phone, String email) {
        super(id, finame, laname, dob, address, phone, email);
        this.mj = mj;
        this.semester = semester;
        this.uname = uname;
    }

    public Intern() {
        super();
    }

    public String getMj() {
        return mj;
    }

    public void setMj(String mj) {
        this.mj = mj;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return super.toString() + " -> Intern " + "| Major: " + this.getMj() + "| Semester: " + this.getSemester() + "| University name: " + this.getUname();
    }
    
}
