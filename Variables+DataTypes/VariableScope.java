public class VariableScope{

    static int x = 3; //CLASS variable
    // static variables can be accessed by static methods directly
    // instance variables can't be accessed by static methods directly
    // Loacl variables may access 1st if declared in the method. other wise class variables will be accessed.
    // this time x in main method is local variable so it will be accessed.
    
    
    public static void main(String[]args){
        int x = 10; //Local variable
        System.out.println(x);
        display();
    }
    static void display(){
        int x = 20; //Local variable in another method
        // they can't see each other but we can connect them using parameters.
        System.out.println(x);
    }
}