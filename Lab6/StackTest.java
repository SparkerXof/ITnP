public class StackTest {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>(5);

        stack.push(10);
        stack.push(13);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(21);
        System.out.println(stack.pop());
    }
}
