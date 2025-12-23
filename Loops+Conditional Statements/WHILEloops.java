import java.util.Scanner;

public class WHILEloops {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int number = 0;

        // 01. normal while loop (executes while the condition is true)

        /*
        while(number <1 || number > 10){
            System.out.println("Please enter a number between 1 and 10: ");
            number = scanner.nextInt();   
        } */

        // 02. do-while loop (executes at least once(do thing), then continues while the condition is true)
        do{
            System.out.print("Please enter a number between 1 and 10: ");
            number = scanner.nextInt();
        }while(number <1 || number > 10);        
        

        System.out.println("Thank you! You entered: " + number);

        scanner.close();

    }
    
}
