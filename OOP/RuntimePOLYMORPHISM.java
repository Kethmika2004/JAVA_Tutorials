import java.util.Scanner;

public class RuntimePOLYMORPHISM {
    public static void main(String[] args){
        
        // Runtime Polymorphism = When the method that gets executed is decided
        //                        at runtime based on the actual type of the object.
        //                        Also known as Dynamic Method Dispatch.

        Scanner scanner = new Scanner(System.in);

        Human human;

        System.out.println("Choose a region (1 for Asia, 2 for Africa): ");
        int choice = scanner.nextInt();

        if(choice == 1){
            human = new Asians();
            human.language();
        }
        else if(choice == 2){
            human = new Africans();
            human.language();
        }


        scanner.close();
    }
    
}
