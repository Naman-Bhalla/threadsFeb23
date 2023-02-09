package addersubtractorlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Count c = new Count();
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(new Adder(c, lock));
        Thread t2 = new Thread(new Subtractor(c, lock));

        t1.start();
        t2.start();

        t1.join(); // waits for the thread to complete - code will not go to next line till t1 completes
        t2.join();

        System.out.println(c.value);
    }
}
