import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class COUNTDOWN {
    public static void main(String[] args) {
        // JAVA COUNTDOWN timer program
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~Secret message for you, babe~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        String filepath = "C:\\Users\\ssn computres\\Documents\\lasi.txt";
        
        // Read all lines from the file at the beginning
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate file");
            return;
        } catch (IOException e) {
            System.out.println("Something went wrong!");
            return;
        }
        
        // If no lines were read, exit
        if (lines.isEmpty()) {
            System.out.println("File is empty or could not be read");
            return;
        }
        
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            private int currentIndex = 0;
            
            @Override
            public void run() {
                // Print the current line
                System.out.println(lines.get(currentIndex));
                currentIndex++;
                
                // If we've printed all lines, cancel the timer
                if (currentIndex >= lines.size()) {
                    System.out.println("I LOVE YOU! MY LASII");
                    timer.cancel();
                }
            }
        };
        
        timer.scheduleAtFixedRate(task, 0, 2000); // (task, delay, period)
    }
}