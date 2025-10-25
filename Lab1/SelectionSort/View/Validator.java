package SelectionSort.View;


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

    public static double getDoubleNoLimit(String msg) { //Nhập double, không giới hạn, có thông báo.
        return getDouble(msg, -Double.MAX_VALUE, Double.MAX_VALUE);
    }    

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
    
    public static double[] getRange(String lowerMsg, String upperMsg) {
        double lower, upper;

        // Nhập lower > 0
        while (true) {
            try {
                System.out.print(lowerMsg);
                lower = Double.parseDouble(scanner.nextLine());
                
                if (lower >= 0) {
                    break;
                } else {
                    System.err.println("Lower bound must be greater or equals to 0.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid Double format for lower bound. Please try again.");
            }
        }

        // Nhập upper > lower
        while (true) {
            try {
                System.out.print(upperMsg);
                upper = Double.parseDouble(scanner.nextLine());
                
                if (upper > lower) {
                    break;
                } else {
                    System.err.printf("Upper bound must be greater than lower bound (%.2f).\n", lower);
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid Double format for upper bound. Please try again.");
            }
        }
        
        return new double[]{lower, upper};
    }
    
    public static float getFloatNoLimit(String msg) { //Nhập float, không giới hạn, có thông báo.
        return getFloat(msg, -Float.MAX_VALUE, Float.MAX_VALUE);
    }    

    public static float getFloat(String msg, float minRange, float maxRange) {
        if (minRange > maxRange) {
            float temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }
        
        while (true) {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }
                
                float value = Float.parseFloat(scanner.nextLine());
                
                if (value >= minRange && value <= maxRange) {
                    return value;
                }
                System.err.printf("Value must be greater or equals to 0.\n ");
                //System.err.printf("Value must be between %.2f and %.2f.\n", minRange, maxRange);

            } catch (NumberFormatException e) {
                System.err.println("Invalid Float format. Please enter again. ");
            }
        }
    } //Nhập float, có giới hạn, có thông báo.

    public static String getStringPT(String msg, String pattern) {  //"[pP][\\d]{3}"  ,  
        String value = null;
        do {
            value = getString(msg);
            if (!value.matches(pattern)) {
                System.err.println("Invalid format. Enter again.");
            }
        } while (!value.matches(pattern));
        
        return value;
    }

    /*
    "[pP][\\d]{3}"                        p hoặc P và 3 số int
    "^B[A-Za-z0-9]*-[A-Za-z0-9]*$"        bắt đầu = B, có dấu -
    [nN][vV][\\d]{3}"                     bắt đầu = nv hoặc NV và 3 số int
     */
    
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
    
    public static LocalDate getLocalDate(String msg) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_FORMAT);
        while (true) {
            try {
                System.out.print(msg + "(" + DATE_FORMAT + "): ");
                String input = scanner.nextLine().trim();
                return LocalDate.parse(input, fmt);
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date format (" + DATE_FORMAT + "). Please enter again.");
            }
        }
    }    

    public static LocalDate getLocalDateBeforeToday(String msg) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate today = LocalDate.now();
        
        while (true) {
            try {
                System.out.print(msg + " (" + DATE_FORMAT + "): ");
                String input = scanner.nextLine().trim();
                LocalDate date = LocalDate.parse(input, fmt);
                
                if (date.isAfter(today)) {
                    System.err.println("Date cannot be in the future. Please enter a valid date.");
                    continue;
                }
                
                return date;
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date format (" + DATE_FORMAT + "). Please enter again.");
            }
        }
    }

    public static LocalDate getLocalDateAfterToday(String msg) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate today = LocalDate.now();
        
        while (true) {
            try {
                System.out.print(msg + " (" + DATE_FORMAT + "): ");
                String input = scanner.nextLine().trim();
                LocalDate date = LocalDate.parse(input, fmt);
                
                if (!date.isAfter(today)) {
                    System.err.println("Date must be after today. Please enter a future date.");
                    continue;
                }
                
                return date;
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date format (" + DATE_FORMAT + "). Please enter again.");
            }
        }
    }
    
    public static Date getDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        while (true) {
            try {
                System.out.print(msg + "(" + DATE_FORMAT + "): ");
                return sdf.parse(scanner.nextLine().trim());
            } catch (ParseException e) {
                System.out.println("Invalid date format (" + DATE_FORMAT + "). Please enter again.");
            }
        }
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
    
    public static boolean getBoolean(String msg) {
        while (true) {
            if (msg != null) {
                System.out.print(msg + "(true/false): ");
            }
            
            String value = scanner.nextLine().trim().toLowerCase();
            
            if (value.equals("true")) {
                return true;
            } else if (value.equals("false")) {
                return false;
            } else {
                System.err.println("(Invalid boolean format. Please enter 'true' or 'false'): ");
            }
        }
    }    
}
