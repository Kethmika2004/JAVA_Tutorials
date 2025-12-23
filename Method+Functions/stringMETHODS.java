public class stringMETHODS {
    public static void main(String[] args){

        String name = "Y Kethmika";

        int length = name.length();
        char letter = name.charAt(0);
        int index = name.indexOf("e");
        //int last_index = name.lastIndexOf("k");

        name = name.toUpperCase();
        String name_1 = name.toLowerCase();
        String newName = name.trim(); //remove the wide spaces 
        //name = newName.replace("e", "a");

        System.out.println(length);
        System.out.println(letter);
        System.out.println(index);
        System.out.println(name);
        System.out.println(name_1);
        System.out.println(newName);

        //is.Empty method
        if(name.isEmpty()){
            System.out.println("No name");
        }
        else{
            System.out.printf("Hello! %s \n", name);
        }

        //.contain method
        if(name.contains(" ")){
            System.out.println("Your name contains a space.");

        }
        else{
            System.out.println("Your name doesn't contains a space.");
        }

        //.equals() method
        if(name.equals("password")){
            System.out.println("Your name can't be password.");
        }
        else{
            System.out.println("Your name is " + name);
        }

        //.equalsIgnoreCase()
        
    }
    
}
