package ex2;

import helpers.MatrixReader;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by david on 06/12/17.
 */
public class Ex2 {

    private static final Integer[][] INPUT = MatrixReader.readMatrix(Ex2.class);

    public static void exec1(){
        Long output = Arrays.stream(INPUT).collect(Collectors.summarizingInt(rowValues -> {
            Integer max = Arrays.stream(rowValues).mapToInt(Integer::intValue).max().getAsInt();
            Integer min = Arrays.stream(rowValues).mapToInt(Integer::intValue).min().getAsInt();
            Integer diff = max - min;
            return diff;
        })).getSum();
        System.out.println("Ex2.1: " + output);
    }

    public static void exec2(){
        Long output = Arrays.stream(INPUT).collect(
                Collectors.summarizingInt(
                        rowValues -> Arrays.stream(rowValues).collect(WholeNumberDivisionCollector.collector(rowValues)).intValue()
                )
        ).getSum();
        System.out.println("Ex2.2: " + output);
    }
}
