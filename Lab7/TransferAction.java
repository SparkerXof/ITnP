import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class TransferAction extends RecursiveAction {
    ArrayList<Integer> storage1;
    ArrayList<Integer> storage2;
    private int totalSize;
    private final int LIMIT = 150;
    private int begin;
    private int end;

    public TransferAction(ArrayList<Integer> storage1, ArrayList<Integer> storage2, int begin, int end) {
        this.storage1 = storage1;
        this.storage2 = storage2;
        for (int i = begin; i < end; i++) {
            totalSize += storage1.get(i);
        }
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (totalSize < LIMIT) {
            ArrayList<Integer> load = new ArrayList<>();
            for (int i = begin; i < end; i++) {
                load.add(storage1.get(i));
            }
            for (int i = begin; i < end; i++) {
                storage2.add(load.remove(0));
            }
        } else {
            int center = (end+begin)/2;
            TransferAction subTask1 = new TransferAction(storage1, storage2, begin, center);
            TransferAction subTask2 = new TransferAction(storage1, storage2, center, end);

            invokeAll(subTask1, subTask2);
        }
    }
}
