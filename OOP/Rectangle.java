public class Rectangle extends Shape {

    double length;
    double width;

    Rectangle(double l, double w){
        this.length = l;
        this.width = w;
    }

    @Override
    double area(){
        return length * width;
    }
    
}
