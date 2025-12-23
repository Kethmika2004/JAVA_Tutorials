public class Bus {

    String model;
    int year;
    Engine engine; // Bus "has-a" Engine (composition relationship)

    Bus(String model, int year, String engineType){
        this.model = model;
        this.year = year;
        this.engine = new Engine(engineType); // Creating Engine as part of Bus

    }

    void start(){
        this.engine.start();
        System.out.println("Bus " + model + " is starting.");
    }
    
}
