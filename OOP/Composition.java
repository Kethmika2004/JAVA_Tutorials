import java.lang.classfile.attribute.SourceDebugExtensionAttribute;

public class Composition {
    public static void main(String[] args){

        // Composition = Represents a "part-of" relationship between objects.
        //               A strong form of aggregation where the part cannot exist without the whole.
        //               For example : an Engine is "part of" a car. *If the car is destroyed, the engine is also destroyed.*
        //               In Java, composition is implemented by including objects of one class as fields in another class.
        //               allows complex objects to be constructed from smaller objects.

        Bus bus = new Bus("Volvo", 2020, "Diesel Engine");

        System.out.println("Bus Model: " + bus.model);
        System.out.println("Bus Year: " + bus.year);
        //System.out.println("Bus Engine Type: " + bus.engine); // This would print the reference to the Engine object
        System.out.println("Bus Engine Type: " + bus.engine.type);

        System.out.println();
        bus.start();
    }
    
}
