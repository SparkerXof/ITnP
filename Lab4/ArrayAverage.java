import java.util.ArrayList;
import ExceptionLogger.ExceptionLogger;

public class ArrayAverage {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int avg = 0;
        
        for (String num : args) {
            try {
                arr.add(Integer.parseInt(num));
            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid integer: " + num);
                ExceptionLogger.log(nfe);
            }
        }
        
        try {
            for (int i = 0; i < arr.size(); i++) {
                avg += arr.get(i);
            }
            avg /= arr.size();
            System.out.println(avg);
        }
        catch (NullPointerException npe) {
            System.out.println("Null pointer in the array");
            ExceptionLogger.log(npe);
        }
        catch (ArrayIndexOutOfBoundsException aiooe) {
            System.out.println("Invalid index for array");
            ExceptionLogger.log(aiooe);
        }
        catch (ArithmeticException ae) {
            System.out.println("No numbers");
            ExceptionLogger.log(ae);
        }
    }
}