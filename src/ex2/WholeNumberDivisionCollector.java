package ex2;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by david on 07/12/17.
 */
public class WholeNumberDivisionCollector {
    public static Collector<Integer, Integer, Integer> collector(Integer[] values) {
        return new Collector<Integer, Integer, Integer>() {

            private final Integer[] listValues = values;

            @Override
            public Supplier<Integer> supplier() {
                return () -> new Integer(0);
            }

            @Override
            public BiConsumer<Integer, Integer> accumulator() {
                return (result, subject) -> {
                    result += Arrays.asList(listValues).stream().collect(Collectors.summingInt(
                            value -> {
                                Integer subject2 = (Integer)value;
                                Integer max = subject > subject2 ? subject : subject2;
                                Integer min = subject > subject2 ? subject2 : subject;
                                if(max % min == 0 && max != min){
                                    return max / min;
                                }
                                return 0;
                            }
                    ));
                };
            }

            @Override
            public BinaryOperator<Integer> combiner() {
                return (left, right) -> left;
            }

            @Override
            public Function<Integer, Integer> finisher() {
                return integer -> integer;
            }

            @Override
            public Set<Characteristics> characteristics() {
                return EnumSet.of(Characteristics.UNORDERED);
            }
        };
    }
}
