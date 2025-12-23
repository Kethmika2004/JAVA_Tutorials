public class Employee extends Person {
    int salary;

    Employee(String first, String second, int sal){
        super(first, second);
        this.salary = sal;
    }

    void showEmployeeDetails(){
        System.out.println("Employee Details:");
        System.out.println("Full Name: " + this.first_name + " " + this.last_name);
        System.out.println("Salary: Rs." + this.salary);
    }
    
}
