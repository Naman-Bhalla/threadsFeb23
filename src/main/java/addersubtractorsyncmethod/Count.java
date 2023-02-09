package addersubtractorsyncmethod;

public class Count {
    int value = 0;

    public synchronized void addValue(int i) {
        this.value += i;
    }
}
