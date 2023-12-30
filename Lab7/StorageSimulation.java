import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class StorageSimulation {
    public static void main(String[] args) {
        ForkJoinPool fjPool = new ForkJoinPool(3);
        ArrayList<Integer> storage1 = new ArrayList<>();
        ArrayList<Integer> storage2 = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            try {
                storage1.add(Integer.parseInt(args[i]));
            } catch (NumberFormatException e) {
                return;
            }
        }
        System.out.println(storage1.toString() + " " + storage2.toString());
        TransferAction transferAction = new TransferAction(storage1, storage2, 0, storage1.size());
        fjPool.invoke(transferAction);
        storage1.clear();
        System.out.println(storage1.toString() + " " + storage2.toString());
    }
}
