import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("day2.txt"));

        String read;
        long points1 = 0L;
        long points2 = 0L;
        while ((read = bufferedReader.readLine()) != null) {
            String[] options = read.split(" ");
            String p1 = options[0];
            String p2 = options[1];

            if (p1.equals("A")){
//                points2 += 1;
                if (p2.equals("Y"))
                    points2 += 4;
                else if (p2.equals("X"))
                    points2 += 3;
                else if (p2.equals("Z"))
                    points2 += 8;
            }
            else if (p1.equals("B")){
//                points2 += 2;
                if (p2.equals("Y"))
                    points2 += 5;
                else if (p2.equals("X"))
                    points2 += 1;
                else if (p2.equals("Z"))
                    points2 += 9;
            }
            else if (p1.equals("C")){
//                points2 += 3;
                if (p2.equals("Y"))
                    points2 += 6;
                else if (p2.equals("X"))
                    points2 += 2;
                else if (p2.equals("Z"))
                    points2 += 7;
            }

        }

        System.out.println("P2: " + points2);
    }
}



/*
            if (p2.equals("X")){
                    points2 += 1;
                if (p1.equals("A"))
                    points2 += 3;
                else if (p1.equals("B"))
                    points2 += 0;
                else if (p1.equals("C"))
                    points2 += 6;
                    }
                    else if (p2.equals("Y")){
                    points2 += 3;
                    if (p1.equals("A"))
                    points2 += 3;
                    else if (p1.equals("B"))
                    points2 += 2;
                    else if (p1.equals("C"))
                    points2 += 1;
                    }
                    else if (p2.equals("Z")){
                    points2 += 6;
                    if (p1.equals("A"))
                    points2 += 3;
                    else if (p1.equals("B"))
                    points2 += 2;
                    else if (p1.equals("C"))
                    points2 += 1;
                    }
*/
