public class Abstraction {
    public static void main(String[] args){

        // abstract = Used to define abstract classes and methods.
        //            Abstraction is the process of hiding certain details and showing only essential information to the user.
        //            Abstract classes cannot be instantiated, but they can be subclassed.
        //            Can contain 'abstract' methods (does not have a body) and 'concrete' methods (has a body).

        Circle circle = new Circle(4);
        Rectangle rectangle = new Rectangle(2,7);
        Triangle triangle = new Triangle(3.5, 9);

        System.out.printf("%.2f ", circle.area());
        System.out.println();
        System.out.println(rectangle.area());
        System.out.println(triangle.area());
    }
    
}
