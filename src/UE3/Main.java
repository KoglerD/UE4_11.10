package UE3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List strings = Arrays.asList("David", "Kogler", "", " ", "POS", "scHuLe", "", "1");
        System.out.println(getCountEmptyString(strings));
        System.out.println(getCountLenght(strings));
        System.out.println(deleteEmptyStrings(strings));
        System.out.println(getMergedString(strings, " "));
        List numbers = Arrays.asList(1, 2, 3, 5, 12, 568, 0);
        System.out.println(getSquares(numbers));
        System.out.println(getMax(numbers));
        System.out.println(getMin(numbers));
        System.out.println(getSum(numbers));
        System.out.println(getAverage(numbers));
    }

    //Liefert die Anzahl leerer Strings zurück
    private static int getCountEmptyString(List<String> strings){
        /*int countOfNullStrings = 0;
        for (String s:strings) {
            if (s.equals("")||s.equals(" ")||s == null){
                countOfNullStrings++;
            }
        }
        return countOfNullStrings;*/
        return (int) strings.stream().filter(s -> s.isEmpty()).count();
    }
    //Liefert alle Elemente mit einer Länge von 3 zurück
    private static int getCountLenght(List<String> strings){
        return (int)strings.stream().filter(s->s.length()==3).count();
    }
    //Löscht alle leeren Strings aus der Liste
    private static List<String> deleteEmptyStrings(List<String> strings){
        return strings.stream().filter(s -> s.length()!=0).collect(Collectors.toList());
    }
    //Verbindet alle Elemente in der Liste mit dem übergebenen String zu einem gemeinsamen String
    private static String getMergedString(List<String> strings, String separator){
        return strings.stream().map(s -> s.toString()).collect(Collectors.joining(separator));
    }
    //Liefert die Quadrate aller Elemente in der Liste
    private static List<Integer> getSquares(List<Integer> numbers){
        return numbers.stream().map(n -> (int)Math.pow(n,2)).collect(Collectors.toList());
    }
    //Liefert das Maximum aus der Liste
    private static int getMax(List<Integer> numbers){
        //Habe googlen müssen: https://www.baeldung.com/java-collection-min-max
        return numbers.stream().mapToInt(n -> n).max().orElseThrow();
    }
    //Liefert das Minimum aus der Liste
    private static int getMin(List<Integer> numbers){
        //Habe googlen müssen: https://www.baeldung.com/java-collection-min-max
        return numbers.stream().mapToInt(n -> n).min().orElseThrow();
    }
    //Liefert das Maximum aus der Liste
    private static int getSum(List<Integer> numbers){
        return numbers.stream().mapToInt(n -> n).sum();
    }
    //Liefert das Maximum aus der Liste
    private static int getAverage(List<Integer> numbers){
        return (int) numbers.stream().mapToInt(n->n).average().getAsDouble();
    }

}
