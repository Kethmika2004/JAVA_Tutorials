import java.util.Scanner;

public class EnhancedSwitches {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a day of the week :");
        String day = scanner.nextLine().toUpperCase();

        //Enhanced Switches = A replacement to many else if statements
        switch (day){
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> {
                System.out.println(day + " is a weekday.");
            }
            case "SATURDAY", "SUNDAY" -> {
                System.out.println(day + " is a weekend.");
            }
            default -> {
                System.out.println("Invalid day entered.");
            }
        }

        scanner.close();
        


    }
    
}
