import java.util.Scanner;

public class WeightConverter {

    public static void main(String[] args) {

        //Weight Conversion Program
        Scanner scanner = new Scanner(System.in);

        double weight;
        double newWeight;
        int choice;

        System.out.println("Weight Conversion Program");
        System.out.println("1. Convert lbs to kgs");
        System.out.println("2. Convert kgs to lbs");

        System.out.println("Choose an option (1 or 2): ");
        choice = scanner.nextInt();
        
        if(choice == 1){
            System.out.println("Enter weight in lbs: ");
            weight = scanner.nextDouble();
            newWeight = weight * 0.453592;
            System.out.println("The new weight in kgs is: "+ newWeight);
        }
        else if(choice == 2){
            System.out.println("Enter the weight in kgs: ");
            weight = scanner.nextDouble();
            newWeight = weight * 2.20462;
            System.out.println("The new weight in lbs is:" + newWeight);
        }
        else{
            System.out.println("Invalid choice. Please select 1 or 2.");
        }

        scanner.close();
    }
}

