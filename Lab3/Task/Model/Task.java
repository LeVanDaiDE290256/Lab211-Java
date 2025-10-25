package Task.Model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Task {
    private int ID;
    private String name;
    private String type;
    private Date date;
    private double time;
    private String assign;
    private String reviewer;
    
    final static String DATE_FORMAT = "dd-MM-yyyy";

    public Task(int ID, String name, String type, Date date, double time, String assign, String reviewer) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.date = date;
        this.time = time;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public Task() {
        super();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
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
            center(this.getID(), 5),
            center(this.getName(), 20),
            center(this.getType(), 15),
            center(sdf.format(this.getDate()), 15),
            center(this.getTime(), 10),
            center(this.getAssign(), 15),
            center(this.getReviewer(), 15)
);        
    }
    
    
}
