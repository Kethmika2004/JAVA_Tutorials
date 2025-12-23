import java.util.Scanner;

public class JAVAcalculator {
    public static void main(String[] args){
        // going to create a simple calculator
        Scanner scanner = new Scanner (System.in);

        double result = 0.0;
        String status = "Yes";

        while (status.equalsIgnoreCase("Yes")){

            System.out.println("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.println("Enter the operator (+, -, *, /, ^): ");
            char operator = scanner.next().charAt(0);

            System.out.println("Enter the seconf number: ");
            double num2 = scanner.nextDouble();

            switch (operator){
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> {
                    if (num2 != 0){
                        result = num1 / num2;
                    }
                    else{
                        System.out.println("Error : Division by zero is not allowed.");
                    }
                }
                case '^' -> result = Math.pow(num1 , num2);
                default -> {
                    System.out.println("Error: Invalid Operator");
                }
            }
            System.out.printf("The result is: %.2f \n" , result);
            System.out.println("Do you want to perform another calculation? (Yes/No): ");
            status = scanner.next();
        }

        // End of the program
        System.out.println("THANK YOU FOR USING THE CALCULATOR!");
        scanner.close();

    }
}
