

public class VARAGS {
    public static void main(String[] args){

        //VARAGS: allow a method to accept variable number of arguments
        //syntax: dataType... variableName
        //makes mthod more flexible, no need for overloaded methodes
        //java will treat the varags as an array inside the method (ellipsis)

        System.out.println(add(1, 2 , 3, 4, 5, 8, 10));
        System.out.println(average(1,2,3.5));


    }
    //example of VARAGS(data type... variable name)
    static int add(int... numbers){
        int sum = 0;

        for (int number : numbers){
            sum += number;
        }

        return sum;
    }
    static double average(double... numbers){
        double sum = 0;

        for(double number : numbers){
            sum += number;
        }
        return sum / numbers.length;
    }


}
