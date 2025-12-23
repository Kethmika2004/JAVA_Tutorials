import java.util.Scanner;

public class Threading {
    public static void main(String[] args){

        // Threading = Allows a program to run multiple tasks simultaneously
        //             Helps improve perfomance with time-consuming operations
        //             (File I/O, Network communications, or any other background tasks)

        // How to create a channel
        // Option 1. Extend the Thread class (simpler)
        // Option 2. Implement the Runnable interface (better)

        Scanner scanner = new Scanner(System.in);

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.setDaemon(true);
        thread.start();

        System.out.println("You have 10 seconds to Enter Your name");
        System.out.print("Enter yout name: ");
        String name = scanner.nextLine();

        System.out.println("Hello " + name);

        scanner.close();
        
    }
}
