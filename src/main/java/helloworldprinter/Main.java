package helloworldprinter;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World " + Thread.currentThread().getName());

        HelloWorldPrinter hwp = new HelloWorldPrinter();
        Thread t = new Thread(hwp);
        t.start();

        System.out.println("Hello World " + Thread.currentThread().getName());
    }
}
