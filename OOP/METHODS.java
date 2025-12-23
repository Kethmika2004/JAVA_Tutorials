import java.util.Scanner;

public class METHODS {
    public static void main(String[]args) throws InterruptedException{
        // method = a block of reuseable code that is executed when called ()
        //like def in python

        // Birthday wisher
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        for(int i = 5; i >= 1; i--){
            System.out.print(i + " ");
            Thread.sleep(1000);
        }
        System.out.println("\n");
        BithdayWish(name);

        //new programm
        System.out.println("\n");
        System.out.print("Enter a number to be cubed: ");
        double number = scanner.nextDouble();
        System.out.println("The cube of the " + number + " is " + cube(number));

        //18+ checker
        System.out.println("\n");
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        if(is18plus(age)){
            System.out.println("You are eligible to watch Porn videos!");
        }
        else{
            System.out.println("You are not eligible to watch those bull shits!");
        }

        scanner.close();
    }
    static void BithdayWish(String name){
        System.out.println("Happy Birthday to you!");
        System.out.println("Happy Birthday to you!");
        System.out.printf("Happy Birthday dear %s \n", name);
        System.out.println("Happy Birthday to you!...");
    }
    static double cube(double num){
        return num * num * num;
    }
    static boolean is18plus(int age){
        boolean status = (age >= 18) ? true : false;
        return status;
    }

}

