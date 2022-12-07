import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {

    public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("day1.txt"));

            String read;
            long max = 0L, sec = 0L, ter = 0L;
            long aux = 0L;

            while ((read = bufferedReader.readLine()) != null) {
                if (read.isBlank()){
                    if (aux >= max)
                        max = aux;
                    else if (aux >= sec)
                        sec = aux;
                    else if (aux >= ter)
                        ter = aux;

                    aux = 0L;
                }else
                    aux += Long.parseLong(read);
            }

            System.out.println("Max: " + max);
            System.out.println("Sec: " + sec);
            System.out.println("Ter: " + ter);
            System.out.println("Sum: " + (max + sec + ter));

        }
}
