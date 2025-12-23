import java.util.Arrays;

public class ArraysExample {
    public static void main (String[] args){
        int[] numbers = {1, 2, 3, 4, 5};
        String[] Fruits = {"Banana", "Apple", "Orrange", "Cherry"};
        
        Fruits[0] = "Mango";
        int numOFfruits = Fruits.length; //no brackets after .length
        System.out.println("Number of Elements in the List of Fruits is " + numOFfruits);

        System.out.println(numbers[2]);
        System.out.println(Fruits[0]);
        Arrays.sort(Fruits);
        Arrays.fill(numbers, 0);

        /* 
        for(int i = 0; i < Fruits.length; i++){
            System.out.print(Fruits[i] + ", ");
        } */

        //Enhanced for loop
        for(String Fruit : Fruits){
            System.out.print(Fruit + ", ");
        }
    }
    
}
