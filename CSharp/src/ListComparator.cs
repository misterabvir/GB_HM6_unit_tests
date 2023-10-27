namespace ListComaparatorWithTests;

/// <summary>
///  The Package.ListComparator class is designed to compare the average values of two lists of integers.
///  It provides methods to calculate the average of each list and determine which list has a higher average.
/// </summary>
/// <param name="first">The first list of integers</param>
/// <param name="second">The second list of integers</param>
internal class ListComparator(List<int> first, List<int> second)
{
    public const string ZERO_EXCEPTION_MESSAGE = "Cannot calculate the average of an empty list";
    public const string NULL_REFERENCE_EXCEPTION_MESSAGE = "Cannot calculate the average of an nullable";
    public const string FIRST_LIST_AVG_HIGHER = "The first list has a higher average value";
    public const string SECOND_LIST_AVG_HIGHER = "The second list has a higher average value";
    public const string LIST_ARE_EQUAL = "The average values are equal";
    
    /// <summary>
    /// Calculates the average value of a list of integers.
    /// </summary>
    /// <param name="data">The list of integers for which to calculate the average.</param>
    /// <returns>The average value of the input list.</returns>
    /// <exception cref="NullReferenceException">If the input list is null, it throws an exception with an error message.</exception>
    /// <exception cref="ArgumentException">If the input list is empty, it throws an exception with an error message.</exception>
    private static double CalculateAverage(List<int> data)
    {
        if (data is null)
        {
            throw new NullReferenceException(NULL_REFERENCE_EXCEPTION_MESSAGE);
        }
        if (data.Count == 0)
        {
            throw new ArgumentException(ZERO_EXCEPTION_MESSAGE);
        }
        return data.Average();
    }

    /// <summary>
    /// Compares the average values of the two input lists and returns a description of the result.
    /// </summary>
    /// <returns>
    /// - "The first list has a higher average value" if the first list's average is greater.  <br/>
    /// - "The second list has a higher average value" if the second list's average is greater.  <br/>
    /// - "The average values are equal" if the averages are equal.
    /// </returns>
    public string CompareAverages()
    {
        double averageFirst = CalculateAverage(first);
        double averageSecond = CalculateAverage(second);

        if (averageFirst > averageSecond)
        {
            return FIRST_LIST_AVG_HIGHER;
        }
        else if(averageSecond > averageFirst)
        {
            return SECOND_LIST_AVG_HIGHER;
        }
        return LIST_ARE_EQUAL;
    }
}
