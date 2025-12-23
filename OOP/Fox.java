public class Fox implements Prey , Predator { // Fox has 2 parent classes
    @Override
    public void flee(){
        System.out.println("The fox is running away!");
    }

    @Override
    public void hunt(){
        System.out.println("The fox is hunting its prey!");
    }
   
    
}
