import java.io.*;
import java.util.*;

public class task1 {
    public static void main(String[] args) throws Exception {
        String data = "";
        int counter = 0;
        List<String> timeInput = new ArrayList();
        timeInput = readFile(args[0]);
    }
    static String [][] readFile (String filename) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String data = "";
        int counter = 0;
        List<String> timeInput = new ArrayList();
        while ((data = in.readLine()) != null) {
            String sp[] = data.split(" ");
            counter++;
        }
        return timeInput;
    }
}