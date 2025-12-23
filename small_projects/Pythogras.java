import java.util.Scanner;

public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    double a;
    double b;
    double c;

    System.out.print("Enter the length of side A :");
    a = scanner.nextDouble();

    System.out.print("Enter the length of side B :");
    b = scanner.nextDouble();

    //most important thing we can't write directly
    c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));

    // ² = alt + 0178
    // ³ = alt + 0179
    System.out.print("The hypotenuse (side c) is: " + c + "cm²");

    scanner.close();

}