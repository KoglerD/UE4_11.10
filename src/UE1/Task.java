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

    }

}
