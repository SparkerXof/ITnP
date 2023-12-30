import java.util.Scanner;
import java.util.regex.*;

public class PasswordCheck {
    public static void main(String[] args) {
        Pattern sizePattern;
        Pattern bigPattern;
        Pattern numPattern;
        try {
            sizePattern = Pattern.compile("^\\w{8,16}$");
            bigPattern = Pattern.compile("[A-Z]{1,}");
            numPattern = Pattern.compile("[0-9]{1,}");
        } catch (PatternSyntaxException e) {
            System.out.println("Error on RegEx compilation!\n" + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Write a password: ");
        String text = scanner.nextLine();
        scanner.close();
        if (sizePattern.matcher(text).find() && bigPattern.matcher(text).find() && numPattern.matcher(text).find()) {
            System.out.println("Password correct");
        } else {
            System.out.println("Password denied");
        }
    }
}