public class Anonymous {
    public static void main(String[] args){
        //Anonymous class = A class that doesn't have a name. Cannot be reused.
        //                  Add custom behavior without having to create a new class
        //                  Often used for one time uses.(TimerTask, Runnable, callbacks)

        Dog normal_dog = new Dog();
        Dog scoobydoo = new Dog(){
            @Override
            void speak(){
                System.out.println("Scooby Doo says *Scooby Dooby Doo*");
            }
        };

        normal_dog.speak();
        scoobydoo.speak();

    }
}
