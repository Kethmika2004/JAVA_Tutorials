import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class AudioPlayer {
    public static void main(String[] args){
        
        //How to PLAY AUDIO with JAVA (.wav, .au, .aiff)

        String filePath = "C:\\Users\\ssn computres\\Desktop\\good for the ghost - Alge.wav";
        File file = new File(filePath);
        
        try(Scanner scanner = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = "";
            while(!response.equals("Q")){
                System.out.println("Audio Player Options:");
                System.out.println("P to play");
                System.out.println("R to reset");
                System.out.println("S to stop");
                System.out.println("Q to quit");
                System.out.println("Enter your choice: ");
                
                response = scanner.nextLine().toUpperCase();

                switch(response){
                    case "P":
                        clip.start();
                        System.out.println("Playing audio...");
                        break;
                    case "R":
                        clip.setMicrosecondPosition(0);
                        break;
                    case "S":
                        clip.stop();
                        clip.setFramePosition(0);
                        break;
                    case "Q":
                        clip.stop();
                        break;
                    default:
                        System.out.println("Invalid command.");
                }
            }


            clip.close();
        }
        catch(FileNotFoundException e){
            System.out.println("The specified audio file was not found.");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("The specified audio file is not supported.");
        }
        catch(LineUnavailableException e){
            System.out.println("Audio line for playing back is unavailable.");
        }
        catch(IOException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
        finally{
            System.out.println("Execution completed.");
        }
        

    }
}
