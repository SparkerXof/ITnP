import java.util.Scanner;
import java.util.regex.*;

public class NumFinder {
    public static void main(String[] args) {
        Pattern pattern;
        try {
            pattern = Pattern.compile("\\d+([\\.,]\\d+)?");
        } catch (PatternSyntaxException e) {
            System.out.println("Error on RegEx compilation!\n" + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Write a text: ");
        String text = scanner.nextLine();
        scanner.close();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}