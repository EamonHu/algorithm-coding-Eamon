import java.util.Stack;

public class Offer30_MinStack {

    Stack<Integer> stackData;
    Stack<Integer> stackMin;
    /** initialize your data structure here. */
    public Offer30_MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        if(stackMin.isEmpty()){
            stackMin.push(x);
        }else if(stackMin.peek() >= x){
            stackMin.push(x);
        }
        stackData.push(x);
    }

    public void pop() {
        int val = 0;
        if(!stackData.isEmpty()){
            val = stackData.pop();
        }
        if(val == stackMin.peek()){
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
