package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class task1 {
    public static void main(String[] args) throws Exception {
        String data;
        int counter = 0;
        double sum = 0;
        double[] numberArray = new double[1000];

        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        while ((data = in.readLine()) != null) {
            numberArray[counter] = Integer.parseInt(data);
            sum += numberArray[counter];
            counter++;
        }
        Arrays.sort(numberArray, 0, counter);
        if (counter >= 10) {
            double percentile = percentileOfArr(numberArray, counter);
            System.out.format("%.2f\n", percentile);
        } else {
            System.out.println("Недостаточно данных для расчетов!");
        }
        double median = medianOfArr(numberArray, counter);
        System.out.format("%.2f\n", median);
        System.out.format("%.2f\n", numberArray[counter - 1]);
        System.out.format("%.2f\n", numberArray[0]);
        System.out.format("%.2f\n", roundToHundredth(sum / counter));
    }

    static double roundToHundredth(double number) {
        return (Math.round(100 * number)) / 100.0;
    }

    static double percentileOfArr(double[] arr, int counter) {
        double perL90 = (counter + 1) * 0.9;
        double per90;
        if (perL90 % 1 == 0) {
            per90 = arr[(int) perL90 - 1];
        } else {
            per90 = arr[(int) perL90 - 1] + 0.9 * (arr[(int) perL90] - arr[(int) perL90 - 1]);
        }
        return roundToHundredth(per90);
    }

    static double medianOfArr(double[] arr, int counter) {
        double median;
        if (counter % 2 == 0) {
            median = (arr[(counter / 2)] + arr[(counter / 2) + 1]) / 2;
        } else {
            median = arr[(counter / 2) + 1];
        }
        return roundToHundredth(median);
    }
}