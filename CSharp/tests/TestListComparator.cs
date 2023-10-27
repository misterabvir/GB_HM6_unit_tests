using NUnit.Framework;

namespace ListComaparatorWithTests;

public class TestListComparator
{

    /// <summary>
    /// Test case for comparing empty lists and expecting an ArithmeticException with a specific message.
    /// </summary>
    [Test]
    public void TestNegativeEmptyList()
    {
        List<int> empty = [];
        List<int> notEmpty = [1, 2, 3];

        string expected = ListComparator.ZERO_EXCEPTION_MESSAGE;

        ListComparator comparator = new(empty, empty);
        string actual = Assert.Throws<ArgumentException>(() => comparator.CompareAverages()).Message;
        Assert.That(actual, Is.EqualTo(expected));

        comparator = new(empty, notEmpty);
        actual = Assert.Throws<ArgumentException>(() => comparator.CompareAverages()).Message;
        Assert.That(actual, Is.EqualTo(expected));

        comparator = new(notEmpty, empty);
        actual = Assert.Throws<ArgumentException>(() => comparator.CompareAverages()).Message;
        Assert.That(actual, Is.EqualTo(expected));
    }

    /// <summary>
    ///  Test case for comparing nullable list and and expecting an NullReferenceException with a specific message.
    /// </summary>
    [Test]
    public void TestNegativeNullList()
    {
        List<int> notNull = [1, 2, 3];

        string expected = ListComparator.NULL_REFERENCE_EXCEPTION_MESSAGE;

        ListComparator comparator = new(null, null);
        string actual = Assert.Throws<NullReferenceException>(() => comparator.CompareAverages()).Message;
        Assert.That(actual, Is.EqualTo(expected));

        comparator = new(null, notNull);
        actual = Assert.Throws<NullReferenceException>(() => comparator.CompareAverages()).Message;
        Assert.That(actual, Is.EqualTo(expected));

        comparator = new(notNull, null);
        actual = Assert.Throws<NullReferenceException>(() => comparator.CompareAverages()).Message;
        Assert.That(actual, Is.EqualTo(expected));
    }

    /// <summary>
    /// Test case for comparing lists where the average of the first list is higher than the second list.
    /// </summary>
    [Test]
    public void TestPositiveFirstListAverageHigherThanSecond()
    {
        List<int> high = [4, 5, 6];
        List<int> less = [1, 2, 3];

        string expected = ListComparator.FIRST_LIST_AVG_HIGHER;

        ListComparator comparator = new(high, less);

        string actual = comparator.CompareAverages();
        Assert.That(actual, Is.EqualTo(expected));
    }

    /// <summary>
    /// Test case for comparing lists here the average of the second list is higher than the first list.
    /// </summary>
    [Test]
    public void TestPositiveFirstListAverageLessThanSecond()
    {
        List<int> high = [4, 5, 6];
        List<int> less = [1, 2, 3];

        string expected = ListComparator.SECOND_LIST_AVG_HIGHER;

        ListComparator comparator = new(less, high);

        string actual = comparator.CompareAverages();
        Assert.That(actual, Is.EqualTo(expected));

    }


    /// <summary>
    /// Test case for comparing lists with equal averages.
    /// </summary>
    [Test]
    public void TestPositiveEqualListAverages()
    {
        List<int> first = [1, 2, 3];
        List<int> second = [1, 2, 3];

        string expected = ListComparator.LIST_ARE_EQUAL;

        ListComparator comparator = new(first, second);

        string actual = comparator.CompareAverages();
        Assert.That(actual, Is.EqualTo(expected));
    }
}