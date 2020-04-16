import java.util.Stack;

public class Offer31_ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>  stack = new Stack<>();
        int index  = 0;

        for (int value : pushed) {
            stack.push(value);
            if (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
