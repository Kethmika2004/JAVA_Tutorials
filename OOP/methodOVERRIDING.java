public class methodOVERRIDING {
    public static void main(String[] args){

        //method overriding = when a subclass (child class) has a method with the same name, same parameters, and same return type
        //                      as a method in its superclass (parent class). used to provide specific implementation of a method that is already defined in its superclass.

        doctor doc = new doctor();
        engineer eng = new engineer();
        lawyer law = new lawyer();

        doc.Qualifications();
        eng.Qualifications();
        law.Qualifications();
    }
    
}
