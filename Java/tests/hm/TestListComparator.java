package hm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestListComparator {
    private ListComparator comparator;

    /**
<<<<<<< HEAD
     * Test case for comparing empty lists and expecting an ArithmeticException with a specific message.
=======
     * Test case for comparing empty lists and
     * expecting an ArithmeticException with a specific message.
>>>>>>> dc5a0198b2dd8aa7c46f1431e8d4ab98893b3f6e
     */
    @Test
    void testNegativeEmptyList() {
        List<Integer> empty1 = new ArrayList<>();
        List<Integer> empty2 = new ArrayList<>();
        List<Integer> notEmpty = Arrays.asList(1, 2, 3);
        String expected = ListComparator.ZERO_EXCEPTION_MESSAGE;

        comparator = new ListComparator(empty1, empty2);
        Throwable throwable = assertThrows(ArithmeticException.class, () -> comparator.compareAverages());
        assertThat(throwable.getMessage()).isEqualTo(expected);

        comparator = new ListComparator(notEmpty, empty2);
        throwable = assertThrows(ArithmeticException.class, () -> comparator.compareAverages());
        assertThat(throwable.getMessage()).isEqualTo(expected);

        comparator = new ListComparator(empty1, notEmpty);
        throwable = assertThrows(ArithmeticException.class, () -> comparator.compareAverages());
        assertThat(throwable.getMessage()).isEqualTo(expected);
    }

    /**
<<<<<<< HEAD
     * Test case for comparing nullable list and
     * expecting an NullPointerException with a specific message.
     */
    @Test
    void testNegativeNullList() {
        List<Integer> notNullList = Arrays.asList(1, 2, 3);
        String expected = ListComparator.NULL_REFERENCE_EXCEPTION_MESSAGE;

        comparator = new ListComparator(null, null);
        Throwable throwable = assertThrows(NullPointerException.class, () -> comparator.compareAverages());
        assertThat(throwable.getMessage()).isEqualTo(expected);

        comparator = new ListComparator(null, notNullList);
        throwable = assertThrows(NullPointerException.class, () -> comparator.compareAverages());
        assertThat(throwable.getMessage()).isEqualTo(expected);

        comparator = new ListComparator(notNullList, null);
        throwable = assertThrows(NullPointerException.class, () -> comparator.compareAverages());
        assertThat(throwable.getMessage()).isEqualTo(expected);
    }

    /**
     * Test case for comparing lists where the average of the first list is higher than the second list.
=======
     * Test case for comparing lists
     * where the average of the first list is higher than the second list.
>>>>>>> dc5a0198b2dd8aa7c46f1431e8d4ab98893b3f6e
     */
    @Test
    void testPositiveFirstListAverageHigherThanSecond() {
        List<Integer> less = Arrays.asList(1, 2, 3);
        List<Integer> high = Arrays.asList(4, 9, 2);
        String expected = ListComparator.FIRST_LIST_AVG_HIGHER;
        comparator = new ListComparator(high, less);

        String actual = comparator.compareAverages();

        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Test case for comparing lists
     * where the average of the second list is higher than the first list.
     */
    @Test
    void testPositiveFirstListAverageLessThanSecond() {
        List<Integer> less = Arrays.asList(1, 2, 3);
        List<Integer> high = Arrays.asList(4, 9, 2);
        String expected = ListComparator.SECOND_LIST_AVG_HIGHER;
        comparator = new ListComparator(less, high);

        String actual = comparator.compareAverages();

        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Test case for comparing lists with equal averages.
     */
    @Test
    void testPositiveEqualListAverages() {
        List<Integer> first = Arrays.asList(1, 2, 3);
        List<Integer> second = Arrays.asList(1, 2, 3);
        String expected = ListComparator.LIST_ARE_EQUAL;
        comparator = new ListComparator(first, second);

        String actual = comparator.compareAverages();

        assertThat(actual).isEqualTo(expected);
    }
}
