package general_bucket_sort;

import java.util.ArrayList;

public class GeneralBucketSort {

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

        // Розмір кожного бакету
        double bucketSize = (maxVal - minVal + 1) / numOfBuckets;

        // Створюємо пусті бакети
        ArrayList<Double>[] buckets = new ArrayList[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Розподіляємо елементи відповідно до їх значень в масиві
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (int)((arr[i] - minVal) / bucketSize);
            buckets[bucketIndex].add(arr[i]);
        }

        // Сортуємо кожен бакет вставкою
        for (int i = 0; i < numOfBuckets; i++) {
            insertionSort(buckets[i]);
        }

        // Об'єднуємо бакети у відсортований масив
        int currentIndex = 0;
        for (int i = 0; i < numOfBuckets; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[currentIndex] = buckets[i].get(j);
                currentIndex++;
            }
        }

        if(print){
            printArray(arr);
        }
    }

    // Сортування вставкою
    public static void insertionSort(ArrayList<Double> arr) {
        for (int i = 1; i < arr.size(); i++) {
            double key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
        }
    }

    public static void printArray(double[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}
