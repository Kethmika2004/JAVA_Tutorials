import java.util.Scanner;

public class TernaryOperator {
    public static void main(String[] args){

        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter your Score: ");
        int mark = scanner.nextInt();

        String passOrFail = (mark >= 40) ? "Pass" : "Fail";

        System.out.println("You " + passOrFail);

        scanner.close();

    }
    
}
