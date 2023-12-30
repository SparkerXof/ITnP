import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void run() {
        System.out.println("duplicateChars(\"Donald\") -> " + duplicateChars("Donald"));
        System.out.println("duplicateChars(\"orange\") -> " + duplicateChars("orange"));

        System.out.println("getInitials(\"Ryan Gosling\") -> " + getInitials("Ryan Gosling"));
        System.out.println("getInitials(\"Barack Obama\") -> " + getInitials("Barack Obama"));

        System.out.println("differenceEvenOdd([44, 32, 86, 19]) -> " + differenceEvenOdd(new int[] {44, 32, 86, 19}));
        System.out.println("differenceEvenOdd([22, 50, 16, 63, 31, 55]) -> " + differenceEvenOdd(new int[] {22, 50, 16, 63, 31, 55}));

        System.out.println("equalToAvg([1, 2, 3, 4, 5]) -> " + equalToAvg(new int[] {1, 2, 3, 4, 5}));
        System.out.println("equalToAvg([1, 2, 3, 4, 6]) -> " + equalToAvg(new int[] {1, 2, 3, 4, 6}));

        System.out.println("indexMult([1, 2, 3]) -> " + Arrays.toString(indexMult(new int[] {1, 2, 3})));
        System.out.println("indexMult([3, 3, -2, 408, 3, 31]) -> " + Arrays.toString(indexMult(new int[] {3, 3, -2, 408, 3, 31})));

        System.out.println("reverse(\"Hello World\") -> " + reverse("Hello World"));
        System.out.println("reverse(\"The quick brown fox\") -> " + reverse("The quick brown fox."));

        System.out.println("tribonacci(7) -> " + tribonacci(7));
        System.out.println("tribonacci(11) -> " + tribonacci(11));

        System.out.println("pseudoHash(5) -> " + pseudoHash(5));
        System.out.println("pseudoHash(10) -> " + pseudoHash(10));
        System.out.println("pseudoHash(0) -> " + pseudoHash(0));

        System.out.println("botHelper(\"Hello, I’m under the water, please helps me\") -> " + botHelper("Hello, I’m under the water, please helps me"));
        System.out.println("botHelper(\"Two pepperoni pizzas please\") -> " + botHelper("Two pepperoni pizzas please"));

        System.out.println("isAnagram(\"listen\", \"silent\") -> " + isAnagram("listen", "silent"));
        System.out.println("isAnagram(\"eleven plus two\", \"twelve plus one\") -> " + isAnagram("eleven plus two", "twelve plus one"));
        System.out.println("isAnagram(\"hello\", \"world\") -> " + isAnagram("hello", "world"));
    }

    public static boolean duplicateChars(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) { return true; }
            }
        }
        return false;
    }

    public static String getInitials(String str) {
        String[] name = str.split(" ");
        if (name.length == 2) {
            String initials = "";
            initials += name[0].charAt(0) + name[1].charAt(0);
            return initials;
        }
        return "No initials";
    }

    public static int differenceEvenOdd(int[] array) {
        int[] evenOdd = {0, 0};
        for (int num : array) { evenOdd[num % 2] += num; }
        return Math.abs(evenOdd[0] - evenOdd[1]);
    }

    public static boolean equalToAvg(int[] array) {
        float avg = 0;
        for (int num : array) {
            avg += num;
        }
        avg /= array.length;
        for (int num : array) {
            if (num == avg) { return true; }
        }
        return false;
    }
    public static int[] indexMult(int[] array) {
        for (int i = 0; i < array.length; i++) { array[i] *= i; }
        return array;
    }

    public static String reverse(String str) {
        StringBuilder res = new StringBuilder(str);
        return res.reverse().toString();
    }

    public static int tribonacci(int len) {
        int[] trib = {0, 0, 1};
        int tmp;
        for (int i = 3; i < len; i++) {
            tmp = trib[0] + trib[1] + trib[2];
            trib[0] = trib[1];
            trib[1] = trib[2];
            trib[2] = tmp;
        }
        if (len <= 3) { return trib[len-1]; }
        return trib[2];
    }

    public static String pseudoHash(int len) {
        char[] symb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder hash = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < len; i++) { hash.append(symb[rand.nextInt(16)]); }
        return hash.toString();
    }

    public static String botHelper(String msg) {
        String[] words = msg.toLowerCase().split(" ");
        for (String word : words) {
            if (word.equals("help")) {
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() == str2.length()) {
            for (Character letter : str1.toCharArray()) {
                if (!str2.contains(letter.toString())) {
                    return false;
                }
                str2 = str2.replaceFirst(letter.toString(), "");
            }
            return true;
        }
        return false;
    }
}
