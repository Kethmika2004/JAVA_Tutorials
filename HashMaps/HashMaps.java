import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args){

        //Hashmaps = A data structures that stores key-value pairs
        //           Keys are unique, but Values can be duplicated.
        //           Does not maintain any oredr, but is memory efficient.
        //           HashMap<Key, Value>

        HashMap<String, Double> map = new HashMap<>();

        map.put("Apple", 0.50);
        map.put("Orange", 0.75);
        map.put("Banana", 0.25);
        //map.put("Orange",10000.00); cannot duplicate the key, It sounds like overriding
        map.put("Coconut",1.0);

        //Removing method
        // map.remove("Apple");  

        System.out.println(map);
        System.out.println(map.get("Apple")); //.get()

        System.out.println(map.containsKey("Banana"));
        System.out.println(map.containsKey("PineApple"));

        if(map.containsKey("Apple")){
            System.out.println(map.get("Apple"));
        }else{
            System.out.println("Key not found!");
        }

        System.out.println(map.containsValue(1.00));

        for(String key : map.keySet()){
            System.out.println(key + ": $" + map.get(key));
        }

        
        

    }
}
