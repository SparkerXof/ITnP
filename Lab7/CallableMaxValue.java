import java.util.concurrent.Callable;

public class CallableMaxValue implements Callable<Integer> {
    public int[] array;
    public Integer value = 0;

    public CallableMaxValue(int[] part) {
        array = part;
    }
    
    public Integer call() {
        for (Integer num : array) {
            if (value < num) {
                value = num;
            }
        }
        return value;
    }
}