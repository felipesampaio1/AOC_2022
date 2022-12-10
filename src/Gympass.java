import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gympass {

    public static void main(String[] args) {
        List<Integer> example = List.of(4, 2, 5, 9);
        List<Integer> test = new ArrayList<>(example);


        System.out.println(findElement(example, 2));
        System.out.println(findElement(example, 7));

        findSmallestElementOutOfList(test);
    }

    private static boolean findElement(List<Integer> list, int element){
        /*
            Algoritmo com tempo de execução de O(n).
         */
        return list.stream()
                .anyMatch(x -> x == element);

    }

    private static void findSmallestElementOutOfList(List<Integer> list){
        list.sort(Comparator.naturalOrder());

        int menorInt = list.get(list.size() - 1) + 1;

        /*
            Algoritmo com tempo de execução de O(n).
         */
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > (i + 1)){
                menorInt = i + 1;
                break;
            }
        }

        System.out.println("Menor int: " + menorInt);
    }
}
