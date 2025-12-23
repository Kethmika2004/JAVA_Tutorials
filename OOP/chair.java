public class chair {

    String make;
    String model;
    String color;
    int  year;

    chair(String make, String model, String color, int year){
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    @Override
    public String toString(){
        return "Chair Make: " + this.make + ", Model: " + this.model + ", Color: " + this.color + ", Year: " + this.year;

    }
    
}
