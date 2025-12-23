import java.util.Random;

public class random_numbers {
    public static void main(String[] args) {

        Random random = new Random();

        int number1 = random.nextInt(1,101);
        int number2 = random.nextInt(1,101);
        int number3 = random.nextInt(1,101);

        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);

        //double
        double decimal = random.nextDouble(0,1);
        System.out.println(decimal);

        //boolean
        boolean isHead = random.nextBoolean();
        System.out.println(isHead);
        
    }
    


}
