import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {

    /**
     * Part 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("day3.txt"));

        String read;
        int sum = 0;

        while ((read = bufferedReader.readLine()) != null) {
            CharSequence pri = read;
            CharSequence sec = bufferedReader.readLine();
            CharSequence ter = bufferedReader.readLine();
            char item = 0;
            boolean finded = false;

            for (int i = 0; i < pri.length(); i++) {
                for (int j = 0; j < sec.length(); j++) {
                    if (pri.charAt(i) == sec.charAt(j)) {
                        item = pri.charAt(i);
                        break;
                    }
                }

                for (int j = 0; j < ter.length(); j++) {
                    if (item == ter.charAt(j)) {
                        finded = true;
                        break;
                    }
                }

                if (finded)
                    break;

            }

            if (item > 96) {
                sum += item - 96;
            } else {
                sum += item - 38;
            }

        }
        System.out.println("Item: " + sum);
    }
}


/**
 * Part 1
 */
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("day3.txt"));
//
//        String read;
//        int sum = 0;
//        while ((read = bufferedReader.readLine()) != null) {
//            CharSequence left = read.substring(0, (read.length() / 2));
//            CharSequence right = read.substring(read.length() / 2);
//            char item = 0;
//
//            for (int i = 0; i < left.length(); i++) {
//                for (int j = 0; j < right.length(); j++) {
//                    if (left.charAt(i) == right.charAt(j)) {
//                        item = left.charAt(i);
//                    }
//                }
//            }
//
//            if (item > 96) {
//                sum += item - 96;
//            }
//            else {
//                sum += item - 38;
//            }
//
//        }
//        System.out.println("Item: " + sum);
//
//    }
