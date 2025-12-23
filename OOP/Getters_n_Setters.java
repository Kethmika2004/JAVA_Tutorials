public class Getters_n_Setters {
    public static void main(String[] args){

        //They help protect object data and rules for saccesing or modifyng them.
        // GETTERS = methods that can make a field "READABLE.
        // SETTERS = methods that can make a field "WRITABLE.


        Motor_Car car1 = new Motor_Car("BMW", "Black", 50000);

        //Motor_car.model = "Audi"; // This will give an error because model is private.
        //System.out.println(Motor_car.color); // This will give an error because color is private.
        //Using SETTERS to modify the private fields.
        //car1.color = "Red"; // This will give an error because color is private.


        car1.setColor("Blue");
        car1.setPrice(-11000); 

        //Using GETTERS to read the private fields.
        System.out.println("Model: " + car1.getModel());
        System.out.println("Color: " + car1.getColor());
        System.out.println("Price: " + car1.getPrice());



    }
    
}
