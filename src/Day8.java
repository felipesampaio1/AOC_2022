import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day8 {

    private static List<Integer> values = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("day8.txt"));


        String line = br.readLine();
        int[][] matriz = new int[line.length()][line.length()];
        int j = 0;
        while (line != null) {
            String[] x = line.split("");

            for (int i = 0; i < x.length; i++) {
                matriz[j][i] = Integer.parseInt(x[i]);
            }
            j++;
            line = br.readLine();
        }

        int trees = matriz.length * 4 - 4;

        for (int i = 1; i < matriz.length - 1; i++) {
            for (int x = 1; x < matriz.length - 1; x++) {
                calculateScenic(matriz, matriz[i][x], i, x);
                if (check(matriz, matriz[i][x], i, x))
                    trees++;
            }
        }

        System.out.println(trees);

        values.sort(Comparator.naturalOrder());

        System.out.println("Scenic: " + values.get(values.size() - 1));
    }

    private static boolean check(int[][] matriz, int tree, int line, int column) {
        boolean a = true, b = true, c = true, d = true;

        for (int i = line + 1; i < matriz.length; i++) {
            if (tree <= matriz[i][column])
                a = false;

        }

        for (int i = column + 1; i < matriz.length; i++) {
            if (tree <= matriz[line][i])
                b = false;

        }

        for (int i = column - 1; i >= 0; i--) {
            if (tree <= matriz[line][i])
                c = false;

        }

        for (int i = line - 1; i >= 0; i--) {
            if (tree <= matriz[i][column])
                d = false;

        }

        boolean result = a || b || c || d;

        return result;

    }

    private static void calculateScenic(int[][] matriz, int tree, int line, int column) {

        int a = 0;
        for (int i = line + 1; i < matriz.length; i++) {
            if (tree > matriz[i][column])
                a++;
            else if (tree == matriz[i][column]){
                a++;
                break;
            } else break;
        }

        int b = 0;
        for (int i = column + 1; i < matriz.length; i++) {
            if (tree > matriz[line][i])
                b++;
            else if (tree == matriz[line][i]){
                b++;
                break;
            }else break;

        }

        int c = 0;
        for (int i = column - 1; i >= 0; i--) {
            if (tree > matriz[line][i])
                c++;
            else if (tree == matriz[line][i]){
                c++;
                break;
            }else break;

        }

        int d = 0;
        for (int i = line - 1; i >= 0; i--) {
            if (tree > matriz[i][column])
                d++;
            else if (tree == matriz[i][column]){
                d++;
                break;
            }else break;
        }

        values.add(a * b * c * d);

    }

}
