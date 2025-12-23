import java.util.Scanner;

public class forloops {
    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);

        // for loops = execute some code for a certain number of times

        System.out.println("Update your name: ");
        String name = scanner.nextLine();

        for(int i = 10; i > 0; i--){
            System.out.print(i + " ");
            Thread.sleep(500); //pause for 0.5 second
        }

        System.out.println("\n");
        System.out.println("Happy Birthday!!! Dear " + name);

        scanner.close();
    }
    
}
