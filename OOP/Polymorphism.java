public class Polymorphism {
    public static void main(String[] args){

        //Polymorphism = "POLY" = many, "MORPH" = forms / Shapes
        //               Objects can identify as other objects
        //               Objects can be treated as objects of a common superclass
        //               Interface is used to achieve polymorphism

        Guitar guitar = new Guitar();
        Violin violin = new Violin();
        Drum drum = new Drum();

        Music[] orchestra = {guitar, violin, drum}; // creating an array of Music type

        for(Music instrument : orchestra){
            instrument.playSound();
        }



    }
    
}
