import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedCounter {
    private int c = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " entered Increment Method");
            c++;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " exited Increment Method");
        }finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " entered Decrement Method");
            c--;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " exited Decrement Method");
        }finally {
            lock.unlock();
        }
    }

    public int value() {
        return c;
    }
}