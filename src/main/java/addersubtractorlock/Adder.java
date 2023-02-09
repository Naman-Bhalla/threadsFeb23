package addersubtractorlock;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count count;
    private Lock lock;

    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
//        lock.lock();
        for (int i = 1; i <= 1000; ++i) {
            lock.lock();
            System.out.println("Adding " + i);
            count.addValue(i);
            lock.unlock();
        }
//        lock.unlock();
    }
}
