import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Ali_Code {
    public static void main(String[] args) {
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);


        Thread proThread = new Thread(producer);
        Thread conThread = new Thread(consumer);


        proThread.start();
        conThread.start();
    }

}

class Producer implements Runnable {
    private final BlockingQueue sharedQueue;

    Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Produced:" + i);
            try {
                sharedQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer implements Runnable {
    private final BlockingQueue sharedQueue;


    Consumer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed:" + sharedQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

