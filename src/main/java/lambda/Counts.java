package lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@ToString
public class Counts {
    int numberOfNegative;
    int numberOfPositive;
    int numberOfZero;

    public void clarify(int number) {
        if (number<0) numberOfNegative++;
        else if (number>0) numberOfPositive++;
        else numberOfZero++;
    }

    public Counts addAll(Counts counts) {
        numberOfPositive += counts.numberOfPositive;
        numberOfNegative += counts.numberOfNegative;
        numberOfZero += counts.numberOfZero;
        return this;
    }

    public static Collector<Integer, Counts, Counts> count() {
        return Collector.of(Counts::new, Counts::clarify, Counts::addAll);
    }
}
