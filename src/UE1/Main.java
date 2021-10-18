package UE1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);

        System.out.print("chunks> ");
        int chunk = Integer.parseInt(scanner.nextLine());
        System.out.print("divider> ");
        int teiler = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < chunk; i++) {
            Task task = new Task(1, teiler, chunk);
            executor.execute(task);
        }
        executor.shutdown();

        /*List<Integer> list = einlesen(new File("C:\\Schule\\2021-22 KoglerD190073\\POS\\Uebungen\\KoglerD_UE4_11.10.21\\UE4_KoglerD\\numbers.csv"));

        System.out.print("chunks> ");
        int chunk = Integer.parseInt(scanner.nextLine());
        System.out.print("divider> ");
        int teiler = Integer.parseInt(scanner.nextLine());
        int zahlInsgesamt = 0;
        for (int i : list) {
            //zahlInsgesamt++;
            if (i % teiler == 0) {
                System.out.println(i);
                zahlInsgesamt++;
            }
        }
        System.out.println("Anzahl Zahlen: "+zahlInsgesamt);*/
    }



    public static List<int[]> getielteListe(int anzahlZahlen, int chunks, int[] alleZahlen) {
        List<int[]> numbersList = new ArrayList<>();
        int zDC = anzahlZahlen / chunks;
        int anzZahlenNotGood = anzahlZahlen;
        while (zDC % 1 != 0) {
            anzZahlenNotGood++;
            zDC = anzZahlenNotGood / chunks;
        }
        List<int[]> subList = new ArrayList<>();
        int[] subArray = new int[zDC];
        for (int i = 1; i < chunks; i++) {
            for (int j = 1; j < zDC; j++) {
                subList = numbersList.subList(i, zDC*j);
                //subArray = subList;
            }
        }

        return subList;
    }

}
