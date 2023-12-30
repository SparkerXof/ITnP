import java.util.Scanner;
import java.util.regex.*;

public class WordsByLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write a text: ");
        String text = scanner.nextLine().toLowerCase();

        System.out.print("Write a letter for search: ");
        char letter = scanner.nextLine().charAt(0);
        scanner.close();
        Pattern pattern;
        try {
            pattern = Pattern.compile(Character.toString(letter) + "[a-z]*[\\s#]");
        } catch (PatternSyntaxException e) {
            System.out.println("Error on RegEx compilation!\n" + e.getMessage());
            return;
        }
        Matcher matcher = pattern.matcher(text.toLowerCase());

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
