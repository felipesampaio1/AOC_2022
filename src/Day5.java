import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Day5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("day5.txt"));
        Deque<String> q1 = new ArrayDeque<>();
        q1.push("H");
        q1.push("R");
        q1.push("B");
        q1.push("D");
        q1.push("Z");
        q1.push("F");
        q1.push("L");
        q1.push("S");
        Deque<String> q2 = new ArrayDeque<>();
        q2.push("T");
        q2.push("B");
        q2.push("M");
        q2.push("Z");
        q2.push("R");
        Deque<String> q3 = new ArrayDeque<>();
        q3.push("Z");
        q3.push("L");
        q3.push("C");
        q3.push("H");
        q3.push("N");
        q3.push("S");
        Deque<String> q4 = new ArrayDeque<>();
        q4.push("S");
        q4.push("C");
        q4.push("F");
        q4.push("J");
        Deque<String> q5 = new ArrayDeque<>();
        q5.push("P");
        q5.push("G");
        q5.push("H");
        q5.push("W");
        q5.push("R");
        q5.push("Z");
        q5.push("B");
        Deque<String> q6 = new ArrayDeque<>();
        q6.push("V");
        q6.push("J");
        q6.push("Z");
        q6.push("G");
        q6.push("D");
        q6.push("N");
        q6.push("M");
        q6.push("T");
        Deque<String> q7 = new ArrayDeque<>();
        q7.push("G");
        q7.push("L");
        q7.push("N");
        q7.push("W");
        q7.push("F");
        q7.push("S");
        q7.push("P");
        q7.push("Q");
        Deque<String> q8 = new ArrayDeque<>();
        q8.push("M");
        q8.push("Z");
        q8.push("R");
        Deque<String> q9 = new ArrayDeque<>();
        q9.push("M");
        q9.push("C");
        q9.push("L");
        q9.push("G");
        q9.push("V");
        q9.push("R");
        q9.push("T");

        Map<Integer, Deque<String>> queues = new HashMap<>();
        queues.put(1, q1);
        queues.put(2, q2);
        queues.put(3, q3);
        queues.put(4, q4);
        queues.put(5, q5);
        queues.put(6, q6);
        queues.put(7, q7);
        queues.put(8, q8);
        queues.put(9, q9);

        String read;
        while ((read = bufferedReader.readLine()) != null) {
            String[] data = read.split(" ");
            int quantity = Integer.parseInt(data[1]);
            Integer from = Integer.parseInt(data[3]);
            Integer to = Integer.parseInt(data[5]);

            Deque<String> aux = new ArrayDeque<>();
            for (int i = 0; i < quantity; i++) {
                aux.push(queues.get(from).pop());
            }

            for (int i = 0; i < quantity; i++) {
                queues.get(to).push(aux.pop());
            }
        }

        StringBuilder result = new StringBuilder();
        for (Deque<String> q : queues.values()) {
            result.append(q.pop());
        }

        System.out.println("Result: " + result);

    }
}
