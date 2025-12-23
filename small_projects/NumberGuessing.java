import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args){

        //NUMBER GUESSING GAME
        Random random = new Random();
        Scanner scanner = new Scanner (System.in);

        String status = "Yes";

        //repeat until user wants to stop playing
        while (status.equalsIgnoreCase("Yes")){

            int userGuess;
            int numOfAttempts = 0;
            int nunmberToGuess = random.nextInt(1, 11);

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 10. You'll get three chances, if you guess it correctly you will get $5?");

            do{
                System.out.print("Please enter your guess: ");
                userGuess = scanner.nextInt();
                numOfAttempts ++;

                if (userGuess == nunmberToGuess){
                    System.out.println("Congratulations! You guessed the correct number and won $5!");
                    System.out.println("You've used " + numOfAttempts + " attempts to get the correct number.");
                } else {
                    System.out.println("Sorry!, you've used your " + numOfAttempts + " attempt. TRY AGAIN!");
                }

            }while(userGuess != nunmberToGuess && numOfAttempts < 3);

            if (userGuess != nunmberToGuess){
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + nunmberToGuess);
            }
            System.out.println("Do you want to play again? (Yes/No): ");
            status = scanner.next();

        }


        scanner.close();


    }
    
}
