package addersubtractorsyncmethod;

public class Subtractor implements Runnable {
    private Count count;
    //      int   i

    public Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; ++i) {
            count.addValue(-i);
        }
    }
}
