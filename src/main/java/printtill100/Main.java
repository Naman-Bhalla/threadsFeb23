package printtill100;

public class Main {

    public static void main(String[] args) {
        System.out.println("STARTTINGGGGGGG");
        for (int i = 1; i <= 10000000; ++i) {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread t = new Thread(numberPrinter);
            System.out.println("Starting thread " + i);
            t.start();
        }
    }
}
