package UE1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task  implements Runnable{
    private int numberCount;
    private int chunks;
    private int divider;
    private List<Integer> numbers;

    public Task(int numberCount, int divider, int chunks) {
        this.numberCount = numberCount;
        this.divider = divider;
        this.numbers = numbers;
        this.chunks = chunks;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = einlesen(new File("C:\\Schule\\2021-22 KoglerD190073\\POS\\Uebungen\\KoglerD_UE4_11.10.21\\UE4_KoglerD\\numbers.csv"));

        int zahlInsgesamt = 0;
        for (int i : list) {
            //zahlInsgesamt++;
            if (i % divider == 0) {
                System.out.println(i);
                zahlInsgesamt++;
            }
        }
        System.out.println("Anzahl Zahlen: "+zahlInsgesamt);
    }

    public List<Integer> einlesen(File file) {
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
}
