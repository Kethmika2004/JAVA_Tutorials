import java.util.Scanner;
import java.util.Arrays;

public class userinputARRAYS {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many fruits do you want to enter?");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] fruits = new String[size];
        
        for(int i = 0; i < fruits.length; i++){
            System.out.print("Enter fruit " + (i + 1) + ": ");
            fruits[i] = scanner.nextLine();
        }

        for(String fruit : fruits){
            System.out.print(fruit + " ");
        }

        scanner.close();
    }
    
}
