import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner type = new Scanner(System.in);

        System.out.print("Enter task number: ");
        int taskNum = type.nextInt();

        switch (taskNum) {
            case 1 -> Task1.run();
            case 2 -> Task2.run();
            case 3 -> Task3.run();
            case 4 -> Task4.run();
            case 5 -> Task5.run();
            case 6 -> Task6.run();
            default -> System.out.println("Wrong task number!");
        }
    }
}