package Contacts.View;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Validator {
    
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

    public static String getStringPhone(String msg) {
        String value = null;
        // Regex số điện thoại hợp lệ theo đề
        String phonePattern = "^(?:\\d{10}"                           // 1234567890
                            + "|\\d{3}-\\d{3}-\\d{4}"                 // 123-456-7890
                            + "|\\d{3}-\\d{3}-\\d{4}\\s(?:x|ext)\\d{4}" // 123-456-7890 x1234 / ext1234
                            + "|\\(\\d{3}\\)-\\d{3}-\\d{4}"           // (123)-456-7890
                            + "|\\d{3}\\.\\d{3}\\.\\d{4}"             // 123.456.7890
                            + "|\\d{3}\\s\\d{3}\\s\\d{4}"             // 123 456 7890
                            + ")$";

        do {
            value = getString(msg);
            if (!value.matches(phonePattern)) {
                System.err.println("Invalid phone format. Please enter again:");
            }
        } while (!value.matches(phonePattern));

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
}
