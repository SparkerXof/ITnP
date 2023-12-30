import java.util.concurrent.*;
import java.lang.InterruptedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class MaxMatrixElement {
    public static void main(String[] args) {
        int height;
        int width;
        int maxValue;
        try {
            height = Integer.parseInt(args[0]);
            width = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            return;
        }
        int[][] matrix = new int[height][width];
        Random rand = new Random();
        System.out.println("Matrix:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i][j] = rand.nextInt(1000);
            }
            System.out.println(Arrays.toString(matrix[i]));
        }

        List<Callable<Integer>> callableTasks = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            callableTasks.add(new CallableMaxValue(matrix[i]));
        }
        ExecutorService execServ = Executors.newFixedThreadPool(height);
        List<Future<Integer>> maxValues;
        try {
            maxValues = execServ.invokeAll(callableTasks);
        } catch (InterruptedException e) {
            System.out.println("Callable Error");
            return;
        }
        int[] lastValues = new int[height];
        for (int i = 0; i < height; i++) {
            try {
                lastValues[i] = maxValues.get(i).get();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception");
                return;
            } catch (ExecutionException e) {
                System.out.println("Execution Exception");
                return;
            }
        }
        try {
            maxValue = execServ.submit(new CallableMaxValue(lastValues)).get();
        } catch (InterruptedException e) {
            System.out.println("Callable Error");
            return;
        } catch (ExecutionException e) {
            System.out.println("Execution Exception");
            return;
        }
        execServ.shutdown();
        System.out.println("Max value: " + maxValue);
    }
}
