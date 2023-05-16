import general_bucket_sort.GeneralBucketSortTest;
import parallel_bucket_sort.ParallelBucketSort;
import parallel_bucket_sort.ParallelBucketSortTest;
import utils.ArrayFileIO;
import utils.GenerateArray;

import java.util.ArrayList;

import static java.lang.Math.*;
import static utils.GenerateArray.generateRandomArray;
import static utils.SortTestHelper.*;

public class Main {
    public static void main(String[] args) {
//        Створення рандомно заповнених масивів та запис їх в відповідні файли
//        ArrayList<double[]> arrayList = GenerateArray.generateRandomArrayList(30);
//        ArrayFileIO.writeArrayListToFile(arrayList);

//        Створення масиву масивів із файлів
        ArrayList<double[]> arrayList = ArrayFileIO.readArrayListFromFile(30);
        ParallelBucketSortTest.testBucketSort(arrayList, 64);
//        GeneralBucketSortTest.testBucketSort(arrayList, 64);

//        Створення масиву розміром 10, сортування та вивід в консоль для перевірки правельності
//        double[] testArray = generateRandomArray(10);
//        System.out.println("Parallel algorithm: ");
//        sortParallelTestDemo(testArray, (int) ceil(sqrt(10)), true);

//        double[] testArray = generateRandomArray(10);
//        System.out.println("General algorithm: ");
//        sortGeneralTestDemo(testArray, (int) ceil(sqrt(10)), true);
//        System.out.println("--------------------");
//        System.out.println("\nParallel algorithm: ");
//        sortParallelTestDemo(testArray, (int) ceil(sqrt(10)), true);

//        Сортування мисивів від 10000 до 200000 елементів з виводом часу
//        GeneralBucketSortTest.testBucketSort();
//        ParallelBucketSortTest.testBucketSort();
    }
}
