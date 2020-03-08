package task3;

import java.io.*;
import java.util.*;

public class task3 {
    public static void main(String[] args) throws Exception {
        final int Size = 16;
        double arr1[] = readFile("Cash1.txt");
        double arr2[] = readFile("Cash2.txt");
        double arr3[] = readFile("Cash3.txt");
        double arr4[] = readFile("Cash4.txt");
        double arr5[] = readFile("Cash5.txt");
        double arr[] = new double[Size];
        for (int i = 0; i < Size; i++) {
            arr[i] = arr1[i] + arr2[i] + arr3[i] + arr4[i] + arr5[i];
        }
        int indexOfHigh = 0;
        for (int i = 0; i < Size; i++) {
            if (arr[indexOfHigh] < arr[i]) {
                indexOfHigh = i;
            }
        }
        System.out.println(indexOfHigh);
    }

    static double[] readFile(String filename) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String data = "";
        int counter = 0;
        double input[] = new double[16];
        while ((data = in.readLine()) != null) {
            input[counter] = Double.parseDouble(data);
            counter++;
        }
        return input;
    }
}