public class Student {

    //key attributes
    String name;
    int age;
    double GPA;
    boolean isEnrolled;

    //constructor
    Student(String name, int age, double GPA){
        this.name = name;
        this.age = age;
        this.GPA = GPA;
        this.isEnrolled = true;
    }

    //method(action)
    void study(){
        System.out.println(this.name + " is Studying");
    }

}
