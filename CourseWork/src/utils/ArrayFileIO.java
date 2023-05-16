package utils;

import java.io.*;
import java.util.ArrayList;

public class ArrayFileIO {
    public static void writeArrayToFile(double[] array, String fileName) {
        String directoryPath = "test_data/";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = directoryPath + fileName;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (double number : array) {
                writer.write(String.valueOf(number));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeArrayListToFile(ArrayList<double[]> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayFileIO.writeArrayToFile(arrayList.get(i), "test_" + arrayList.get(i).length);
        };
    }

    public static double[] readArrayFromFile(String fileName) {
        String filePath = "test_data/" + fileName;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            double[] array = new double[countLines(filePath)];
            int index = 0;
            while ((line = reader.readLine()) != null) {
                array[index] = Double.parseDouble(line);
                index++;
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<double[]> readArrayListFromFile(int size) {
        ArrayList<double[]> arrayList = new ArrayList<>(size);

        for (int i = 1; i <= 30; i++) {
            arrayList.add(readArrayFromFile("test_"+i*10000));
        }

        return arrayList;
    }

    private static int countLines(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }
}
