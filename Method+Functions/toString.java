public class toString {
    public static void main(String[] args){

        //.toString() = Method INherited from the Object class
        //              Returns a string that "textually represents" an object
        //              can be overridden by a class to provide a more meaningful string representation of an object of that class
        //              Format: ClassName@HexadecimalCodeOfHashCode

        chair chair1 = new chair("Ikea", "Tibro", "Black", 2020);
        chair chair2 = new chair("Herman Miller", "Aeron", "Gray", 2021);

        System.out.println(chair1);
        //System.out.println(chair1.toString());

        System.out.println(chair2);
    }
    
}

