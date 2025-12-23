public class ArrayObjects {
    public static void main(String[] args){

        vehicle vehicle_1 = new vehicle("Ford" ,"Red");
        vehicle vehicle_2 = new vehicle("Lambhorgini" ,"Yellow");
        vehicle vehicle_3 = new vehicle("Range Rover" ,"Black");

        vehicle[] vehicle_store = {vehicle_1, vehicle_2, vehicle_3};

        //for(vehicle car : vehicle_store){
        //    car.color = "Blue";
        //}

        //vehicle is object type (class)
        for(vehicle car : vehicle_store){
            car.status();
        }
        
    }
}