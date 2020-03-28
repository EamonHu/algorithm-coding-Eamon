package deadlock;

public class DeadLockDemo {

    public static void main(String[] args) {
        DeadLock d1 = new DeadLock();
        DeadLock d2 = new DeadLock();
        d2.flag = 1;

        Thread thread1  = new Thread(d1);
        Thread thread2 = new Thread(d2);

        thread1.start();
        thread2.start();
    }
}
