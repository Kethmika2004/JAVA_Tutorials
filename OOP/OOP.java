public class OOP {
    public static void main(String[] args){


        Car car = new Car();

        //we can change the attributes
        car.owner = "Lithum";

        System.out.println(car.owner);
        System.out.println(car.Brand);
        System.out.println(car.ManufacturedYear);
        System.out.println(car.mileage);
        System.out.println(car.isRunning + "\n");


        car.start();

        

    }
    
}
