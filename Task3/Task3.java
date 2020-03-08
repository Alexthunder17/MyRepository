import java.io.*;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws Exception {
        final int Size = 16;
        double arr1[] = new double[Size];
        double arr2[] = new double[Size];
        double arr3[] = new double[Size];
        double arr4[] = new double[Size];
        double arr5[] = new double[Size];
        arr1 = readFile("Cash1.txt");
        arr2 = readFile("Cash2.txt");
        arr3 = readFile("Cash3.txt");
        arr4 = readFile("Cash4.txt");
        arr5 = readFile("Cash5.txt");
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