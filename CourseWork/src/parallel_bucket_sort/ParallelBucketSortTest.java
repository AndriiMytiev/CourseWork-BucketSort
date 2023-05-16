package parallel_bucket_sort;

import java.util.ArrayList;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static utils.SortTestHelper.*;

public class ParallelBucketSortTest {
    public static void testBucketSort() {
        int counter = 1;

        System.out.println("########## Parallel bucket sort test ##########\n");
        for (int i = 10000; i <= 200000; i += 10000) {
            System.out.println("Test " + counter + ": ");
            for (int j = 4; j <= 64; j *= 2) {
                sortParallelTest(i, j);
            }
            sortParallelTest(i, (int) ceil(sqrt(i)));
            counter++;
            System.out.println("\n----------------------------------------\n");
        }
    }

    public static void testBucketSort(ArrayList<double[]> arrayList, int numOfBuckets) {
        int counter = 1;

        System.out.println("########## Parallel bucket sort test ##########");
        for (int i = 10000; i <= arrayList.size()*10000; i += 10000) {
            sortParallelTestDemo(arrayList.get(counter-1), numOfBuckets, false);
            counter++;
        }
        System.out.println();
    }

    public static void testBucketSort(ArrayList<double[]> arrayList) {
        int counter = 1;

        System.out.println("########## Parallel bucket sort test ##########");
        for (int i = 10000; i <= arrayList.size()*10000; i += 10000) {
            sortParallelTestDemo(arrayList.get(counter-1), (int) ceil(sqrt(i)), false);
            counter++;
        }
        System.out.println();
    }
}
