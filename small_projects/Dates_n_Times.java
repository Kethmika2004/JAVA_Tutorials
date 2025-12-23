import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Dates_n_Times {
    public static void main(String[] args){
        // How to work with DATES & TIMES Using Java
        // (Local data, Local time, LocalDateTime, UTC timestamp)
        // Import the java.time package to work with dates and times
        // https://www.w3schools.com/java/java_dates.asp

        LocalDate date = LocalDate.now();
        System.out.println("Current date: " + date);

        LocalTime time = LocalTime.now();
        System.out.println("Current time: " + time);

        Instant instant = Instant.now(); //UTC timestamp
        System.out.println("Current timestamp (UTC): " + instant);

        //custom date and time
        LocalDateTime customDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDateTime = customDateTime.format(formatter);
        System.out.println("Formatted date and time: " + formattedDateTime);

        // Create a specific date
        LocalDate christmassdate = LocalDate.of(2025, 12, 25);
        System.out.println("Custom date: " + christmassdate);

        LocalDate newYearDate = LocalDate.parse("2025-01-01");
        System.out.println("Parsed date: " + newYearDate);

        if(christmassdate.isAfter(newYearDate)){
            System.out.println("Christmas 2025 is after New Year 2025");

        }
    }
}
