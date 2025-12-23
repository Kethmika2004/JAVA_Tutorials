public class vehicle {

    String brand;
    String color;

    vehicle(String brand, String color){
        this.brand = brand;
        this.color = color;
    }

    void status(){
        System.out.println("Kethmika has " + this.color + " " + this.brand + " vehicle.");
    }
    
}
