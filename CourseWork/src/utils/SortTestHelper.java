package utils;

import general_bucket_sort.GeneralBucketSort;
import parallel_bucket_sort.ParallelBucketSort;

public class SortTestHelper {
    public static void sortGeneralTest(int arraySize, int numOfBuckets) {
        double[] array = GenerateArray.generateRandomArray(arraySize);
        double startTime = System.nanoTime();
        GeneralBucketSort.sort(array, numOfBuckets, false);
        double endTime = System.nanoTime();
        System.out.println(arraySize + " elements, " + numOfBuckets +
                " buckets: " + (endTime - startTime)/1000000 + " ms");
    }

    public static void sortGeneralTestDemo(double[] array, int numOfBuckets, boolean print) {
        double startTime = System.nanoTime();
        GeneralBucketSort.sort(array, numOfBuckets, print);
        double endTime = System.nanoTime();
        System.out.println(array.length + " elements, " + numOfBuckets +
                " buckets: " + (endTime - startTime)/1000000 + " ms");
    }

    public static void sortParallelTest(int arraySize, int numOfBuckets) {
        double[] array = GenerateArray.generateRandomArray(arraySize);
        double startTime = System.nanoTime();
        ParallelBucketSort.sort(array, numOfBuckets, false);
        double endTime = System.nanoTime();
        System.out.println(arraySize + " elements, " + numOfBuckets +
                " buckets: " + (endTime - startTime)/1000000 + " ms");
    }

    public static void sortParallelTestDemo(double[] array, int numOfBuckets, boolean print) {
        double startTime = System.nanoTime();
        ParallelBucketSort.sort(array, numOfBuckets, print);
        double endTime = System.nanoTime();
        System.out.println(array.length + " elements, " + numOfBuckets +
                " buckets: " + (endTime - startTime)/1000000 + " ms");
    }
}
