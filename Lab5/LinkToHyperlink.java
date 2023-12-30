import java.util.Scanner;
import java.util.regex.*;

public class LinkToHyperlink {
    public static void main(String[] args) {
        StringBuffer result = new StringBuffer();
        Pattern pattern;
        try {
            pattern = Pattern.compile("[A-Za-z_]+(\\.[A-Za-z_]+)*\\.[A-Za-z_]{2,}");
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
            matcher.appendReplacement(result, "http://" + matcher.group() + "/");
        }
        matcher.appendTail(result);
        System.out.println(result.toString());
    }
}
