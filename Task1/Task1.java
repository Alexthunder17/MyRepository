import java.io.*;
import java.util.*;

public class Task1 {
    public static void main (String[] args) throws Exception {
        String data = "";
        int counter = 0;
        double sum = 0;
        double input[] = new double[1000];
        for (String s: args) {
            BufferedReader in = new BufferedReader(new FileReader(s));
            while ((data = in.readLine()) != null) {
                input[counter] = Integer.parseInt(data);
                sum += input[counter];
                counter++;
            }
            Arrays.sort(input, 0, counter);
            if (counter >= 10) {
                double percentile = percentileOfArr(input, counter);
                System.out.format("%.2f\n", percentile);
            } else {
                System.out.println("Недостаточно данных для расчетов!");
            }
            double median = medianOfArr(input, counter);
            System.out.format("%.2f\n", median);
            System.out.format("%.2f\n", input[counter - 1]);
            System.out.format("%.2f\n", input[0]);
            System.out.format("%.2f\n", roundToHundredth(sum / counter));
        }
    }
    static double roundToHundredth (double number) {
        double rounded = (Math.round(100 * number)) / 100.0;
        return rounded;
    }
    static double percentileOfArr (double arr[], int counter) {
        double perL90 = (counter + 1) * 0.9;
        double per90;
        if (perL90 % 1 == 0) {
            per90 = arr[(int) perL90 - 1];
        } else {
            per90 = arr[(int)perL90 - 1] + 0.9 * (arr[(int)perL90] - arr[(int)perL90 - 1]);
        }
        return roundToHundredth(per90);
    }
    static double medianOfArr (double arr[], int counter) {
        double median;
        if (counter % 2 == 0) {
            median = (arr[(counter / 2)] + arr[(counter / 2) + 1]) / 2;
        } else {
            median = arr[(counter / 2) + 1];
        }
        return roundToHundredth(median);
    }
}
