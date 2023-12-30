package ExceptionLogger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionLogger {
    public static void log(Exception e) {
        try {
            FileWriter log = new FileWriter("error.log");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            log.write(sw.toString());
            log.close();
        }
        catch (IOException ioe) {
            System.out.println("No access to error.log. Delete it!");
        } 
    }
}
