package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectMain {




    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        System.out.println(numbers.stream().reduce(0, (x,y) -> x+y, (x,y)-> x+y));

        String s = "xxXyyxXXyzz";
        // Egy utasítás: melyik karakter hányszor szerepel

        System.out.println(Arrays.stream(s.split("")).collect(Collectors.groupingBy(
                str -> str.toLowerCase(),
                Collectors.counting()
                )));

        System.out.println(
                s.chars()
                        .mapToObj(i->(char)i)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting())));


        var numberCounts = List.of(-4, -5, -6, 0, 4, 5, 6,7,0);
        System.out.println(numberCounts.stream().collect(
                Counts::new,
                Counts::clarify,
                Counts::addAll
        ));
        System.out.println(numberCounts.stream().collect(Counts.count()));
    }
}
