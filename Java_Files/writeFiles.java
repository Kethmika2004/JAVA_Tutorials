import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class writeFiles {
    public static void main(String[] args){

        // How to write a file using Java(4 popular ways)

        //FileWriter = Good for small or medium_sized text files
        //BufferedWriter = Better perfomance for large amounts of text
        //PrintWriter = Best for Structured data, like reports or logs
        //FilesOutputStream = Best for Binary files (e.g.; images, audio, video)


        try(FileWriter writer = new FileWriter("C:\\Users\\ssn computres\\Desktop\\test.txt");){
            writer.write("Hello World!\n");
            writer.write("Welcome to Java Programming.");
            writer.close();
            System.out.println("Successfully wrote to the file.");

        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("An error occurred.");
        }
    }
}
