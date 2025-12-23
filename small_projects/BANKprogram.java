import java.util.Scanner;

public class BANKprogram {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        // JAVA BANKING for beginners

        // declare variables
        double balance = 0.0;
        boolean isRunning = true;
        int choice;

        // Main loop
        while(isRunning){
            // Display Menu
            System.out.println("************************************");
            System.out.println("WELCOME to SAMPATH E-Banking System!");
            System.out.println("************************************");
            System.out.println();
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println();
            
            // Get and process users choice
            System.out.print("Please enter your choice (1-4):");
            choice = scanner.nextInt();

            switch(choice){
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance -= withdraw(balance);
                case 4 -> isRunning = false;
                default -> System.out.println("Invalid choice! Please select a valid option.");
            }

        }
        scanner.close();

        // exit message
        System.out.println("Thank you for using SAMPATH E-Banking System. Have a Nice day!");
    }
    static void showBalance(double balance){
        System.out.println("------------------------------------");
        System.out.printf("YOUR BALANCE IS Rs. %.2f \n", balance);
    }
    static double deposit(){
        //method for depositing money
        System.out.println("------------------------------------");
        System.out.print("Enter amount to deposit: Rs.");
        double amount = scanner.nextDouble();
        if (amount < 0){
            System.out.println("Amount cannot be negative!");
            return 0.0;
        }
        else{
            System.out.println("Amount Rs. " + amount + " deposited successfully!");
            return amount;
        }

    }
    static double withdraw(double balance){
        // method for withdrawing money
        System.out.println("------------------------------------");
        System.out.print("Enter amount to withdraw: Rs. ");
        double amount = scanner.nextDouble();
        if (amount < 0){
            System.out.println("Amount cannot be negative!");
            return 0.0;
        }
        else{
            if(amount > balance){
                System.out.println("Sorry!, Insufficient balance!");
                return 0.0;
            }  
            else{
                System.out.println("Amount Rs. " + amount + " withdrawn successfully!");
                return amount;
            }          
            
        }
    }

    
}
