import java.util.LinkedList;
import java.util.Queue;

public class Offer9_2QueueToStack {

    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public void push(int pushInt) {
        queue.add(pushInt);
    }

    public int peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (queue.size() != 1) {
            help.add(queue.poll());
        }

        int res = queue.poll();
        help.add(res);
        swap();
        return res;
    }

    public int pop() {
        if(queue.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        while(queue.size() > 1){
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> temp = help;
        help = queue;
        queue = temp;
    }
}
