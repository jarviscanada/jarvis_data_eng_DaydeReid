package ca.jrvs.practice.codingChallenge;

import java.util.Collections;
import java.util.List;

/**
 * Class containing functions to find the largest/smallest value in a List.
 * Relevant Ticket: https://www.notion.so/Find-Largest-Smallest-5b2da29a8c0c460c8259034c97359339
 */
public class LargestSmallest {

  /**
   * Find the largest value in the list using a for loop
   * Time Complexity: O(n)
   * Justification: Single loop through all values
   */
  public Integer getLargestLoop(List<Integer> list) {
    Integer max = null;
    for (Integer i : list) {
      if (max == null || i > max)
        max = i;
    }
    return max;
  }

  /**
   * Find the smallest value in the list using a for loop
   * Time Complexity: O(n)
   * Justification: Single loop through all values
   */
  public Integer getSmallestLoop(List<Integer> list) {
    Integer min = null;
    for (Integer i : list) {
      if (min == null || i < min)
        min = i;
    }
    return min;
  }

  /**
   * Find the largest value in the list using Java streams
   * Time Complexity: O(n)
   * Justification: Streams use generic iteration, so same as a loop
   */
  public Integer getLargestStream(List<Integer> list) {
    return list.stream().reduce(null, (max, i) -> {
      if (max == null || i > max)
        return i;
      else
        return max;
    });
  }

  /**
   * Find the smallest value in the list using Java streams
   * Time Complexity: O(n)
   * Justification: Streams use generic iteration, so same as a loop
   */
  public Integer getSmallestStream(List<Integer> list) {
    return list.stream().reduce(null, (min, i) -> {
      if (min == null || i < min)
        return i;
      else
        return min;
    });
  }

  /**
   * Find the largest value in the list using the Collections API
   * Time Complexity: O(n)
   * Justification: Collections.max has O(n) time for lists
   */
  public Integer getLargestApi(List<Integer> list) {
    return Collections.max(list);
  }

  /**
   * Find the smallest value in the list using the Collections API
   * Time Complexity: O(n)
   * Justification: Collections.min has O(n) time for lists
   */
  public Integer getSmallestApi(List<Integer> list) {
    return Collections.min(list);
  }
}
