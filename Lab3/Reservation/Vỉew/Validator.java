package Reservation.Vỉew;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Validator {
    
    final static String DATE_FORMAT = "dd/MM/yyyy";
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
    public static String getStringAlpha(String msg) {
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
    public static String getStringPhone(String msg) {
        String value = null;
        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }

            value = scanner.nextLine().trim();

            // Kiểm tra không rỗng và chỉ chứa đúng 6 chữ số
            if (!value.isEmpty() && value.matches("^\\d{10}$")) {
                break;
            }

            System.err.println("Invalid input. Please enter exactly 6 digits (0-9).");
        }
        return value;
    }
    public static String getStringRoomNumber(String msg) {
        String value = null;
        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }

            value = scanner.nextLine().trim();

            // Kiểm tra không rỗng và chỉ chứa đúng 6 chữ số
            if (!value.isEmpty() && value.matches("^\\d{4}$")) {
                break;
            }

            System.err.println("Invalid input. Please enter exactly 6 digits (0-9).");
        }
        return value;
    }
    public static Date getDateAfterToday(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        Date today = new Date();        
        
        while (true) {
            try {
                System.out.print(msg + " (" + DATE_FORMAT + "): ");
                Date inputDate = sdf.parse(scanner.nextLine().trim());
                
                if (!inputDate.after(today)) {
                    System.err.println("Date must be after today. Please enter a future date.");
                    continue;
                }
                
                return inputDate;
            } catch (ParseException e) {
                System.err.println("Invalid date format (" + DATE_FORMAT + "). Please enter again.");
            }
        }
    }
    public static Date getTimePickUp(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        Date today = new Date();        
        
        while (true) {
            try {
                System.out.print(msg + " (" + DATE_FORMAT + "): ");
                Date inputDate = sdf.parse(scanner.nextLine().trim());
                
                if (!inputDate.after(today)) {
                    System.err.println("Date must be after today. Please enter a future date.");
                    continue;
                }
                
                return inputDate;
            } catch (ParseException e) {
                System.err.println("Invalid date format (" + DATE_FORMAT + "). Please enter again.");
            }
        }
    }
}
