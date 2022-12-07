import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("day4.txt"));

        String read;
        int count = 0;
        while ((read = bufferedReader.readLine()) != null) {
            String[] elfs = read.split(",");
            String[] first = elfs[0].split("-");
            String[] second = elfs[1].split("-");

            if (Integer.parseInt(second[0]) >= Integer.parseInt(first[0]) && Integer.parseInt(second[1]) <= Integer.parseInt(first[1]))
                count++;
            else if (Integer.parseInt(second[0]) <= Integer.parseInt(first[0]) && Integer.parseInt(second[1]) >= Integer.parseInt(first[1]))
                count++;
            else if (Integer.parseInt(second[0]) <= Integer.parseInt(first[1]) && Integer.parseInt(second[0]) >= Integer.parseInt(first[0]))
                count++;
            else if (Integer.parseInt(second[1]) >= Integer.parseInt(first[0]) && Integer.parseInt(second[1]) <= Integer.parseInt(first[1]))
                count++;

        }
        System.out.println("Count: " + count);
    }
}
