import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer40_MinK {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int length = input.length;
        if (length < k || k <= 0) return res;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.add(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }

        }

        res.addAll(maxHeap);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> integers = GetLeastNumbers_Solution(arr, 4);
        for (int num : integers) {
            System.out.print(num + " ");
        }
    }
}