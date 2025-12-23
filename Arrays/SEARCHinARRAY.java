import java.util.Scanner;

public class SEARCHinARRAY {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //int[] arr = {1, 9, 2, 8, 3, 7, 4, 6, 5};
        String[] fruits = {"apple", "banana", "cherry", "date"};

        System.out.print("Enter the fruit to search for :");
        String targetfruit = scanner.nextLine();

        //int target = 7;
        boolean isFound = false;

        for (int i = 0; i < fruits.length; i++){
            if (fruits[i].equalsIgnoreCase(targetfruit)){
                System.out.println("Target found at index: " + i);
                isFound = true;
                break;
            }
        }

        if (!isFound){
            System.out.println("Target not found in the array.");
        }
        scanner.close();
    }
    
}
