package UE2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);

        Task task = new Task(210);
        int ergebnis = 0;
        while (task.getMax() <= task.getZahl()){
            executor.execute(task);
            ergebnis += task.getErgebnis();
        }
        executor.shutdown();
        System.out.println(ergebnis);
    }
}
