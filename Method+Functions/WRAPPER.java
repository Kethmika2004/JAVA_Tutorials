public class WRAPPER {
    public static void main(String[] args){

        //Wrapper classes = Allow primitive values (int, char, double, boolean)
        //to be used as objectrs. "Wrap them  in an object".
        //Generally, don't wrap primitives unless you need an object.
        //Allows use of Collections Framework and static Utility methods.

        //autoboxing = the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes.
        Integer a = 100;
        Double b = 12.5;
        Character c = '@';
        Boolean d = true;

        //unboxing = the reverse of autoboxing. Automatic conversion of wrapper class to primitive.
        int x = a;
        double y = b;
        char z = c;

        //conversion
        String p = Integer.toString(5);
        String q = a.toString();
        String r = Double.toString(3.14);
        int s = Integer.parseInt("123");
        double t = Double.parseDouble("10.5");
        char u = "Pissa".charAt(0);
        char v = Character.valueOf('Z');
        boolean w = Boolean.parseBoolean("true");

        //utility methods
        int max = Integer.max(5,10);
        int min = Integer.min(5,10);
        int compare = Integer.compare(5,10);

        char letter = 'A';

        System.out.println(Character.isLetter(letter)); // useful for verifyng input
        System.out.println(Character.isDigit(letter));
        System.out.println(Character.isWhitespace(letter));
        System.out.println(Character.isUpperCase(letter));

        System.out.println();
        System.out.println(a);
        System.out.println(v);
        System.out.println(max);
        System.out.println(compare);
    }
}
