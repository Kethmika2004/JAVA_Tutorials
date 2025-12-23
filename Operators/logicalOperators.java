import java.util.Scanner;

public class logicalOperators {
    public static void main(String[] args){
        // && = AND
        // || = OR
        // ! = NOT
        Scanner scanner = new Scanner (System.in);

        String username ;
        String password ;

        System.out.print("Enter you new username: ");
        username = scanner.nextLine();

        if(username.length() < 4 || username.length() > 12 ){
            System.out.println("Username should contain 4-12 characters");
        }
        else if(username.contains(" ") || username.contains("_")){
            System.out.println("Username must not contain spaces or underscores");
        }
        else{
            System.out.println("WELCOME! " + username);
        }

        scanner.close();
            
    }
        
}
    

