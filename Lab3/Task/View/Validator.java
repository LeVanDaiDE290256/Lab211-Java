package Task.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Validator {
    
    final static String DATE_FORMAT = "dd-MM-yyyy";
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
    public static String getStringTypeTask(String msg) {
        String value = null;
        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }
            value = scanner.nextLine().trim();

            // Chỉ chấp nhận các giá trị "1", "2", "3", "4"
            if (value.matches("[1-4]")) {
                break;
            }

            System.err.println("Invalid input. Please enter a value from 1 to 4.");
        }
        return value;
    }
    
    public static Date getDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        while (true) {
            try {
                System.out.print(msg + "(" + DATE_FORMAT + "): ");
                return sdf.parse(scanner.nextLine().trim());
            } catch (ParseException e) {
                System.err.println("Invalid date format (" + DATE_FORMAT + "). Please enter again.");
            }
        }
    }

    public static double getTime(String msg) {
        double time = 0;
        while (true) {
            try {
                System.out.print(msg);
                time = Double.parseDouble(scanner.nextLine().trim());
                if (time < 8.0 || time > 17.5) {
                    System.err.println("Time must be between 8.0 and 17.5 (8:00 - 17:30).");
                    continue;
                }
                if ((time * 10) % 5 != 0) {
                    System.err.println("Time must be in steps of 0.5 (e.g. 8.0, 8.5, 9.0 ...).");
                    continue;
                }

                break; 
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format. Please enter again (e.g. 8.0, 8.5).");
            }
        }
        return time;
    }
}
