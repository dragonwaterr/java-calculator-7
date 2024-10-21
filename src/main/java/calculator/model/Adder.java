package calculator.model;

import java.util.HashSet;
import java.util.Set;

public class Adder {
    private Adder() {}

    public static int makeResult(String input, String customSeperator) {
        Set<Integer> numberSet = makeResultSet(input, customSeperator);
        return calculate(numberSet);
    }

    private static Set<Integer> makeResultSet(String input, String customSeperator) {
        Set<Integer> numberSet = new HashSet<>();

        String[] splitResult = splitWithSeperators(input, customSeperator);
        for(String num : splitResult) {
            numberSet.add(Integer.parseInt(num));
        }

        return numberSet;
    }

    private static String[] splitWithSeperators(String input, String customSeperator) {
        if(!customSeperator.equals("")) {
            input = input.substring(5);
        }

        String seperators = "[:," + customSeperator + "]";
        return input.split(seperators);
    }

    private static int calculate(Set<Integer> numberSet) {
        int sum = 0;
        for(int num : numberSet) {
            sum += num;
        }

        return sum;
    }
}
