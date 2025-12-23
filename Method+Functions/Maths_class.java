
public class Maths_class {
    public static void main(String[] args) {

        System.out.println(Math.PI); //pi number
        System.out.println(Math.E); // eulers number

        double result;
        result = Math.pow(2,3); //power
        System.out.println(result);

        //or else
        System.out.println(Math.pow(2,0.5));//fractional power or root

        //absolute value
        System.out.println(Math.abs(-5));

        //squre root
        double result1;
        result1 = Math.sqrt(5);
        System.out.println(result1);

        //or else
        System.out.println(Math.sqrt(5));
    
        //Round the number
        System.out.println(Math.round(3.14));

        // ceiling method(lower bounded number)
        double num;
        num = Math.ceil(3.14); 
        System.out.println(num);

        //floor method(upper bounded number)
        System.out.println(Math.floor(Math.PI));

        //Max or min
        System.out.println(Math.max(12,14));

    }
    
}
