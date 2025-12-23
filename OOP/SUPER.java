public class SUPER {
public static void main(String[] args){

    //SUPER = Refers to the parent class (subclass <- Parent class)
    //        -A keyword used to access members of a parent class
    //        -very similar to the "this" keyword
    //        Used in constructors and method overriding
    //        Calls the parent constructor to initialize attributes.
    
    Person person = new Person("Yasandu", "Kethmika");
    Candidiate candidate = new Candidiate("Lasindi", "Manudula", 3.8, "UoM");
    Employee employee = new Employee("Lasindi", "Manudula", 50000);


    person.displayFullName();

    System.out.println("-------------------");
    candidate.showCandidateDetails();

    System.out.println("-------------------");
    employee.showEmployeeDetails();





    
    }

}
