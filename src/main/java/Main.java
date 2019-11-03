public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 15000L;

        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronizedCounter.increment();
                synchronizedCounter.decrement();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronizedCounter.increment();
                synchronizedCounter.decrement();
            }
        };

        t1.start();
        t2.start();

        while (System.currentTimeMillis() < endTime) {
            t1.run();
            t2.run();
        }

        t1.interrupt();
        t2.interrupt();

    }
}
