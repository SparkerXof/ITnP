public class Task1 {
    public static void run() {
        System.out.println("convert(5) -> " + convert(5));
        System.out.println("convert(3) -> " + convert(3));
        System.out.println("convert(8) -> " + convert(8));

        System.out.println("fitCalc(15, 1) -> " + fitCalc(15, 1));
        System.out.println("fitCalc(24, 2) -> " + fitCalc(24, 2));
        System.out.println("fitCalc(41, 3) -> " + fitCalc(41, 3));

        System.out.println("containers(3, 4, 2) -> " + containers(3, 4, 2));
        System.out.println("containers(5, 0, 2) -> " + containers(5, 0, 2));
        System.out.println("containers(4, 1, 4) -> " + containers(4, 1, 4));

        System.out.println("triangleType(5, 5, 5) -> " + triangleType(5, 5, 5));
        System.out.println("triangleType(5, 4, 5) -> " + triangleType(5, 4, 5));
        System.out.println("triangleType(3, 4, 5) -> " + triangleType(3, 4, 5));
        System.out.println("triangleType(5, 1, 1) -> " + triangleType(5, 1, 1));

        System.out.println("ternaryEvaluation(8, 4) -> " + ternaryEvaluation(8, 4));
        System.out.println("ternaryEvaluation(1, 11) -> " + ternaryEvaluation(1, 11));
        System.out.println("ternaryEvaluation(5, 9) -> " + ternaryEvaluation(5, 9));

        System.out.println("howManyItems(22, 1.4, 2) -> " + howManyItems(22, 1.4f, 2));
        System.out.println("howManyItems(45, 1.8, 1.9) -> " + howManyItems(45, 1.8f, 1.9f));
        System.out.println("howManyItems(100, 2, 2) -> " + howManyItems(100, 2, 2));

        System.out.println("factorial(3) -> " + factorial(3));
        System.out.println("factorial(5) -> " + factorial(5));
        System.out.println("factorial(7) -> " + factorial(7));

        System.out.println("gcd(48, 18) -> " + gcd(48, 18));
        System.out.println("gcd(52, 8) -> " + gcd(52, 8));
        System.out.println("gcd(259, 28) -> " + gcd(259, 28));

        System.out.println("ticketSaler(70, 1500) -> " + ticketSaler(70, 1500));
        System.out.println("ticketSaler(24, 950) -> " + ticketSaler(24, 950));
        System.out.println("ticketSaler(53, 1250) -> " + ticketSaler(53, 1250));

        System.out.println("tables(5, 2) -> " + tables(5, 2));
        System.out.println("tables(31, 20) -> " + tables(31, 20));
        System.out.println("tables(123, 58) -> " + tables(123, 58));
    }
    public static float convert(int gal) { return gal * 3.785f; }

    public static int fitCalc(int kal, int activity) {
        if (activity > 0 && activity < 4) {
            return kal * activity;
        } else {
            return -1;
        }
    }

    public static int containers(int boxes, int bags, int barrels) { return (boxes * 20) + (bags * 50) + (barrels * 100); }

    public static String triangleType(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) { return "not a triangle"; }
        else if (a == b && b == c) { return "equilateral"; }
        else if (a == b || a == c || b == c) { return "isosceles"; }
        else { return "different-sided"; }
    }

    public static int ternaryEvaluation(int a, int b) { return (a > b) ? a : b; }

    public static float howManyItems(float n, float w, float h) { return n / (w * h * 2); }

    public static int factorial(int base) {
        int result = 2;
        for (int i = 3; i <= base; i++) { result *= i; }
        return result;
    }

    public static int gcd(int a, int b) {
        while ((a != 0) && (b != 0)) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }

    public static int ticketSaler(int tickets, int price) { return (int)(tickets * price * 0.72f); }

    public static int tables(int students, int table_count) {
        if (students % 2 == 1) { students += 1; }
        if (students/2 > table_count) {
            return students/2 - table_count;
        } else {
            return 0;
        }
    }
}
