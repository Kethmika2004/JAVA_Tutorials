public class OOPconstructors {
    public static void main(String[] args){

        Student student1 = new Student("Kethmika", 21, 3.6);
        Student student2 = new Student("Lasindi", 21, 3.40);
        Student student3 = new Student("Hiruka", 19, 3.40);

        System.out.println(student1.name);
        System.out.println(student1.age);
        System.out.println(student1.GPA);
        System.out.println(student1.isEnrolled);

        System.out.println();

        student3.isEnrolled = false;
        System.out.println(student3.name);
        System.out.println(student3.age);
        System.out.println(student3.GPA);
        System.out.println(student3.isEnrolled);

        student1.study();
        student2.study();
        student3.study();

    }
    
}
