package UE2;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(8);

        System.out.print("Zahl> ");
        long zahl = Integer.parseInt(scanner.nextLine());
        int min = 1;
        int max = 100;
        int ergebnis = 0;
        List<Integer> subList = new ArrayList<>();

        for (int i = 0; i < zahl--; i++) {
            if (max <= zahl - max){
                for (int x = min; x < max; x++) {
                    subList.add(x);
                }
            }else {
                for (int x = min; x < zahl; x++) {
                    subList.add(x);
                }
            }

            executor.execute(() -> {
                addAllElementsInList(subList);
            });

            min += 100;
            max += 100;
            ergebnis += subList.get(i);
        }

        executor.shutdown();

        System.out.println(ergebnis);
    }

    private static void addAllElementsInList(List<Integer> list){
        int addAll = 0;
        for (int i:list) {
            addAll +=i;
            list.remove(i);
        }
        list.add(addAll);
    }
}
