package UE2;

import java.util.ArrayList;
import java.util.List;

public class Task implements Runnable {

    private int ergebnis;
    private int zahl;
    private int max;
    private int min;

    public Task(int zahl) {
        this.min = 1;
        this.max = 100;
        this.zahl = zahl;
        ergebnis = 0;
    }

    @Override
    public void run() {
        if (max <= zahl) {
            for (int i = min; i < max; i++) {
                ergebnis += i;
            }
        }else{
            for (int i = min; i < zahl; i++) {
                ergebnis += i;
            }
        }
        min = max;
        max += 100;
        System.out.println(ergebnis);
    }

    public int getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(int ergebnis) {
        this.ergebnis = ergebnis;
    }

    public int getZahl() {
        return zahl;
    }

    public void setZahl(int zahl) {
        this.zahl = zahl;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
