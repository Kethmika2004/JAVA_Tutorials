public class Motor_Car {
    
    private String model;
    private String color;
    private int price;

    Motor_Car(String model, String color, int price){

        this.model = model;
        this.color = color;
        this.price = price;
    }

    // GETTERS
    public String getModel(){
        return this.model;
    }
    public String getColor(){
        return this.color;
    }
    public String getPrice(){
        return "$" + this.price;
    }
    
    // SETTERS
    public void setColor(String color){
        this.color = color;
    }
    public void setPrice(int price){
        if(price < 0){
            System.out.println("Price cannot be negative.");
        }else{
            this.price = price;
        }
    }
}
