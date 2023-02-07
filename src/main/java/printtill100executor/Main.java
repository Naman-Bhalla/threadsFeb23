package printtill100executor;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10000; ++i) {
            if (i == 5000) {
                System.out.println("BLA BLA BLA");
            }
            executorService.execute(
                    new NumberPrinter(i)
            );

        }
    }
}
