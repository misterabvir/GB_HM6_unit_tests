# src/list_comparator.py
class ListComparator:
    """
    A class for comparing and calculating averages of lists.
    Attributes:
        first (list): The first list for comparison.
        second (list): The second list for comparison.
    
    Methods:
        calculate_average(data: list) -> float:
            Calculate the average of a given list.
        compare_averages(self) -> str:
            Compare the average values of the two lists and return a comparison result.
    """

    def __init__(self, first: list, second: list):
        """
        Initializes a ListComparator instance with two data lists.
        
        Args:
            first (list): The first list for comparison.
            second (list): The second list for comparison.
        """
        self.first: list = first
        self.second: list = second

    @staticmethod
    def calculate_average(data: list) -> float:
        """
        Calculate the average of a given list.

        Args:
            data (list): The list for which the average will be calculated.

        Returns:
            float: The average value of the input list.
        """
        if len(data) == 0:
            raise ZeroDivisionError("Cannot calculate the average of an empty list")
        return sum(data) / len(data)

    def compare_averages(self) -> str:
        """
        Compare the average values of the two lists and return a comparison result.

        This method calculates the average values of the two lists provided during
        class initialization and compares them. It returns a string indicating whether
        the first list has a higher average, the second list has a higher average, or
        if the average values are equal.

        Returns:
            str: A comparison result string.
        """

        average_first = self.calculate_average(self.first)
        average_second = self.calculate_average(self.second)

        if average_first > average_second:
            return "The first list has a higher average value"
        elif average_first < average_second:
            return "The second list has a higher average value"
        else:
            return "The average values are equal"
