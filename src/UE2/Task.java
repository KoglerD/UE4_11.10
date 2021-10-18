package UE2;

import java.util.ArrayList;
import java.util.List;

public class Task implements Runnable{

    private int ergebnis;
    private int zahl;
    private int von;
    private int bis;
    private List<Integer> numbers;

    public Task(int zahl, int von, int bis){
        this.zahl = zahl;
        this.von = von;
        this.bis = bis;
        this.numbers = new ArrayList<>();
        for (int i = 1; i < zahl; i++) {
            numbers.add(i);
        }

    }

    public Task(int zahl){
        this.zahl = zahl;
        this.numbers = new ArrayList<>();
        for (int i = 1; i < zahl; i++) {
            numbers.add(i);
        }

    }

    @Override
    public void run() {
        int z = subListSumme();
        ergebnis = (int) (Math.pow(z, 2) + z) / 2;
        System.out.println(ergebnis);
    }

    public int subListSumme(){
        int sum = 0;
        List<Integer> subListNums = numbers.subList(0, numbers.size());
        if (bis != 0) {
            subListNums = numbers.subList(von, bis--);
        }
        for (int i = 0; i < subListNums.size()-1; i++) {
            sum += subListNums.get(i);
        }

        return sum;
    }
}
