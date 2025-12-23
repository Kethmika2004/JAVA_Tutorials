public class TwoDarrays {
    public static void main(String[] args){

        //2D array = An array where each element is an array
        //          useful for grid-like structures
        //like matrix of data

        char[][] telephone ={{'1', '2', '3'}, 
                             {'4', '5', '6'}, 
                             {'7', '8', '9'}, 
                             {'*', '0', '#'}};

        //accessing elements in 2D array
        //System.out.println(telephone[0][0]); //prints 1
        //System.out.println(telephone[3][2]); //prints #

        System.out.println("Telephone keypad layout");
        System.out.println("-----------------------");

        for(char[] row : telephone){
            for(char key : row){
                System.out.print(key + "   ");
            }
            System.out.println();
        }

    }
    
}
