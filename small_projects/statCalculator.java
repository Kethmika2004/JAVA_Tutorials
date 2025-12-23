import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class statCalculator {

    // A simple record to hold a class mark and its frequency.
    // This keeps our data organized.
    public record DataPoint(int mark, int frequency) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- 1. Get User Input ---
        System.out.println("--- Statistics Calculator ---");
        int numberOfClasses = 0;
        while (numberOfClasses <= 0) {
            System.out.print("Enter the number of classes: ");
            if (scanner.hasNextInt()) {
                numberOfClasses = scanner.nextInt();
                if (numberOfClasses <= 0) {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Clear the invalid input
            }
        }

        DataPoint[] data = new DataPoint[numberOfClasses];

        for (int i = 0; i < numberOfClasses; i++) {
            System.out.println("\n--- Class " + (i + 1) + " ---");
            
            int mark = 0;
            while (true) {
                System.out.print("Enter class mark: ");
                if (scanner.hasNextInt()) {
                    mark = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            int frequency = 0;
            while (frequency <= 0) {
                System.out.print("Enter frequency for mark " + mark + ": ");
                if (scanner.hasNextInt()) {
                    frequency = scanner.nextInt();
                    if (frequency <= 0) {
                        System.out.println("Frequency must be a positive number.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.next(); // Clear the invalid input
                }
            }
            
            data[i] = new DataPoint(mark, frequency);
        }
        scanner.close();

        // --- 2. Perform Calculations ---
        double mean = calculateMean(data);
        double median = calculateMedian(data);
        int mode = calculateMode(data);
        double variance = calculateVariance(data, mean);
        double stdDev = calculateStandardDeviation(variance);

        // --- 3. Display Results ---
        System.out.println("\n--- Statistical Results ---");
        System.out.printf("Mean:                  %.2f\n", mean);
        System.out.printf("Median:                %.2f\n", median);
        System.out.printf("Mode:                  %d\n", mode);
        System.out.printf("Sample Variance:       %.2f\n", variance);
        System.out.printf("Std. Deviation:        %.2f\n", stdDev);
    }

    /**
     * Calculates the mean (average) of the data.
     * Formula: Σ(xᵢ * fᵢ) / Σfᵢ
     */
    public static double calculateMean(DataPoint[] data) {
        long sumOfProducts = 0;
        long totalFrequency = 0;
        for (DataPoint dp : data) {
            sumOfProducts += (long) dp.mark() * dp.frequency();
            totalFrequency += dp.frequency();
        }
        if (totalFrequency == 0) return 0;
        return (double) sumOfProducts / totalFrequency;
    }

    /**
     * Calculates the median (middle value) of the data.
     * This requires "unrolling" the frequency data into a single list and sorting it.
     */
    public static double calculateMedian(DataPoint[] data) {
        List<Integer> allValues = new ArrayList<>();
        for (DataPoint dp : data) {
            for (int i = 0; i < dp.frequency(); i++) {
                allValues.add(dp.mark());
            }
        }

        if (allValues.isEmpty()) {
            return 0;
        }

        Collections.sort(allValues);
        int n = allValues.size();
        int middleIndex = n / 2;

        if (n % 2 == 1) { // Odd number of elements
            return allValues.get(middleIndex);
        } else { // Even number of elements
            return (allValues.get(middleIndex - 1) + allValues.get(middleIndex)) / 2.0;
        }
    }

    /**
     * Calculates the mode (most frequent value) of the data.
     */
    public static int calculateMode(DataPoint[] data) {
        if (data == null || data.length == 0) {
            // Or throw an exception, depending on desired behavior
            return 0; 
        }

        int mode = data[0].mark();
        int maxFrequency = data[0].frequency();

        for (int i = 1; i < data.length; i++) {
            if (data[i].frequency() > maxFrequency) {
                maxFrequency = data[i].frequency();
                mode = data[i].mark();
            }
        }
        return mode;
    }

    /**
     * Calculates the sample variance of the data.
     * Formula: Σ[fᵢ * (xᵢ - μ)²] / (N - 1)
     * where μ is the mean and N is the total frequency.
     */
    public static double calculateVariance(DataPoint[] data, double mean) {
        long totalFrequency = 0;
        for (DataPoint dp : data) {
            totalFrequency += dp.frequency();
        }

        if (totalFrequency <= 1) {
            return 0; // Variance is 0 for a single data point or empty set
        }

        double sumOfSquaredDifferences = 0.0;
        for (DataPoint dp : data) {
            double difference = dp.mark() - mean;
            sumOfSquaredDifferences += dp.frequency() * (difference * difference);
        }

        return sumOfSquaredDifferences / (totalFrequency - 1);
    }

    /**
     * Calculates the standard deviation from the variance.
     * Formula: √Variance
     */
    public static double calculateStandardDeviation(double variance) {
        return Math.sqrt(variance);
    }
}
