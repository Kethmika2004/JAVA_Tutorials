public class generics {
    public static void main(String[] args){

        // Generics = A concept where you can write a class, interface, or method.
        //            that is compatible with different data types.
        //            <T> type parameter (placeholder that gets replaced with a real type)
        //            <String> type argument (specifies the type)

        Box<Integer> box = new Box<>();
        Product<String, Double> product1 = new Product<>("apple", 2.3);
        Product<String, Integer> product2 = new Product<>("Ticket", 15);

        box.putItem(3);

        System.out.println(box.getItem());
        System.out.println(product1.getItem());
        System.out.println(product2.getPrice());
    }
}
