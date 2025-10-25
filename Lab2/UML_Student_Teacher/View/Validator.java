
package UML_Student_Teacher.View;


import UML_Student_Teacher.Model.Person;
import UML_Student_Teacher.Model.PersonList;
import UML_Student_Teacher.Model.Student;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validator {
    
    final static String DATE_FORMAT = "yyyy";
    private static final Scanner scanner = new Scanner(System.in);
    public static int getIntNoLimit(String msg) { //Nhập int, không giới hạn, có thông báo.
        return getInt(msg, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static int getInt(String msg, int minRange, int maxRange) { //Nhập Int, có giới hạn, có thông báo
        if (minRange > maxRange) {
            int temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }
        while (true) {
            System.out.print(msg);
            try {
                int value = Integer.parseInt(scanner.nextLine());
                
                if (value >= minRange && value <= maxRange) {
                    return value;
                }
                System.err.printf("Value must be greater or equals to 0.\n ");
                //System.err.printf("Value must be between %d and %d.\n ", minRange, maxRange);
            } catch (NumberFormatException e) {
                System.err.println("Invalid Integer format. Please enter again. ");
            }
        }
    } ////Nhập int, có giới hạn, có thông báo.
    public static double getDouble(String msg, double minRange, double maxRange) {
        if (minRange > maxRange) {
            double temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }
        
        while (true) {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }
                
                double value = Double.parseDouble(scanner.nextLine());
                
                if (value >= minRange && value <= maxRange) {
                    return value;
                }
                System.err.printf("Value must be greater or equals to 0.\n ");
                //System.err.printf("Value must be between %.2f and %.2f.\n", minRange, maxRange);

            } catch (NumberFormatException e) {
                System.err.println("Invalid Double format. Please enter again ");
            }
        }
    } //Nhập double, có giới hạn, có thông báo.
    public static double getYearInProfession(String msg, double minRange, double maxRange) {
        if (minRange > maxRange) {
            double temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }
        
        while (true) {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }
                
                double value = Double.parseDouble(scanner.nextLine());
                
                if (value >= minRange && value <= maxRange) {
                    return value;
                }
                //System.err.printf("Value must be greater or equals to 0.\n ");
                System.err.printf("Value must be between %.2f and %.2f.\n", minRange, maxRange);

            } catch (NumberFormatException e) {
                System.err.println("Invalid Double format. Please enter again ");
            }
        }
    } //Nhập double, có giới hạn, có thông báo.
    public static String getStringPhone(String msg) {
        String value = null;
        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }

            value = scanner.nextLine().trim();

            // Kiểm tra không rỗng và chỉ chứa đúng 12 chữ số
            if (!value.isEmpty() && value.matches("^\\d{12}$")) {
                break;
            }

            System.err.println("Invalid input. Please enter exactly 12 digits (0-9).");
        }
        return value;
    }
    public static String getStringName(String msg) {
        String value = null;
        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }
            
            value = scanner.nextLine().replaceAll("\\s+", " ").trim();

            // Kiểm tra không rỗng và chỉ chứa chữ cái + khoảng trắng
            if (!value.isEmpty() && value.matches("^[A-Za-z ]+$")) {
                break;
            }
            
            System.err.println("Invalid input. Please enter letters only (no numbers or special characters).");
        }
        return value;
    }
    public static String getStringID(String msg) {
        String value = null;
        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }

            value = scanner.nextLine().trim();

            // Kiểm tra không rỗng và chỉ chứa đúng 6 chữ số
            if (!value.isEmpty() && value.matches("^\\d{6}$")) {
                break;
            }

            System.err.println("Invalid input. Please enter exactly 6 digits (0-9).");
        }
        return value;
    }

    public static String getString(String msg) {
        String value = null;
        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }
            value = scanner.nextLine().replaceAll("\\s+", " ").trim();
            if (!value.isEmpty() && !value.isBlank()) {
                break;
            }
            System.err.println("Invalid String format. Enter again.");
        }
        return value;
    }
    
    public static String getStringMax30(String msg) {
        String value = null;
        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }

            value = scanner.nextLine().replaceAll("\\s+", " ").trim();

            // Kiểm tra: không rỗng, chỉ chứa chữ + khoảng trắng, và <= 30 ký tự
            if (!value.isEmpty() && value.matches("^[A-Za-z ]+$") && value.length() <= 30) {
                break;
            }

            System.err.println("Invalid input. Please enter letters only (max 30 characters).");
        }
        return value;
    }
    
    

    public static Date getDateBeforeToday(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        Date today = new Date();        
        
        while (true) {
            try {
                System.out.print(msg + " (" + DATE_FORMAT + "): ");
                Date inputDate = sdf.parse(scanner.nextLine().trim());
                
                if (inputDate.after(today)) {
                    System.err.println("Date cannot be in the future. Please enter a valid date.");
                    continue;
                }
                
                return inputDate;
            } catch (ParseException e) {
                System.err.println("Invalid date format (" + DATE_FORMAT + "). Please enter again.");
            }
        }
    }    
    public static Date getYearOfAddmission(String msg, Date birthyear) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        sdf.setLenient(false);
        Date today = new Date();        
        
        while (true) {
            try {
                System.out.print(msg + " (yyyy): ");
                Date inputDate = sdf.parse(scanner.nextLine().trim());
                if (inputDate.after(today) || inputDate.before(birthyear)) {
                    System.err.println("Year between birth year and current year. Please enter a valid year.");
                    continue;
                }
                
                return inputDate;
            } catch (ParseException e) {
                System.err.println("Invalid date format (yyyy). Please enter again.");
            }
        }
    }    
    public static String getUniqueId(String msg, PersonList plist) {
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.print(msg);
            id = getStringID("").trim();
            if (plist.isDuplicateId(id)) {
                System.err.println("ID already exists. Please enter again.");
                continue;
            }
            return id; 
        }
    }

    
    
     
}
