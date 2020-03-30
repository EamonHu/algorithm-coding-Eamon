import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SpecialStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public SpecialStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int val) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(val);
        } else if (val <= this.stackMin.peek()) {
            this.stackMin.push(val);
        }
        this.stackData.push(val);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        int val = this.stackData.pop();
        if (val == this.stackMin.peek()) {
            this.stackMin.pop();
        }
        return val;
    }

    public void getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        System.out.println(this.stackMin.peek());
    }

    public static void main(String[] args) throws IOException {
        // 记得new这个类
        SpecialStack m = new SpecialStack();

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        // 读进来的String要转成Integer
        int rows = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < rows; i++) {
            // 字符串空格隔开后放进数组！一个数组存放一组操作
            String[] inputData = scanner.readLine().split(" ");
            if (inputData[0].equals("push")) {
                m.push(Integer.parseInt(inputData[1]));
            }
            if (inputData[0].equals("pop")) {
                m.pop();
            }
            if (inputData[0].equals("getMin")) {
                m.getMin();
            }
        }
        // 关！
        scanner.close();
    }
}
