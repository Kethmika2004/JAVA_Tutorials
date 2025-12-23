public class STATIC {
    public static void main(String[] args){

        // static = Makes a variable or method belong to the class
        //          rather than to any specific object
        //          Commonly used for utility methods or shared resourses.
        
        Friend friend1 = new Friend("Nisal");
        Friend friend2 = new Friend("Anuhas");
        Friend friend3 = new Friend("Yasath");
        Friend friend4 = new Friend("Nimitha");

        System.out.println(friend1.name + ",");

        Friend.showFriends();

    }
    
}
