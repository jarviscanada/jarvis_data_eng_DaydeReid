package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Class containing functions determine the missing number in a list of numbers from 1 to n
 * Relevant Ticket: https://www.notion.so/Missing-Number-6a92b7cddb424d08abe697d3a58da300
 */
public class MissingNumber {


  /**
   * Determine the missing number by summing up the values and subtracting that from the expected sum
   * Time Complexity: O(n)
   * Justification: Need to sum up n+1 values to get expected sum, and n values to get the actual sum
   */
  public int missingNumberSum(int[] numbers) {
    int expected = IntStream.rangeClosed(0, numbers.length).sum();
    int actual = Arrays.stream(numbers).sum();
    return expected - actual;
  }

  /**
   * Determine the missing number by adding all the numbers into a set and checking the set for each number in order
   * Time Complexity: O(n)
   * Justification: Need to sum add all n numbers to the set then check for the existence of n+1
   */
  public int missingNumberSet(int[] numbers) {
    Set<Integer> set = new HashSet<>();
    for(int i : numbers) {
      set.add(i);
    }
    for(int i = 0; i <= numbers.length; i ++) {
      if(!set.contains(i))
        return i;
    }
    return -1;
  }

  /**
   * Determine the missing number using Gauss' Formula
   * Time Complexity: O(n)
   * Justification: Constant time Gauss calculation and then summing n numbers
   */
  public int missingNumberGauss(int[] numbers) {
    int expected = (numbers.length * (numbers.length + 1)) / 2;
    int actual = Arrays.stream(numbers).sum();
    return expected - actual;
  }
}
