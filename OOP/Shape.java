public abstract class Shape {

    //abstract method (does not have a body)
    abstract double area();

    void display(){ //concrete method - inherited by subclasses
        System.out.println("This is a shape");
    }
    
}
