package hm;

import java.util.List;

/**
 * The Package.ListComparator class is designed to compare the average values of two lists of integers.
 * It provides methods to calculate the average of each list and determine which list has a higher average.
 */
public class ListComparator {
    // Constants for error messages and result descriptions
    static final String ZERO_EXCEPTION_MESSAGE = "Cannot calculate the average of an empty list";
<<<<<<< HEAD
    static final String NULL_REFERENCE_EXCEPTION_MESSAGE = "Cannot calculate the average of null";
=======
>>>>>>> dc5a0198b2dd8aa7c46f1431e8d4ab98893b3f6e
    static final String FIRST_LIST_AVG_HIGHER = "The first list has a higher average value";
    static final String SECOND_LIST_AVG_HIGHER = "The second list has a higher average value";
    static final String LIST_ARE_EQUAL = "The average values are equal";

    private final List<Integer> first;
    private final List<Integer> second;

    /**
     * Constructs a Package.ListComparator with two input lists to be compared.
     *
     * @param first  The first list of integers.
     * @param second The second list of integers.
     */
    public ListComparator(List<Integer> first, List<Integer> second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Calculates the average value of a list of integers.
     *
     * @param data The list of integers for which to calculate the average.
     * @return The average value of the input list.
     * @throws ArithmeticException If the input list is empty, it throws an exception with an error message.
     */
    private double calculateAverage(List<Integer> data) {
<<<<<<< HEAD
        if (data == null) {
            throw new NullPointerException(NULL_REFERENCE_EXCEPTION_MESSAGE);
        }
        if (data.isEmpty()) {
            throw new ArithmeticException(ZERO_EXCEPTION_MESSAGE);
        }
        double sum = data.stream().mapToInt(Integer::intValue).sum();
        double length = data.size();
=======
        double sum = data.stream().mapToInt(Integer::intValue).sum();
        double length = data.size();
        if (length == 0) {
            throw new ArithmeticException(ZERO_EXCEPTION_MESSAGE);
        }
>>>>>>> dc5a0198b2dd8aa7c46f1431e8d4ab98893b3f6e
        return sum / length;
    }

    /**
     * Compares the average values of the two input lists and returns a description of the result.
     *
     * @return A string describing the comparison result:
     * - "The first list has a higher average value" if the first list's average is greater.
     * - "The second list has a higher average value" if the second list's average is greater.
     * - "The average values are equal" if the averages are equal.
     */
    public String compareAverages() {
        double averageFirst = calculateAverage(first);
        double averageSecond = calculateAverage(second);

        if (averageFirst > averageSecond) {
            return FIRST_LIST_AVG_HIGHER;
        } else if (averageFirst < averageSecond) {
            return SECOND_LIST_AVG_HIGHER;
        }
        return LIST_ARE_EQUAL;
    }
}
