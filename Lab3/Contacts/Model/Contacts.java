package Contacts.Model;


public class Contacts {
    private int id;
    private String fullname;
    private String fname;
    private String lname;
    private String group;
    private String address;
    private String phone;

    public Contacts(int id, String fullname, String fname, String lname, String group, String address, String phone) {
        this.id = id;
        this.fullname = fullname;
        this.fname = fname;
        this.lname = lname;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public Contacts() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getGroup() {
        return group;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return String.format("|%s|%s|%s|%s|%s|%s|%s|", //
            center(this.getId(), 5),
            center(this.getFullname(), 20),
            center(this.getFname(), 10),
            center(this.getLname(), 10),
            center(this.getGroup(), 10),
            center(this.getAddress(), 15),
            center(this.getPhone(), 15)
            
);        
    }
    
    
}
