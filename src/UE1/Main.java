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
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(8);

        System.out.print("chunks> ");
        int chunk = Integer.parseInt(scanner.nextLine());
        System.out.print("divider> ");
        int teiler = Integer.parseInt(scanner.nextLine());

        List<Integer> numbersList = einlesen(new File("C:\\Schule\\2021-22 KoglerD190073\\POS\\Uebungen\\KoglerD_UE4_11.10.21\\UE4_KoglerD\\numbers.csv"));

        int numbercount = numbersList.size();
        int countofNumsinSublist = numbercount/chunk;
        int up = numbercount/chunk;
        int down = 0;
        for (int i = 0; i < chunk-1; i++) {
            List<Integer> sublistNumbers = numbersList.subList(down, up);
            executor.execute(() -> {
                for (int j : sublistNumbers) {
                    if (j % teiler == 0) {
                        System.out.println(j);
                    }
                }
            });
            if (down <= numbercount-countofNumsinSublist && up <= numbercount){
            down += up--;
            up += up;}
        }
        executor.shutdown();
    }

    public static List<Integer> einlesen(File file) {
        List<Integer> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            String line = "";
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] split = line.split(":");
                for (int i = 0; i < split.length; i++) {
                    try {
                        if (split[i] != ":" || split[i] != null) {
                            list.add(Integer.parseInt(split[i]));
                        }
                    } catch (NumberFormatException nfe) {
                        split[i] = ":";
                    }
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not Found");
        }
        return list;
    }

    /*public static List<int[]> getielteListe(int anzahlZahlen, int chunks, int[] alleZahlen) {
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
    }*/

}
