public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + " entered Increment Method");
        c++;
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exited Increment Method");
    }

    public synchronized void decrement() {
        System.out.println(Thread.currentThread().getName() + " entered Decrement Method");
        c--;
        try{
            Thread.sleep(1000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exited Decrement Method");
    }

    public synchronized int value() {
        return c;
    }
}