package deadlock;

public class DeadLock implements Runnable {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    int flag = 0;
    @Override
    public void run() {
        if(flag == 0){
            synchronized (obj1){
                try {
                    System.out.println(Thread.currentThread().getName()+"获取了obj1锁");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2){
                    System.out.println(Thread.currentThread().getName()+"获取obj2锁");
                }
            }

        }
        if(flag == 1){
            synchronized (obj2) {
                System.out.println(Thread.currentThread().getName() + "获得了obj2锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + "获取obj1锁");
                }
            }
        }
    }
}
