public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            System.out.println("Is \"" + s + "\" a palindrome? - " + isPalindrome(s));
        }
    }

    public static String reverseString(String s) {
        String newStr = "";
        for (int i = s.length()-1; i >= 0; i--) {
            newStr = newStr + s.charAt(i);
        }
        return newStr;
    }

    public static boolean isPalindrome(String s) {
        String reversed = reverseString(s);
        if (reversed.equals(s)) {
            return true;
        }
        return false;
    }
}