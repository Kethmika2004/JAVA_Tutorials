import java.util.Scanner;
import java.util.Random;

public class SlotMachine {
    public static void main(String[] args){

        //JAVA Slot machine
        Scanner scanner = new Scanner(System.in);

        //Variables
        int balance = 1000;
        int bet;
        int payOut;
        String[] row;
        String playAgain;

        //Welcome message
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("WELCOME to JAVA SLOTS");
        System.out.println("Symbols: @ # & % ! ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

        //playing game
        while(balance > 0){
            System.out.println("Current Balance: Rs." + balance);
            System.out.print("Place your bet amount: Rs.");
            bet = scanner.nextInt();
            scanner.nextLine();

            if(bet > balance){
                System.out.println("INSUFFICIENT BALANCE!");
                continue;
            }
            else if(bet <= 0){
                System.out.println("Bet must be grater than 0");
                continue;
            }
            else{
                balance -= bet;
            }

            //Spin the machine
            System.out.println("Spinning...");
            row = spinRow();
            // Print the row
            printRow(row);
            // Get pay out
            payOut = getPayout(row, bet);

            if(payOut > 0){
                System.out.println("You won Rs." + payOut);
                balance += payOut;
            }else{
                System.out.println("Sorry! try again.");
            }

            System.out.println("Do you want  to play again? (Y/N): ");
            playAgain = scanner.nextLine().toUpperCase();

            if(!playAgain.equals("Y")){
                break;
            }
        }

        scanner.close();

    }
    static String[] spinRow(){

        String[] symbols = {"@", "#", "&", "%", "!"};
        String[] row = new String[3];
        Random random = new Random();


        for(int i = 0; i < 3; i++){
            row[i] = symbols[random.nextInt(symbols.length)];
        }

        return row;
    }
    static void printRow(String[] row){
        System.out.println("---------------------------");
        System.out.println("     "+ String.join("   |   ", row));
        System.out.println("---------------------------");

    }
    static int getPayout(String[] row, int bet){
        
        if(row[0].equals(row[1]) && row[1].equals(row[2])){
            return switch(row[0]){
                case "@" -> bet * 10;
                case "#" -> bet * 20;
                case "&" -> bet * 30;
                case "%" -> bet * 50;
                case "!" -> bet * 100;
                default -> 0;
            };
        }

        else if(row[0].equals(row[1])){
            return switch(row[0]){
                case "@" -> bet * 2;
                case "#" -> bet * 3;
                case "&" -> bet * 5;
                case "%" -> bet * 10;
                case "!" -> bet * 20;
                default -> 0;
            };
        }

        else if(row[1].equals(row[2])){
            return switch(row[1]){
                case "@" -> bet * 3;
                case "#" -> bet * 4;
                case "&" -> bet * 5;
                case "%" -> bet * 10;
                case "!" -> bet * 20;
                default -> 0;
            };
        }

        return 0;
    }

}
