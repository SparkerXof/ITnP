import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void run() {
        System.out.println("replaceVovels(\"apple\") -> " + replaceVovels("apple"));
        System.out.println("replaceVovels(\"Even if you did this task not by yourself, you have to understand every single line of code.\") -> " +
                replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));

        System.out.println("stringTransform(\"hello\") -> " + stringTransform("hello"));
        System.out.println("stringTransform(\"bookkeeper\") -> " + stringTransform("bookkeeper"));

        System.out.println("doesBlockFit(1, 3, 5, 4, 5) -> " + doesBlockFit(1, 3, 5, 4, 5));
        System.out.println("doesBlockFit(1, 8, 1, 1, 1) -> " + doesBlockFit(1, 8, 1, 1, 1));
        System.out.println("doesBlockFit(1, 2, 2, 1, 1) -> " + doesBlockFit(1, 2, 2, 1, 1));

        System.out.println("numCheck(243) -> " + numCheck(243));
        System.out.println("numCheck(52) -> " + numCheck(52));

        System.out.println("countRoots([1, -3, 2]) -> " + countRoots(new int[] {1, -3, 2}));
        System.out.println("countRoots([2, 5, 2]) -> " + countRoots(new int[] {2, 5, 2}));
        System.out.println("countRoots([1, -6, 9]) -> " + countRoots(new int[] {1, -6, 9}));

        System.out.println("salesData -> " + salesData(new String[][] {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}}));
        System.out.println("salesData -> " + salesData(new String[][] {{"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}}));

        System.out.println("validSplit(\"apple eagle egg goat\") -> " + validSplit("apple eagle egg goat"));
        System.out.println("validSplit(\"cat dog goose fish\") -> " + validSplit("cat dog goose fish"));

        System.out.println("waveForm([3, 1, 4, 2, 7, 5]) -> " + waveForm(new int[] {3, 1, 4, 2, 7, 5}));
        System.out.println("waveForm([1, 2, 3, 4, 5]) -> " + waveForm(new int[] {1, 2, 3, 4, 5}));
        System.out.println("waveForm([1, 2, -6, 10, 3]) -> " + waveForm(new int[] {1, 2, -6, 10, 3}));

        System.out.println("commonVovel(\"Hello world\") -> " + commonVovel("Hello world"));
        System.out.println("commonVovel(\"Actions speak louder than words.\") -> " + commonVovel("Actions speak louder than words."));

        System.out.println("dataScience -> " + Arrays.deepToString(dataScience(new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 29, 10},
                {5, 5, 5, 5, 35},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}})));
        System.out.println("dataScience -> " + Arrays.deepToString(dataScience(new int[][]{{6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}})));
    }

    public static String replaceVovels(String str) {
        final char[] vovels = {'a', 'o', 'e', 'u', 'y', 'i', 'A', 'O', 'E', 'U', 'Y', 'I'};
        for (char letter : vovels) {
            str = str.replace(letter, '*');
        }
        return str;
    }

    public static String stringTransform(String str) {
        char[] strArray = str.toCharArray();
        StringBuilder newstr = new StringBuilder();
        for (int i = 0; i < str.length()-1; i++) {
            if (strArray[i] == strArray[i+1]) {
                newstr.append("Double");
            } else {
                newstr.append(strArray[i]);
            }
        }
        newstr.append(strArray[str.length()-1]);
        return newstr.toString();
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        return (w >= a && (h >= b || h >= c)) || (w >= b && (h >= a || h >= c)) || (w >= c && (h >= a || h >= b));
    }

    public static boolean numCheck(int num1) {
        int tmp = num1, num2 = 0;
        while (tmp > 0) {
            num2 += (int)Math.pow(tmp % 10, 2);
            tmp /= 10;
        }
        return (num1 % 2) == (num2 % 2);
    }

    public static int countRoots(int[] array) {
        int d = array[1]*array[1] - 4*array[0]*array[2];
        double root1 = (-array[1] + Math.sqrt(d))/(2*array[0]);
        double root2 = (-array[1] - Math.sqrt(d))/(2*array[0]);
        return ((root1 % 1 == 0) ? 1 : 0) + ((root2 % 1 == 0) ? 1 : 0);
    }

    public static ArrayList<String> salesData(String[][] sales) {
        ArrayList<String> items = new ArrayList<String>();
        for (String[] shops : sales) {
            if (shops.length == 5) {
                boolean allShops = true;
                for (int j = 1; j < shops.length; j++) {
                    if (!shops[j].equals("Shop" + j)) {
                        allShops = false;
                        break;
                    }
                }
                if (allShops) { items.add(shops[0]); }
            }
        }
        return items;
    }

    public static boolean validSplit(String text) {
        String[] words = text.split(" ");
        int chainedWords = 0;
        for (int i = 0; i < words.length; i++) {
            boolean hasEndLink = false;
            boolean hasBeginLink = false;
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    if (words[i].charAt(0) == words[j].charAt(words[j].length()-1)) {
                        hasBeginLink = true;
                    }
                    else if (words[i].charAt(words[i].length()-1) == words[j].charAt(0)) {
                        hasEndLink = true;
                    }
                }
            }
            if (hasBeginLink && hasEndLink) {
                chainedWords++;
            }
        }
        return chainedWords >= words.length-2;
    }

    public static boolean waveForm(int[] array) {
        boolean isLastHigher = array[1] > array[0];
        for (int i = 2; i < array.length; i++) {
            if ((array[i] > array[i-1]) != isLastHigher) {
                isLastHigher = !isLastHigher;
            } else {
                return false;
            }
        }
        return true;
    }

    public static char commonVovel(String text) {
        final char[] VOVELS = {'a', 'o', 'e', 'u', 'y', 'i'};
        int[] vovelsCount = {0, 0, 0, 0, 0, 0};
        for (Character letter : text.toLowerCase().toCharArray()) {
            switch (letter) {
                case 'a' -> vovelsCount[0]++;
                case 'o' -> vovelsCount[1]++;
                case 'e' -> vovelsCount[2]++;
                case 'u' -> vovelsCount[3]++;
                case 'y' -> vovelsCount[4]++;
                case 'i' -> vovelsCount[5]++;
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < 6; i++) {
            if (vovelsCount[i] > vovelsCount[maxIndex]) { maxIndex = i; }
        }
        return VOVELS[maxIndex];
    }

    public static int[][] dataScience(int[][] data) {
        final int N = data.length;
        for (int i = 0; i < N; i++) {
            int result = 0;
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    result += data[j][i];
                }
            }
            data[i][i] = (int)Math.round( ((double)result)/(N-1) );
        }
        return data;
    }
}
