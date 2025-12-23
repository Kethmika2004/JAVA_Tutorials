public class OVERLOADEDmethods {
    public static void main(String[] args) {

        //overload method = methods that share the same name,
        //                 but have different parameters
        //                 method name + parameters = method signature
        
        String pizza = bakePizza("flat bread", "mozzarella", "pepperoni");
        System.out.println(pizza);

    }
    static String bakePizza(String bread){
        return bread + "pizza";
    }
    static String bakePizza(String bread, String cheese){
        return cheese + " " + bread + " pizza";
    }
    static String bakePizza(String bread, String cheese, String topping){
        return topping + " " + cheese + " " + bread + "pizza";
    }
}
