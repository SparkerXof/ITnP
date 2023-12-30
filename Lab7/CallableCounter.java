import java.util.concurrent.Callable;

public class CallableCounter implements Callable<Integer> {
    public int[] arrayPart;
    public Integer value = 0;

    public CallableCounter(int[] part) {
        arrayPart = part;
    }
    
    public Integer call() {
        for (Integer num : arrayPart) {
            value += num;
        }
        return value;
    }
}