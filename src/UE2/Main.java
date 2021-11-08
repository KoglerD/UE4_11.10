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
        /*int[] array = new int[(int)zahl];
        Future<int[]> result = new CompletableFuture<>();
        Callable<int[]> c = () -> {
            Arrays.sort(array);
            return array;
        };*/
        Future<Integer> result = new CompletableFuture<>();


            if (zahl % 100 == 0) {
                chunk = zahl / 100;
            } else {
                chunk = zahl / 100 + 1;
            }

            List<Integer> subList = new ArrayList<>();

            if (chunk <= 1){
                        for (int x = min; x <= zahl; x++) {
                            subList.add(x);
                        }


                    result = executor.submit((Callable<Integer>) () -> {
                        int addAll = 0;
                        for (int y : subList) {
                            addAll += y;
                        }
                        subList.clear();
                        return addAll;
                    });
                    try {
                        solution+=result.get().intValue();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

            }else{

        for (int i = 1; i < chunk; i++) {
            if (max <= (zahl - max)) {
                for (int x = min; x <= max; x++) {
                    subList.add(x);
                    //array[min-1] = x;
                }
            } else {
                for (int x = min; x <= zahl; x++) {
                    subList.add(x);
                    //array[min-1] = x;
                }
            }
            /*result = executor.submit(() -> {
                return addAllElementsInList(subList);
            });*/

            /*executor.execute(() -> {
                solution = addAllElementsInList(subList);
            });*/
            //result = executor.submit(c);

            result = executor.submit((Callable<Integer>) () -> {
                int addAll = 0;
                for (int y : subList) {
                    addAll += y;
                }
                subList.clear();
                return addAll;
            });
            min += 100;
            max += 100;

            try {
                solution += result.get().intValue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        }

        executor.shutdown();
        //ergebnis += solution;
        System.out.println(solution);
    }

    /*private static int addAllElementsInList(List<Integer> list) {
        int addAll = 0;
        for (int i : list) {
            addAll += i;
        }
        list.clear();
        //list.add(addAll);
        return addAll;
    }*/
}
