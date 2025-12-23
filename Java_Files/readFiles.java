import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readFiles {
    public static void main(String[] args){

        //BufferedReader + File Reader : Best for reading text files line by line
        //FileInputStream : Best for binary files (images, audio, video)
        //RandomAccessFile : Best for read/write specific portions of a large file.

        String filepath = "C:\\Users\\ssn computres\\Documents\\YKpvt.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Could not locate file");
        }
        catch(IOException e){
            System.out.println("Something went wrong!");
        }
    }
}
