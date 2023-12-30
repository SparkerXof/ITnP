import java.io.*;
import java.util.Scanner;
import ExceptionLogger.ExceptionLogger;

public class CopyContent {
    public static void main(String[] args) {
        File input_file;
        FileWriter output_file;
        try {
            input_file = new File(args[0]);
            output_file = new FileWriter(args[1]);
            
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough arguments");
            ExceptionLogger.log(e);
            return;
        }
        catch (NullPointerException e) {
            System.out.println("Null in some arguments");
            ExceptionLogger.log(e);
            return;
        }
        catch (IOException e) {
            System.out.println("Unknown error");
            ExceptionLogger.log(e);
            return;
        }

        try {
            Scanner scan = new Scanner(input_file);
            while (scan.hasNextLine()) {
                output_file.write(scan.nextLine() + "\n");
            }
            output_file.close();
            scan.close();
            System.out.println("Content copied");
        }
        catch (FileNotFoundException e) {
            System.out.println("No such input file");
            ExceptionLogger.log(e);
        }
        catch (IOException e) {
            System.out.println("Unknown IO error");
            ExceptionLogger.log(e);
        }
    }
}
