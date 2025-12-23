public class Person { // parent class / super class

    String first_name;
    String last_name;

    //Constructor person object
    Person(String first, String second){
        this.first_name = first;
        this.last_name = second;
    }

    //method
    void displayFullName(){
        System.out.println("Full Name: " + this.first_name + " " + this.last_name);
    }
    
}
