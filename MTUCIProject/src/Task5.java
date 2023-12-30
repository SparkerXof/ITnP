import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task5 {

    private static final Map<String, Integer> MONTHS = new HashMap<String, Integer>() {{
        put("January", 1); put("February", 2); put("March", 3); put("April", 4);
        put("May", 5); put("June", 6); put("July", 7); put("August", 8);
        put("September", 9); put("October", 10); put("November", 11); put("December", 12);
    }};

    private static final Map<String, Integer> CITIES = new HashMap<String, Integer>() {{
        put("Los Angeles", -480); put("New York", -300); put("Caracas", -270);
        put("Buenos Aires", -180); put("London", 0); put("Rome", 60);
        put("Moscow", 180); put("Tehran", 210); put("New Delhi", 330);
        put("Beijing", 480); put("Canberra", 600);
    }};

    public static void run() {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println(spiderVsFly("H4", "C2"));
        System.out.println(digitsCount(5666));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println(totalPoints(new String[] {"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println(Arrays.deepToString(sumsUp(new int[] {1, 2, 3, 4, 5})));
        System.out.println(Arrays.deepToString(sumsUp(new int[] {1, 2, 3, 7, 9})));
        System.out.println(Arrays.deepToString(sumsUp(new int[] {10, 9, 7, 2, 8})));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7})));
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }

    private static boolean sameLetterPattern(String pattern1, String pattern2) {
        Map<Character, Integer> pattern1Letters = new HashMap<>();
        Map<Character, Integer> pattern2Letters = new HashMap<>();;
        if (pattern1.length() == pattern2.length()) {
            for (int i = 0; i < pattern1.length(); i++) {
                char nextChar = pattern1.charAt(i);
                if (!Character.isDigit(nextChar)) {
                    if (!pattern1Letters.containsKey(nextChar) && !Character.isDigit(nextChar)) {
                        pattern1Letters.put(nextChar, pattern1Letters.size());
                    }
                    pattern1 = pattern1.replaceFirst(String.valueOf(nextChar), String.valueOf(pattern1Letters.get(nextChar)));
                }
                nextChar = pattern2.charAt(i);
                if (!Character.isDigit(nextChar)) {
                    if (!pattern2Letters.containsKey(nextChar) && !Character.isDigit(nextChar)) {
                        pattern2Letters.put(nextChar, pattern2Letters.size());
                    }
                    pattern2 = pattern2.replaceFirst(String.valueOf(nextChar), String.valueOf(pattern2Letters.get(nextChar)));
                }
            }
            return pattern1.equals(pattern2);
        }
        return false;
    }

    private static double getRouteLentgh(int spiderRing, int ringParts, int offset) {
        final double RING_PART = Math.sqrt(2-(2*Math.cos(45)));
        return offset*2 + (spiderRing-offset)*ringParts*RING_PART;
    }
    private static String getRingRoute(int spiderRay, int flyRay, int rays, int ring) {
        StringBuilder route = new StringBuilder();
        if ((spiderRay+rays)%8 == flyRay) {
            for (int i = 1; i <= rays; i++) {
                route.append("-").append(Character.toString((spiderRay + i) % 8 + 65)).append(ring);
            }
        } else if ((spiderRay-rays)%8 == flyRay) {
            for (int i = 1; i <= rays; i++) {
                route.append("-").append(Character.toString((spiderRay - i) % 8 + 65)).append(ring);
            }
        }
        return route.toString();
    }
    private static String spiderVsFly(String spiderBase, String flyBase) {
        int spiderRay = spiderBase.charAt(0) - 65;
        int spiderRing = spiderBase.charAt(1) - 48;
        int flyRay = flyBase.charAt(0) - 65;
        int flyRing = flyBase.charAt(1) - 48;
        int rays;
        StringBuilder route = new StringBuilder(spiderBase);

        if (Math.abs(spiderRay - flyRay) >= 4) {
            rays = 8-Math.abs(spiderRay - flyRay);
        } else {
            rays = Math.abs(spiderRay - flyRay);
        }
        if (spiderRing > flyRing) {
            for (int i = spiderRing-1; i >= flyRing; i--) {
                route.append("-").append(Character.toString(spiderRay + 65)).append(i);
                spiderRing--;
            }
        }
        int shortOffset = 0;
        for (int i = 1; i <= spiderRing; i++) {
            if (getRouteLentgh(spiderRing, rays, shortOffset) > getRouteLentgh(spiderRing, rays, i)) {
                shortOffset = i;
            }
        }
        for (int i = spiderRing-1; i >= spiderRing-shortOffset; i--) {
            route.append("-").append(i == 0 ? "A" : Character.toString(spiderRay + 65)).append(i);
        }
        if (spiderRing-shortOffset > 0) {
            route.append(getRingRoute(spiderRay, flyRay, rays, spiderRing-shortOffset));
        }
        for (int i = spiderRing-shortOffset+1; i <= flyRing; i++) {
            route.append("-").append(Character.toString(flyRay + 65)).append(i);
        }

        return route.toString();
    }

    private static int digitsCount(long num) {
        return 1 + (num > 9 ? digitsCount(num / 10) : 0);
    }

    private static int totalPoints(String[] words, String baseWord) {
        int points = 0;
        for (String word : words) {
            String base = baseWord;
            int matches = 0;
            for (Character letter : word.toCharArray()) {
                if (base.contains(letter.toString())) {
                    base = base.replaceFirst(letter.toString(), "");
                    matches++;
                } else {
                    break;
                }
            }
            if (word.length() == matches) {
                points += matches-2 + (matches == 6 ? 50 : 0);
            }
        }
        return points;
    }

    private static Integer[][] sumsUp(int[] nums) {
        ArrayList<Integer> firstParts = new ArrayList<Integer>();
        ArrayList<Integer[]> pairs = new ArrayList<Integer[]>();

        for (Integer num : nums) {
            if (firstParts.contains(8-num)) {
                pairs.add(num < 8-num ? new Integer[] {num, 8-num} : new Integer[] {8-num, num});
                firstParts.remove(num);
            }
            else {
                firstParts.add(num);
            }
        }
        Integer[][] objects = new Integer[pairs.size()][2];
        objects = pairs.toArray(objects);
        return objects;
    }

    private static String takeDownAverage(String[] percents) {
        float avg = 0;
        int nums = 0;
        for (String percent : percents) {
            avg += Integer.parseInt(percent.split("%")[0]);
            nums++;
        }
        avg = (avg/nums)-((nums+1)*5);
        return Math.round(avg) + "%";
    }

    private static String caesarCipher(String type, String baseLine, int pos) {
        StringBuilder line = new StringBuilder(baseLine.toUpperCase());
        for (int i = 0; i < line.length(); i++) {
            int letter = line.charAt(i);
            if (letter > 64 && letter <= 90) {
                letter += pos;
                if (letter <= 64) {
                    letter += 26;
                } else if (letter > 90) {
                    letter -= 26;
                }
                line.setCharAt(i, (char)letter);
            }
        }

        return line.toString();
    }

    private static int setSetup(int n, int k) {
        return n * (k>1 ? setSetup(n-1, k-1) : 1);
    }

    private static String timeDifference(String cityA, String timestamp, String cityB) {
        String[] dt = timestamp.split("[ ,:]");
        int[] date = {Integer.parseInt(dt[3]), MONTHS.get(dt[0]), Integer.parseInt(dt[1]), Integer.parseInt(dt[4])*60+Integer.parseInt(dt[5])};
        int time = CITIES.get(cityB)-CITIES.get(cityA);
        boolean isLeap = date[0]%400 == 0 || (date[0]%4 == 0 && date[0]%100 != 0);
        date[3] += time;
        if (date[3] < 0) {
            date[3] += 1440;
            date[2]--;
        } else if (date[3] >= 1440) {
            date[3] -= 1440;
            date[2]++;
        }
        if (date[1] == 1 || date[1] == 3 || date[1] == 5 || date[1] == 7 || date[1] == 8 || date[1] == 10 || date[1] == 12) {
            if (date[2] < 1) {
                date[1]--;
                if (date[1] == 2) {
                    if (isLeap) {
                        date[2] = 29;
                    } else {
                        date[2] = 28;
                    }
                } else if (date[1] == 7 || date[1] == 0) {
                    date[2] = 31;
                } else {
                    date[2] = 30;
                }
            } else if (date[2] > 31) {
                date[1]++;
                date[2] = 1;
            }
        } else if (date[1] == 2) {
            if (date[2] < 1) {
                date[2] = 31;
                date[1] = 1;
            } else if ((date[2] > 28 && !isLeap) || date[2] > 29) {
                date[2] = 1;
                date[1] = 3;
            }
        } else {
            if (date[2] < 1) {
                date[1]--;
                date[2] = 31;
            } else if (date[2] > 30) {
                date[1]++;
                date[2] = 1;
            }
        }
        if (date[1] > 12) {
            date[0]++;
            date[1] = 1;
        } else if (date[1] < 1) {
            date[0]--;
            date[1] = 12;
        }
        return date[0] + "-" + date[1] + "-" + date[2] + " " + (date[3]/60 < 10 ? "0" : "") + date[3]/60 + ":" + (date[3]%60 < 10 ? "0" : "") + date[3]%60;
    }

    private static boolean isNew(int n) {
        String num = String.valueOf(n);
        int first = (int)num.charAt(0);
        boolean min = false;
        if (num.length() < 2) {
            return true; // Число однозначное => новое
        }
        if ((int)num.charAt(1) == 48) {
            min = true; // 0 на второй позиции
        } else {
            if ((int)num.charAt(1) < (int)num.charAt(0)) {
                return false; // Первая позиция больше второй => не новое
            }
        }
        for (int i = 2; i < num.length(); i++) {
            if ((int)num.charAt(i-1) > (int)num.charAt(i)) {
                return false; // Предыдущая позиция больше предыдущей => не новое
            }
            if (min && (int)num.charAt(i) < first) {
                return false; // 0 но второй позиции => проверяем и первую. Первая больше текущей => не новое
            }
        }
        return true;
    }
}
