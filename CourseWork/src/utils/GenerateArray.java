package utils;

import java.util.ArrayList;
import java.util.Random;

public class GenerateArray {
    public static double[] generateRandomArray(int size) {
        Random r = new Random();
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextFloat() * 100000;
        }
        return arr;
    }

    public static ArrayList<double[]> generateRandomArrayList(int size) {
        ArrayList<double[]> arrayList = new ArrayList<>(size);

        for (int i = 10000; i <= size * 10000 ; i+=10000) {
            arrayList.add(generateRandomArray(i));
        }

        return arrayList;
    }
}
