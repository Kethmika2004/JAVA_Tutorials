public class INHERITANCE {
    public static void main(String[] args){

        // Inheritance = One class inherits the attributes and methods
        //               from another class.
        //               Child <- Parent <- GrandParent

        Dog dog = new Dog();
        Cat cat = new Cat();
        Plants plant = new Plants();

        System.out.println(dog.isAlive);
        System.out.println(cat.isAlive);

        cat.eat();
        dog.eat();

        System.out.println(dog.lives);

        cat.speak();
        dog.speak();

        plant.photosynthesize();
        System.out.println(plant.isAlive);
        


    }
    
}
