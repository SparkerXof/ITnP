import java.util.concurrent.*;
import java.lang.InterruptedException;
import java.util.ArrayList;
import java.util.List;

public class ArrayElementCounter {
    public static void main(String[] args) {

        int result = 0;
        List<Future<Integer>> values;
        int threads = 1;
        for (int i = 2; i < args.length; i++) {
            if (args.length%i == 0) {
                threads = i;
            }
        }
        int length = args.length/threads;
        int[][] nums = new int[threads][length];
        for (int i = 0; i < threads; i++) {
            for (int j = 0; j < length; j++) {
                try {
                    nums[i][j] = Integer.parseInt(args[(i*length)+j]);
                } catch (NumberFormatException e) {
                    System.out.println(args[(i*threads)+j] + "Not a number");
                    return;
                }
            }
        }

        List<Callable<Integer>> callableTasks = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            callableTasks.add(new CallableCounter(nums[i]));
        }
        
        ExecutorService execServ = Executors.newFixedThreadPool(threads);
        try {
            values = execServ.invokeAll(callableTasks);
        } catch (InterruptedException e) {
            System.out.println("Callable Error");
            return;
        }
        execServ.shutdown();
        for (Future<Integer> value : values) {
            try {
                result += value.get();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception");
                return;
            } catch (ExecutionException e) {
                System.out.println("Execution Exception");
                return;
            }
        }

        System.out.println("Sum of elements: " + result);
    }
}