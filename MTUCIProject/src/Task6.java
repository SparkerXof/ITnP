import javax.swing.plaf.basic.BasicMenuUI;
import java.util.*;
import java.util.regex.*;

public class Task6 {

    public static void run() {
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1,  2, -1,  4,  5,  6,  10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("-(-5)"));
        System.out.println(generateNonconsecutive("7 / 2"));
        System.out.println(isValid("abca"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
    }

    private static String hiddenAnagram(String line1, String line2) {
        line1 = line1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        line2 = line2.replaceAll("[^a-zA-Z]", "").toLowerCase();
        for (int i = 0; i <= line1.length()-line2.length(); i++) {
            if (line2.contains(String.valueOf(line1.charAt(i)))) {
                String tmpLine = line2;
                boolean full = true;
                for (int j = 0; j < line2.length(); j++) {
                    String symbol = String.valueOf(line1.charAt(i + j));
                    if (!tmpLine.contains(symbol)) {
                        full = false;
                        break;
                    }
                    tmpLine = tmpLine.replaceFirst(symbol, "");

                }
                if (full) {
                    return line1.substring(i, i+line2.length());
                }
            }
        }
        return "notfound";
    }

    private static String[] collect(String line, int size) {
        int array_size = line.length()/size;
        String[] lines = new String[array_size];

        if (lines.length > 0) {
            for (int i = 0; i < array_size; i++) {
                lines[i] = line.substring(size*i, (i+1)*size);
            }
        }

        return lines;
    }

    private static String nicoCipher(String message, String key) {
        String keyBase = key;
        String keyOrder = key;
        int[] order = new int[key.length()];
        int count = 1;
        for (int i = 0; i < keyOrder.length()-1; i++) {
            if (Character.isDigit(keyOrder.charAt(i))) {
                if ((int)keyOrder.charAt(i)-48 > count) {
                    count = keyOrder.charAt(i);
                }
                keyOrder = keyOrder.substring(0, i+1) + " " + keyOrder.substring(i+1);

            }
        }
        for (int i = 58; i < 127; i++) {
            while (keyOrder.contains(Character.toString((char)i))) {
                keyOrder = keyOrder.replaceFirst(Character.toString((char)i), count + " ");
                count++;
            }
        }
        String[] strOrder = keyOrder.split(" ");
        for (int i = 0; i < order.length; i++) {
            order[i] = Integer.parseInt(strOrder[i]);
        }
        char[][] matrix = new char[key.length()][(message.length()/key.length())+(message.length()%key.length()==0 ? 0 : 1)];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i*key.length()+j < message.length()) {
                    matrix[j][i] = message.charAt(i*key.length()+j);
                } else {
                    matrix[j][i] = ' ';
                }
            }
        }
        char[][] newMatrix = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < order.length; i++) {
            newMatrix[order[i]-1] = matrix[i];
        }
        StringBuilder encrypt = new StringBuilder();
        for (int i = 0; i < newMatrix[0].length; i++) {
            for (int j = 0; j < newMatrix.length; j++) {
                encrypt.append(newMatrix[j][i]);
            }
        }
        return encrypt.toString();
    }

    private static int[] twoProduct(int[] arr, int n) {
        int low = 0;
        int high = 0;
        int lenght = arr.length;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]*arr[j]==n && lenght > j-i) {
                    lenght = j-i;
                    low = arr[i];
                    high = arr[j];
                }
            }
        }
        if (low == 0 && high == 0) {
            return new int[]{};
        }
        return new int[]{low, high};
    }

    private static int[] isExact(int m) {
        int n = 1;
        int i = 1;
        while (i < m) {
            n += 1;
            i *= n;
        }
        if (i == m) {
            return new int[]{m, n};
        }
        return new int[0];
    }

    private static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return b;
    }
    private static String fractions(String num) {
        String[] frac = num.split("[.()]");
        int a = Integer.parseInt(frac[1] + frac[2]) - Integer.parseInt(Objects.equals(frac[1], "") ? "0" : frac[1]);
        int b = (int)Math.pow(10, frac[1].length());
        int nines = 0;
        for (Character nums : frac[2].toCharArray()) {
            nines *= 10;
            nines += 9;
        }
        b *= nines;
        int c = gcd(a, b);
        a /= c;
        b /= c;
        a += Integer.parseInt(frac[0])*b;
        return a + "/" + b;
    }

    private static String pilish_string(String line) {
        String pi = "314159265358979";
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder(line);
        for (Character num : pi.toCharArray()) {
            int n = Integer.parseInt(num.toString());
            if (tmp.isEmpty()) {
                break;
            }
            if (tmp.length() < n) {
                System.out.println(tmp.length());
                int toAdd = n-tmp.length();
                Character lastLetter = tmp.charAt(tmp.length()-1);
                tmp.append(String.valueOf(lastLetter).repeat(toAdd));
            }
            sb.append(tmp, 0, n).append(" ");
            tmp.replace(0, n, "");
        }
        return sb.toString().trim();
    }

    private static float generateNonconsecutive(String problem) {
        Pattern subPattern = Pattern.compile("\\([0-9\\-+()\\s]+\\)");
        Pattern minusMinusPattern = Pattern.compile("--[0-9]+");
        Matcher matcher = subPattern.matcher(problem);
        while (matcher.find()) {
            StringBuilder subProblem = new StringBuilder(matcher.group());
            subProblem.deleteCharAt(subProblem.length()-1).deleteCharAt(0);
            problem = problem.replace("(" + subProblem + ")", Float.toString(generateNonconsecutive(subProblem.toString())));
        }
        matcher = minusMinusPattern.matcher(problem);
        while (matcher.find()) {
            problem = matcher.replaceAll(matcher.group().substring(2));
            matcher = minusMinusPattern.matcher(problem);
        }
        String[] powDivArray = problem.split(" ");
        for (int i = 0; i < powDivArray.length; i++) {
            if (powDivArray[i].matches("[*/+-]") && (i==powDivArray.length-1 || i==0) ||
                    powDivArray[i].matches("[*/+-]") && !(powDivArray[i-1].matches("-?([0-9]+\\.)?[0-9]+") && powDivArray[i+1].matches("-?([0-9]+\\.)?[0-9]+"))) {
                throw new ArithmeticException("Wrong statement parameter: " + powDivArray[i]);
            }
        }
        ArrayList<String> minusPlusArray = new ArrayList<>();
        for (int i = 0; i < powDivArray.length; i++) {
            if (powDivArray[i].equals("*")) {
                minusPlusArray.add(Float.toString(Float.parseFloat(powDivArray[i-1]) * Float.parseFloat(powDivArray[i+1])));
            } else if (powDivArray[i].equals("/")) {
                if (powDivArray[i+1].equals("0")) {
                    throw new ArithmeticException("Attempt to divide " + powDivArray[i-1] + " by 0");
                }
                minusPlusArray.add(Float.toString(Float.parseFloat(powDivArray[i-1]) / Float.parseFloat(powDivArray[i+1])));
            } else {
                if ((i==powDivArray.length-1 || (!powDivArray[i+1].equals("*") && !powDivArray[i+1].equals("/"))) && (i==0 || (!powDivArray[i-1].equals("*") && !powDivArray[i-1].equals("/")))) {
                    minusPlusArray.add(powDivArray[i]);
                }
            }
        }
        float result = Float.parseFloat(minusPlusArray.get(0));
        for (int i = 1; i < minusPlusArray.size(); i++) {
            if (minusPlusArray.get(i).equals("+")) {
                result += Float.parseFloat(minusPlusArray.get(i+1));
            } else if (minusPlusArray.get(i).equals("-")) {
                result -= Float.parseFloat(minusPlusArray.get(i+1));
            }
        }
        return result;
    }

    private static String isValid(String line) {
        HashMap<Character, Integer> symbolsCount = new HashMap<>();
        for (Character symbol : line.toCharArray()) {
            if (!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol, 0);
            }
            symbolsCount.put(symbol, symbolsCount.get(symbol)+1);
        }
        int odds = 0;
        int minSymbolCount = symbolsCount.get(line.charAt(0));
        for (Integer i : symbolsCount.values()) {
            if (i < minSymbolCount) {
                minSymbolCount = i;
            }
        }
        for (Integer counts : symbolsCount.values()) {
            if (counts > minSymbolCount+1) {
                return "NO";
            }
            if (counts > minSymbolCount) {
                odds++;
            }
        }

        return ((odds <= 1) ? "YES" : "NO");
    }

    private static String findLCS(String line1, String line2) {
        int[][] matrix = new int[line1.length()+1][line2.length()+1];
        for (int i = 0; i < line1.length(); i++) {
            matrix[i][0] = 0;
        }
        for (int j = 0; j < line2.length(); j++) {
            matrix[0][j] = 0;
        }
        for (int i = 1; i < line1.length()+1; i++) {
            for (int j = 1; j < line2.length()+1; j++) {
                if (line1.charAt(i-1) == line2.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
                }
            }
        }
        int maxSize = matrix[line1.length()][line2.length()];
        StringBuilder lcs = new StringBuilder();
        for (int i = line1.length(); i > 0; i--) {
            for (int j = line2.length(); j > 0; j--) {
                if (matrix[i][j] == maxSize && matrix[i][j-1] < maxSize && matrix[i-1][j] < maxSize) {
                    lcs.insert(0, line1.charAt(i-1));
                    maxSize--;
                }
            }
        }

        return lcs.toString();
    }
}
