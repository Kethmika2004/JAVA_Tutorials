public class Variables {
    // There are 2 main data types one is Primitive data type and other is reference data type
    // primitive >>> int, double, char, boolean
    // reference >>> string, array, object
    //........................................................................................
    // 2 steps to creating a variable
    // ..............................
    // 1. declaration
    // 2. assignment 

    public static void main(String[] args) {

        int age = 21; // declare data type as int and then assign it to the 21
        int year = 2025;
        int quantity = 1;

        double price = 19; // at the end you will get the output as 19.0
        double GPA = 3.59;
        double Tempreture = 31.3;

        char grade = 'A';
        char symbol = '!';
        char currency = '$';

        boolean isStudent = true;
        boolean forSale = false;
        boolean isOnline = true;

        System.out.println(age);
        System.out.println("The year is " + year);
        System.out.println("$" + price);
        System.out.println("My 1st semester GPA was " + GPA);
        System.out.println("The price is " + currency + price);

        if (isStudent){
            System.out.println("You are a Student.");
        }
        else{
            System.out.println("You are not a Student.");
        }


        String name = "Lasindi Manudula";
        String email = "kethmikakadyasandu@gmail.com";
    

        System.out.println(name);
        System.out.println("Your email is " + email);

    }
}
