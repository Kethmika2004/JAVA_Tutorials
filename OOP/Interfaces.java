public class Interfaces {
    public static void main(String[] args){

        // Interface = A Blueprint for a class that specifies a set of abstract methods
        //             that the class must implement
        //             Used to achieve abstraction and multiple inheritance in Java


        Rabbit rabbit = new Rabbit();
        Hawk hawk = new Hawk();
        Fox fox = new Fox();

        rabbit.flee();
        hawk.hunt();
        fox.flee();
        fox.hunt();
    }
    
}
