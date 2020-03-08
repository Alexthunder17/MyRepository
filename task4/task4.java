package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class task4 {
    static List<LocalTime> enterTimes = new ArrayList<>();
    static List<LocalTime> exitTimes = new ArrayList<>();
    static List<Integer> visitorsCountArray = new ArrayList<>();
    static int maxVisitorsCounter = 0;
    static int visitors = 0;

    public static void main(String[] args) throws Exception {
        readFile(args[0]);
        enterTimes.sort(Comparator.naturalOrder());
        exitTimes.sort(Comparator.naturalOrder());
        int i = 0;
        for (LocalTime enterTime : enterTimes) {
            int j = 0;
            for (LocalTime exitTime : exitTimes) {
                if (exitTime.compareTo(enterTime) > 0)
                    break;
                j++;
            }
            int valueToAdd = i - j + 1;
            if (valueToAdd > maxVisitorsCounter)
                maxVisitorsCounter = valueToAdd;
            visitorsCountArray.add(i - j + 1);
            i++;
        }

        for (i = 0; i < visitors; i++) {
            Integer currentVisitorsCount = visitorsCountArray.get(i);
            if (currentVisitorsCount == maxVisitorsCounter) {
                System.out.print(enterTimes.get(i) + " ");
                while (i < visitors && visitorsCountArray.get(i) == maxVisitorsCounter) {
                    i++;
                }
                for (LocalTime exitTime : exitTimes) {
                    if (exitTime.compareTo(enterTimes.get(i - 1)) <= 0) {
                        continue;
                    }
                    System.out.println(exitTime);
                    break;
                }
            }
        }
    }

    static void readFile(String filename) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String data;
        while ((data = in.readLine()) != null) {
            String[] sp = data.split(" ");
            parseLocalDate(sp[0], enterTimes);
            parseLocalDate(sp[1], exitTimes);
            visitors++;
        }
    }

    private static void parseLocalDate(String valueToParse, List<LocalTime> exitTimes) {
        if (valueToParse.length() == 5)
            exitTimes.add(LocalTime.parse(valueToParse, DateTimeFormatter.ofPattern("HH:mm")));
        else if (valueToParse.length() == 4)
            exitTimes.add(LocalTime.parse(valueToParse, DateTimeFormatter.ofPattern("H:mm")));
    }
}