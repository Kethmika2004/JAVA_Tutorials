import java.util.Scanner;

public class TempretureCONVERTER {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double temp;
        double newTemp;
        String unit;

        System.out.println("Enter the temperature: ");
        temp = scanner.nextDouble();

        System.out.println("Convert the celsius to fahrenheit (C) or fahrenheit to celsius (F): ");
        unit = scanner.next().toUpperCase();

        newTemp = (unit.equals("C")) ? (temp - 32) * 5 / 9 : (temp * 5 / 9) + 32;
        System.out.printf("%.1f° %s", newTemp, unit); //° = alt + 0176

        scanner.close();
    }
    
}
