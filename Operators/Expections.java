import java.util.InputMismatchException;
import java.util.Scanner;

public class Expections {
    public static void main(String[] args){

        // Expception = An avent that interrupts the normal flow of a program
        //             (Dividing by zero, file not found, mismatch input type)
        //              Surround any dangerous code with a try{} block
        //              If an exception occurs, the catch{} block will execute
        //              Use finally{} block after try{} and catch{} blocks to execute code regardless if an exception occurs or not

        Scanner scanner = new Scanner(System.in);


        try{
            System.out.println("Enter a number to divide: ");
            int x = scanner.nextInt();
            System.out.println("Enter a number to divide by: ");
            int y = scanner.nextInt();

            System.out.println("Result: " + (x / y));
        }
        catch(ArithmeticException e){
            System.out.println("You can't divide by zero!");
        }
        catch(InputMismatchException e){
            System.out.println("Please enter a valid input type!");
        }
        catch(Exception e){
            //SAFETY NET CATCH ALL
            System.out.println("An error occurred: " + e);
        }
        finally{
            scanner.close();
            System.out.println("Program ended.");
        }

       
    }
}
