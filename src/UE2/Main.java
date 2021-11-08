package UE2;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    private static int solution;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);

        System.out.print("Zahl> ");
        long zahl = Integer.parseInt(scanner.nextLine());
        int min = 1;
        int max = 100;
        long chunk = 0;
        int[] array = new int[(int)zahl];
        Future<Integer> result = new CompletableFuture<>();
        /*Callable<int[]> c = () -> {
            Arrays.sort(array);
            return array;
        };*/


            if (zahl % 100 == 0) {
                chunk = zahl / 100;
            } else {
                chunk = zahl / 100 + 1;
            }

            List<Integer> subList = new ArrayList<>();

        for (int i = 1; i < chunk; i++) {
            if (max <= (zahl - max)) {
                for (int x = min; x <= max; x++) {
                    subList.add(x);
                }
            } else {
                for (int x = min; x <= zahl; x++) {
                    subList.add(x);
                }
            }
            /*result = executor.submit(() -> {
                return addAllElementsInList(subList);
            });*/

            executor.execute(() -> {
                solution = addAllElementsInList(subList);
            });

            min += 100;
            max += 100;
        }

        executor.shutdown();
        //ergebnis += solution;
        System.out.println(solution);
    }

    private static int addAllElementsInList(List<Integer> list) {
        int addAll = 0;
        for (int i : list) {
            addAll += i;
        }
        list.clear();
        //list.add(addAll);
        return addAll;
    }
}
