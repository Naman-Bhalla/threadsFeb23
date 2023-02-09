package addersubtractorlock;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {
    private Count count;
    private Lock lock;
    //      int   i

    public Subtractor(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
//        lock.lock();
        for (int i = 1; i <= 1000; ++i) {
            lock.lock();
            System.out.println("Subtracting " + i);
            count.addValue(-i);
            lock.unlock();
        }
//        lock.unlock();
    }
}
