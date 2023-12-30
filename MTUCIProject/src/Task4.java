import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task4 {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Map<String, Integer> oneDigits = new HashMap<String, Integer>() {{ put("one", 1);
        put("two", 2); put("three", 3); put("four", 4); put("five", 5);
        put("six", 6); put("seven", 7); put("eight", 8); put("nine", 9);
    }};
    private static final Map<String, Integer> teenDigits = new HashMap<String, Integer>() {{
        put("ten", 10); put("eleven", 11); put("twelve", 12); put("thirteen", 13); put("fourteen", 14);
        put("fifteen", 15); put("sixteen", 16); put("seventeen", 17); put("eighteen", 18); put("nineteen", 19);
    }};
    private static final Map<String, Integer> twoDigits = new HashMap<String, Integer>() {{
        put("twenty", 20); put("thirty", 30); put("forty", 40); put("fifty", 50);
        put("sixty", 60); put("seventy", 70); put("eighty", 80); put("ninety", 90);
    }};
    public static void run() {
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));

        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));

        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));

        System.out.println(letterPatters("aaabbcdd"));
        System.out.println(letterPatters("vvvvaajaaaaa"));

        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        System.out.println(shortestWay(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(shortestWay(new int[][] {{2, 7, 3}, {1, 4, 8}, {4, 5, 9}}));

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    private static String nonRepeatable(String line) {
        if (line.equals("")) {
            return line;
        }
        return line.charAt(0) + nonRepeatable(line.replaceAll(String.valueOf(line.charAt(0)), ""));
    }

    private static ArrayList<String> generateBrackets(int nums) {
        ArrayList<String> brackets = new ArrayList<String>();
        if (nums <= 1) {
            brackets.add("()");
            return brackets;
        }
        ArrayList<String> preBrackets = generateBrackets(nums-1);
        brackets.addAll(preBrackets);
        brackets.replaceAll(s -> "(" + s + ")");
        for (int i = 0; i < preBrackets.size()-1; i++) {
            if (!brackets.contains("()" + preBrackets.get(i))) {
                brackets.add("()" + preBrackets.get(i));
            }
            if (!brackets.contains(preBrackets.get(i) + "()")) {
                brackets.add(preBrackets.get(i) + "()");
            }
        }
        String lastBrackets = "()".repeat(nums);
        brackets.add(lastBrackets);
        return brackets;
    }

    private static ArrayList<String> binarySystem(int nums) {
        ArrayList<String> binStr = new ArrayList<String>();
        if (nums <= 1) {
            binStr.add("0");
            binStr.add("1");
            return binStr;
        }
        ArrayList<String> baseArray = binarySystem(nums-1);
        for (String s : baseArray) {
            if (s.charAt(s.length() - 1) == '0') {
                binStr.add(s + "1");
            } else {
                binStr.add(s + "0");
                binStr.add(s + "1");
            }
        }
        return binStr;
    }

    private static String alphabeticRow(String line) {
        String resultRow = "";
        StringBuilder tmpRow = new StringBuilder(String.valueOf(line.charAt(0)));
        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) != 'a' && line.charAt(i-1) == ALPHABET.charAt(ALPHABET.indexOf(line.charAt(i))-1)) {
                tmpRow.append(line.charAt(i));
            } else {
                if (tmpRow.length() > resultRow.length()) {
                    resultRow = tmpRow.toString();
                }
                tmpRow = new StringBuilder(String.valueOf(line.charAt(i)));
            }
        }
        if (tmpRow.length() > resultRow.length()) {
            resultRow = tmpRow.toString();
        }
        tmpRow = new StringBuilder(String.valueOf(line.charAt(0)));
        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) != 'z' && line.charAt(i-1) == ALPHABET.charAt(ALPHABET.indexOf(line.charAt(i))+1)) {
                tmpRow.append(line.charAt(i));
            } else {
                if (tmpRow.length() > resultRow.length()) {
                    resultRow = tmpRow.toString();
                }
                tmpRow = new StringBuilder(String.valueOf(line.charAt(i)));
            }
        }
        if (tmpRow.length() > resultRow.length()) {
            resultRow = tmpRow.toString();
        }
        return resultRow;
    }

    private static ArrayList<String> stringQuicksort(ArrayList<String> arr) {
        if (arr.size() == 0) {
            return arr;
        }
        String pivot = arr.get(0);
        ArrayList<String> leftArray = new ArrayList<String>();
        ArrayList<String> rightArray = new ArrayList<String>();
        for (int i = 1; i < arr.size(); i++) {
            if ((int) pivot.charAt(1) > (int) arr.get(i).charAt(1)) {
                leftArray.add(arr.get(i));
            } else {
                rightArray.add(arr.get(i));
            }
        }
        ArrayList<String> result = new ArrayList<String>(stringQuicksort(leftArray));
        result.add(pivot);
        result.addAll(stringQuicksort(rightArray));
        return result;
    }
    private static String letterPatters(String line) {
        ArrayList<String> letterCounts = new ArrayList<String>();
        int count = 1;
        char letter = line.charAt(0);
        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) == letter) {
                count++;
            } else {
                letterCounts.add(letter + String.valueOf(count));
                letter = line.charAt(i);
                count = 1;
            }
        }
        letterCounts.add(letter + String.valueOf(count));
        StringBuilder result = new StringBuilder();

        ArrayList<String> newArray = stringQuicksort(letterCounts);

        for (String pairs : newArray) {
            result.append(pairs);
        }
        return result.toString();
    }

    private static int convertToNum(String text) {
        int result = 0;
        String[] words = text.split(" ");
        for (int i = words.length-1; i >= 0; i--) {
            if (words[i].equals("hundred")) {
                result += oneDigits.get(words[i-1]) * 100;
                break;
            } else if (twoDigits.containsKey(words[i])) {
                result += twoDigits.get(words[i]);
            } else if (teenDigits.containsKey(words[i])) {
                result += teenDigits.get(words[i]);
            } else if (oneDigits.containsKey(words[i])) {
                result += oneDigits.get(words[i]);
            }
            else {
                return -1;
            }
        }
        return result;
    }

    private static String uniqueSubstring(String line) {
        String result = "";
        StringBuilder tmp = new StringBuilder();
        for (Character letter : line.toCharArray()) {
            if (!tmp.toString().contains(letter.toString())) {
                tmp.append(letter);
            }
            else {
                if (tmp.length() > result.length()) {
                    result = tmp.toString();
                    tmp = new StringBuilder();
                }
            }
        }
        if (tmp.length() > result.length()) {
            result = tmp.toString();
        }
        return result;
    }

    private static int shortestWay(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            matrix[0][i] += matrix[0][i-1];
            matrix[i][0] += matrix[i-1][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                matrix[i][j] += Math.min(matrix[i-1][j], matrix[i][j-1]);
            }
        }
        return matrix[matrix.length-1][matrix.length-1];
    }

    private static String numericOrder(String baseLine) {
        String[] wordsArray = baseLine.split(" ");
        String[] lineSorter = new String[wordsArray.length];
        for (String word : wordsArray) {
            StringBuilder number = new StringBuilder();
            for (Character letter : word.toCharArray()) {
                if (Character.isDigit(letter)) {
                    number.append(letter);
                }
            }
            lineSorter[Integer.parseInt(number.toString())-1] = word.replace(number, "") + " ";
        }
        StringBuilder resultLine = new StringBuilder();
        for (String word : lineSorter) {
            resultLine.append(word);
        }
        return resultLine.toString();
    }

    private static ArrayList<Integer> intQuicksort(ArrayList<Integer> arr) {
        if (arr.size() == 0) {
            return arr;
        }
        int pivot = arr.get(0);
        ArrayList<Integer> leftArray = new ArrayList<Integer>();
        ArrayList<Integer> rightArray = new ArrayList<Integer>();
        for (int i = 1; i < arr.size(); i++) {
            if (pivot < arr.get(i)) {
                leftArray.add(arr.get(i));
            } else {
                rightArray.add(arr.get(i));
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>(intQuicksort(leftArray));
        result.add(pivot);
        result.addAll(intQuicksort(rightArray));
        return result;
    }
    private static int switchNums(int a, int b) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        do {
            if (a%10 > 0) {
                digits.add(a % 10);
            }
            a /= 10;
        } while (a > 0);
        digits = intQuicksort(digits);
        for (int i = 0; i < String.valueOf(b).length(); i++) {
            if (digits.get(0) > Character.getNumericValue(String.valueOf(b).charAt(i))) {
                char[] tmp = String.valueOf(b).toCharArray();
                tmp[i] = (char) (digits.get(0)+'0');
                b = Integer.parseInt(String.valueOf(tmp));
                digits.remove(0);
            }
        }

        return b;
    }
}
