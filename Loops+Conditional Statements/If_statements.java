import java.util.Scanner;

public class If_statements {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name :");
        String name = scanner.nextLine();

        System.out.print("Enter your age :");
        int age = scanner.nextInt();

        //Group 1
        if(name.isEmpty()){
            System.out.println("\nYou didn't enter the name.");
        }
        else{
            System.out.println("\nHello dear " + name + "!");
        }

        //Group 2
        if (age >= 18){
            System.out.println("You're an adult now.");
        }
        else if(age < 0){
            System.out.println("Probably,e You haven't been born yet!");
        }
        else if(age == 0){
            System.out.println("You're a baby.");
        }
        else{
            System.out.println("You're still a kid.");
        }

        scanner.close();

    }
    
}
