package parallel_bucket_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelBucketSort {

    public static void sort(double[] arr, int numOfBuckets, boolean print) {
        if (numOfBuckets <= 0) {
            throw new IllegalArgumentException("Invalid number of buckets");
        }

        // Знаходимо мінімальне та максимальне значення в масиві
        double minVal = arr[0];
        double maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            } else if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        // розділити масив на numOfBuckets бакетів
        double bucketSize = (maxVal - minVal) / numOfBuckets;

        List<List<Double>> buckets = new ArrayList<>(numOfBuckets);
        for (int i = 0; i < numOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for (double val : arr) {
            int bucketIndex = (int) ((val - minVal) / bucketSize);
            if (bucketIndex == numOfBuckets) {
                bucketIndex--;
            }
            buckets.get(bucketIndex).add(val);
        }

        // створити ForkJoinPool та виконати сортування в бакетах паралельно
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new SortTask(buckets, 0, numOfBuckets - 1));

        // зібрати відсортовані бакети в один масив
        int index = 0;
        for (List<Double> bucket : buckets) {
            for (double val : bucket) {
                arr[index++] = val;
            }
        }

        if(print){
            printArray(arr);
        }
    }

    public static void printArray(double[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    private static class SortTask extends RecursiveAction {
        private final List<List<Double>> buckets;
        private final int left;
        private final int right;

        public SortTask(List<List<Double>> buckets, int left, int right) {
            this.buckets = buckets;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
            if (left == right) {
                // сортувати бак в поточному потоці
                List<Double> bucket = buckets.get(left);
                Double[] bucketArray = bucket.toArray(new Double[bucket.size()]);
                Arrays.sort(bucketArray);
                buckets.set(left, Arrays.asList(bucketArray));
            } else {
                // розділити діапазон баків на дві половини та запустити сортування в нових задачах
                int mid = (left + right) / 2;
                invokeAll(new SortTask(buckets, left, mid), new SortTask(buckets, mid + 1, right));
            }
        }
    }
}
