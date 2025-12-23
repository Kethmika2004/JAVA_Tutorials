public class close_decimal {
    public static void main(String[] args){

        //printf() = is a method used to format output
        // %[flags][width][.precision][specifier-chrachter]
        //place holder

        String name = "Spongebob";
        char firstletter = 'K';
        int age = 21;
        double height = 180.5;
        boolean isEmployed = true;

        System.out.printf("Hello %s\n", name);
        System.out.printf("Your name starts with a %c\n", firstletter);
        System.out.printf("You are %d\n", age);
        System.out.printf("You are %f inches tall.\n", height);
        System.out.printf("You are employed: %b\n",isEmployed);
        System.out.printf("%s is %d years old.\n", name, age);

        double price1 = 99999.99;
        double price2 = 100.15;
        double price3 = -5400.01;

        // add precision
        System.out.printf("%.1f\n", price1); //round off to one decimal point
        System.out.printf("%.2f\n", price2); //round off to 2 decimal points
        System.out.printf("%.3f\n", price3); //round off to 3 decimal points

        //[flags]
        // + = output plus
        // , = comma grouping separator
        // ( = negative numbers are enclosed in()
        // space = display a minus if negative. space if positive

        System.out.printf("%,.1f\n", price1); 
        System.out.printf("%,.2f\n", price2); 
        System.out.printf("%,.3f\n", price3); 


        //[width]
        // 0 = zero padding
        // number = right justified padding
        // negative number = left justified padding

        int ID_1 = 1;
        int ID_2 = 23;
        int ID_3 = 456;
        int ID_4 = 7890;

        //zero padding
        System.out.printf("%04d\n", ID_1);
        System.out.printf("%04d\n", ID_2);
        System.out.printf("%04d\n", ID_3);
        System.out.printf("%04d\n", ID_4);

        //number padding (right padding)
        System.out.printf("%4d\n", ID_1);
        System.out.printf("%4d\n", ID_2);
        System.out.printf("%4d\n", ID_3);
        System.out.printf("%4d\n", ID_4);

        //negative numbers (left padding)
        System.out.printf("%-4d\n", ID_1);
        System.out.printf("%-4d\n", ID_2);
        System.out.printf("%-4d\n", ID_3);
        System.out.printf("%-4d\n", ID_4);






    }
    
}
