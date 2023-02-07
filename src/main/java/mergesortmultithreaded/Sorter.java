package mergesortmultithreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    private ExecutorService executor;

    public Sorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executor = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (arrayToSort.size() <= 1) {
            return arrayToSort;
        }

        int mid = arrayToSort.size() / 2;

        List<Integer> leftArrayToSort = new ArrayList<>();
        for (int i = 0; i < mid; ++i) {
            leftArrayToSort.add(arrayToSort.get(i));
        }

        List<Integer> rightArrayToSort = new ArrayList<>();
        for (int i = mid; i < arrayToSort.size(); ++i) {
            rightArrayToSort.add(arrayToSort.get(i));
        }

        Future<List<Integer>> sortedLeftArrayFuture = executor.submit(new Sorter(leftArrayToSort, executor)); // non blocking // merge(leftArray)
        Future<List<Integer>> sortedRightArrayFuture = executor.submit(new Sorter(rightArrayToSort, executor));
        List<Integer> sortedArray = new ArrayList<>();


        List<Integer> sortedLeftArray = sortedLeftArrayFuture.get(); // blocking
        List<Integer> sortedRightArray = sortedRightArrayFuture.get();

        /// merge 2 sorted arrays
        int i = 0;
        int j = 0;

        while (i < sortedLeftArray.size() && j < sortedRightArray.size()) {
            if (sortedLeftArray.get(i) < sortedRightArray.get(j)) {
                sortedArray.add(sortedLeftArray.get(i));
                i++;
            } else {
                sortedArray.add(sortedRightArray.get(j));
                j++;
            }
        }

        while (i < sortedLeftArray.size()) {
            sortedArray.add(sortedLeftArray.get(i));
            i++;
        }

        while (j < sortedRightArray.size()) {
            sortedArray.add(sortedRightArray.get(j));
            j++;
        }
        /// merge 2 sorted arrays
        return sortedArray;
    }
}
