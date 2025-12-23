import java.util.Scanner;

public class User_Inputs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // for strings
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // for integers
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        //for doubles
        System.out.print("Your GPA: ");
        double gpa = scanner.nextDouble();

        //for boolean inputs
        System.out.print("Are you a student at University of Moratuwa? (true/false): ");
        boolean isStudent = scanner.nextBoolean();

        System.out.println("Hello! " + name);
        System.out.println("You are " + age + " years old.");
        System.out.println("Your GPA is " + gpa);
        
        if (isStudent) {
            System.out.println("Welcome! to the CSE department of University of Moratuwa.");
        }
        else {
            System.out.println("get out from here.");
        }

        //Calculate the area of the rectangle

        double width = 0;
        double height = 0;
        double area = 0;

        System.out.print("Enter the width :");
        width = scanner.nextDouble();

        System.out.print("Enter the height :");
        height = scanner.nextDouble();

        area = width * height ;
        System.out.println("Area of the rectangle is: " + area);

        scanner.close();

    }

    
}
