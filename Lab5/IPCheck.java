import java.util.Scanner;
import java.util.regex.*;

public class IPCheck {
    public static void main(String[] args) {
        Pattern pattern;
        try {
            pattern = Pattern.compile("^(\\d|([1-9]\\d)|1(\\d\\d)|2(([0-4]\\d)|5[0-5]))(\\.(\\d|([1-9]\\d)|1(\\d\\d)|2(([0-4]\\d)|5[0-5]))){3}$");
        } catch (PatternSyntaxException e) {
            System.out.println("Error on RegEx compilation!\n" + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Write an IP: ");
        String text = scanner.nextLine();
        scanner.close();
        if (pattern.matcher(text).find()) {
            System.out.println("IP correct");
        } else {
            System.out.println("IP wrong");
        }
    }
}