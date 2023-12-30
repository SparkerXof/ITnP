import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class TopWords {
    public static void main(String args[]) {
        File text = new File("./input");
        Scanner scanner;
        try {
            scanner = new Scanner(text);
        } catch (FileNotFoundException e) {
            System.out.println("No 'input' file in root");
            return;
        }
        HashMap<String, Integer> wordsCollection = new HashMap<String, Integer>();

        while (scanner.hasNext()) {
            String nextWord = scanner.next().replaceAll("[,.]", "").toLowerCase();
            if (!wordsCollection.containsKey(nextWord)) {
                wordsCollection.put(nextWord, 1);
            } else {
                wordsCollection.replace(nextWord, wordsCollection.get(nextWord)+1);
            }
        }
        scanner.close();
        int topSize = wordsCollection.entrySet().size() >= 10 ? 10 : wordsCollection.entrySet().size();
        for (int i = 1; i <= topSize; i++) {
            Map.Entry<String, Integer> maxCount = null;
            for (Map.Entry<String, Integer> word : wordsCollection.entrySet()) {
                if (maxCount == null || maxCount.getValue() < word.getValue()) {
                    maxCount = Map.entry(word.getKey(), word.getValue());
                }
            }
            System.out.println(maxCount.getKey() + " - " + maxCount.getValue());
            wordsCollection.remove(maxCount.getKey());
        }
    }
}