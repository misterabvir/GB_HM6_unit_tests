# tests/test_list_comparator.py

import pytest

from src.list_comparator import ListComparator


def test_compare_averages_with_empty_lists():
    """
    Test when one or both lists have a length of zero.
    """
    with pytest.raises(ZeroDivisionError):
        ListComparator([], [1, 2, 3]).compare_averages()

    with pytest.raises(ZeroDivisionError):
        ListComparator([1, 2, 3], []).compare_averages()

    with pytest.raises(ZeroDivisionError):
        ListComparator([], []).compare_averages()


def test_non_numeric_elements():
    """
    Test when one or both lists contain non-numeric elements.
    """
    with pytest.raises(TypeError):
        ListComparator([1, 2, 'three'], [4, 5, 6]).compare_averages()

    with pytest.raises(TypeError):
        ListComparator([1, 2, 'three'], [4, 5, 'six']).compare_averages()


def test_compare_averages_with_equal_averages():
    """
    Test the compare_averages method when the average values are equal.
    """
    lc = ListComparator([1, 2, 6], [4, 3, 2])
    result = lc.compare_averages()
    assert result == "The average values are equal"


def test_compare_averages_with_first_list_higher_average():
    """
    Test the compare_averages method when the first list has a higher average.
    """
    lc = ListComparator([4, 5, 6], [1, 2, 3])
    result = lc.compare_averages()
    assert result == "The first list has a higher average value"


def test_compare_averages_with_second_list_higher_average():
    """
    Test the compare_averages method when the second list has a higher average.
    """
    lc = ListComparator([1, 2, 3], [4, 5, 6])
    result = lc.compare_averages()
    assert result == "The second list has a higher average value"
