import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day6 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("day6.txt"));
        String read;
        while ((read = bufferedReader.readLine()) != null) {
            CharSequence sec = read;

            for (int i = 0; i < sec.length() - 13; i++) {
                if (check(sec.subSequence(i, i + 14))) {
                    System.out.println("Marker: " + (i + 14));
                    break;
                }
            }
        }
    }

    private static boolean check(CharSequence text) {

        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
