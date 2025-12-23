import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ARRAYlists {
    public static void main(String[] args){

        //Arraylist = A resizeable array that stores objects(autoboxing)
        //            Arrays are fixed in size, but ArrayLists can change.

        //ArrayList<String> food = new ArrayList<String>();

        //food.add("Pizza");
        //food.add("Burger");
        //food.add("Hotdog");
        //food.add("Fries");
        //food.set(0, "Sushi");
        //food.remove(2);

        //System.out.println(food.get(0));
        //System.out.println(food.size());
        //System.out.println(food);
        //for (int i = 0; i < food.size(); i++){
           // System.out.print(food.get(i) + ", ");
        //}

        //sorting
        //Collections.sort(food);
        //food.clear();

        //EXERSICE

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<String>();

        System.out.print("Enter the numbert of foods you want to add to cart: ");
        int numOfFood = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for(int i = 0; i < numOfFood; i++){
            System.out.println("Enter food item "+ (i+1) + ": ");
            String food = scanner.nextLine();
            cart.add(food);
        }

        System.out.println("Your cart contains: " + cart);

        scanner.close();
    }
}
