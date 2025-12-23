import java.util.Scanner;

public class Substringsm {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //take user inputs
        System.out.print("Type your email address: ");
        String email = scanner.nextLine();

        if(email.contains("@")){
            //int atsymbol = email.indexOf("@");
            String username = email.substring(0, email.indexOf("@"));
            String domain = email.substring(email.indexOf("@") + 1);

            System.out.println("Your Username is :" + username);
            System.out.println("Domain of your mail address :" + domain);

        }
        else{
            System.out.println("Invalid email address");
        }

        
        scanner.close();
    }
    
}
