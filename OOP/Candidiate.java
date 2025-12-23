public class Candidiate extends Person {

    double GPA;
    String university;

    Candidiate(String first, String second, double gpa, String uni) {
        super(first, second); //calling parent constructor
        
        this.GPA = gpa;
        this.university = uni;
    }

    void showCandidateDetails() {
        System.out.println("Candidate Details:");
        System.out.println("Full Name: " + this.first_name + " " + this.last_name);
        System.out.println("GPA: " + this.GPA);
        System.out.println("University: " + this.university);
    }
    
}
